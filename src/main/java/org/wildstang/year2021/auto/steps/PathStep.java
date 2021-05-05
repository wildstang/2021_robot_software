package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.year2021.subsystems.Drive; 
import org.wildstang.framework.timer.WsTimer;


/**
This is a flexible drive step that tries to follow a path, given by two arrays containing points and an array containing angles the robot should be at.
Also array containing speedconstants as percent of max speed
A gyroscope would improve accuracy, not implememnted here.
I doubt it will be able to correctly follow long paths, but should be able to correctly preform smaller manuvers?
Also will not necasarilly travel in strait lines, so perhaps shouldnt drive to close to wall.
Angles are in radians!!!
Mesurements are in feet.
*/
public class PathStep extends AutoStep {

    WsTimer timer = new WsTimer();
    Drive Driver = new Drive();
    private double PI = Math.PI;
    //paramaters
    public double MaxSpeed = 5; //obsolete?
    public double AcceptableRadius =  0.1; 
    public double AcceptableHeadingError =  PI/32; //5.625 degrees
    public double RobotWidth =  1.34733441667; //ish
    public double WheelRadius = 0.5; //Fix this value
    
    public double SpeedConstant;
    
    // to keep track of position and heading
    public double X = 0; 
    public double Y = 0;
    public double Heading = 0; 
    public double NewAngle = 0;
    public double Angle;
    //path data
    //these are global varibles within the class, right? otherwise most of these need to be public or fed through functions.
    private double[] Xs;
    private double[] Ys;
    private double[] As;
    private double[] Vs;
    private int Counter = 1; //index of next point
    //other stuff
    private double DeltaX = 0; 
    private double DeltaY = 0;
    private boolean First;
    private double lastTime = 0;
    private double ExDt;
   // private double OtherConstant = 0.5;
    private double[] LastEncPos = {0,0};

    public void PathStep(double[] Xpts, double[] Ypts, double[] Angles,double[] Speeds){
        Xs = Xpts;
        Ys = Ypts;
        As = Angles;
        Vs = Speeds;
        Heading = Math.tan(As[0]); // initial position and heading given by first elements of Xs,Ys,DyDx
        Y = Ys[0];
        X = Xs[0];  
        Angle = As[0];
        SpeedConstant = Vs[1]; //speed with which to go to first point
    }

    @Override
    public void initialize() {
        ExDt = 0.01; //???
        Driver.leftSpeed = 0;
        Driver.rightSpeed = 0;
        timer.start();
        Counter = 1;
        Heading = Math.tan(As[0]); // initial position and heading given by first elements of Xs,Ys,DyDx
        Y = Ys[0];
        X = Xs[0];  
        First = true; 
        lastTime = 0;
        LastEncPos[0] = Driver.GetLeftEncoder();
        LastEncPos[1] = Driver.GetRightEncoder();
       // OtherConstant = 0.5;
    }
    private void UpdatePosAndHeading(double Dt){ //use circles and change in time to update position and heading
       // double Dtheta = (MaxSpeed*Dt)*(Driver.rightSpeed - Driver.leftSpeed)/RobotWidth;
        double RightArcL = 2*PI*WheelRadius*((Driver.GetRightEncoder()- LastEncPos[1])/1024);
        double LeftArcL = 2*PI*WheelRadius*((Driver.GetRightEncoder()- LastEncPos[0])/1024);
        double Dtheta = (RightArcL-LeftArcL)/RobotWidth;
        NewAngle = Angle+Dtheta ;
        double Dist = (LeftArcL) + (Dtheta*RobotWidth*0.5);
        double Theta = Angle;
        double NewTheta = NewAngle;
        if (Dtheta != 0){ //to prevent division by zero
            double Radius = (LeftArcL/Dtheta);
            DeltaX = Radius*(Math.cos(NewTheta)-Math.cos(Theta));
            DeltaY = Radius*(Math.sin(NewTheta)-Math.sin(Theta));
        }
        else{//strait line b/c no change in angle
            DeltaX = Dist*Math.cos(NewAngle);
            DeltaY = Dist*Math.sin(NewAngle);
        }
        X += DeltaX;
        Y += DeltaY;
        Angle = NewAngle;
        if(Angle>2*PI){
            Angle = Angle-2*PI;
        }
        if(Angle<0){
            Angle = Angle+2*PI;
        }
    }
    private void CheckPoint(){
        double Distance = Math.sqrt(Math.pow(X-Xs[Counter],2)+Math.pow(Y-Ys[Counter],2));
        double HeadErr = Math.abs(Angle-As[Counter]);
        if ((HeadErr<AcceptableHeadingError)&&(Distance<AcceptableRadius)){
            Counter += 1;
            SpeedConstant = Vs[Counter];
        }
    }
    private void OutputUpdate(double Dt){  
        //no longer set to take trinomial paths between points.
        //Dt is the expected time between updates
        double DiffX = Xs[Counter]-X;
        double DiffY = Ys[Counter]-Y;
        double DiffH = As[Counter]-Angle;

        double Dist = Math.sqrt(Math.pow(DiffX,2)+Math.pow(DiffY,2));
        double DDx = -1*Math.cos(As[Counter])*Dist*0.5; //aim for point offset from target to get approach angle.
        double DDy = Math.tan(As[Counter])*DDx;
        DiffX += DDx;
        DiffY += DDy;
        //double D = Y;
        //double C = Heading;
        //double A = -2*((DiffY/Math.pow(DiffX,3))-(Heading/Math.pow(DiffX,2))-(DiffH/(2*Math.pow(DiffX,2))));
        //that seems really random, but math, unless I did something wrong.
       // double B = 0.5*((DiffH/DiffX)-(3*A*DiffX));
      //  double D2yDx2 = B*2;
        //Ax^3+Bx^2+Cx+D = y, x=0 is current x
        // DyDx = 3Ax^2 +2Bx + C
        //This rough approximation is probably wrong and/or horribly inefficient:
        double ExDeltaX = MaxSpeed*SpeedConstant*Dt/(Math.sqrt(1+Math.pow(Math.tan(Angle),2)));
        if((Angle)>(PI/2)&&(Angle<(1.5*PI))){
            ExDeltaX = -1*ExDeltaX; 
        }
        double ExDeltaY = Math.tan(Angle)*ExDeltaX;
       // double ExDeltaX = Math.tan(Heading)*((Driver.leftSpeed*MaxSpeed*Dt)+(RobotWidth/2))/(Math.sqrt(Math.pow(Heading,2)+1));
      //  double HeadingGoal = (3*A*Math.pow(ExDeltaX,2))+(2*B*ExDeltaX)+C;
        double Dist2Pos = Math.sqrt(Math.pow(ExDeltaX,2)+Math.pow(ExDeltaY,2));
        double Dist2Go = Math.sqrt(Math.pow(ExDeltaX-DiffX,2)+Math.pow(ExDeltaY-DiffY,2));
        double WeightToGo = (1/Math.pow(Dist2Go,2));
        double WeightFromPos = (1/Math.pow(Dist2Pos,2));
        double NormWeight = WeightToGo/(WeightToGo+WeightFromPos);
        double ThetaGoal = ((1-NormWeight)*Angle)+(NormWeight*Math.atan(DiffY/DiffX));
        double DeltaThetaGoal = ThetaGoal-Angle;
        //double DthDt = DeltaThetaGoal/Dt;
        double TurnRadius = (MaxSpeed*SpeedConstant*Dt/DeltaThetaGoal)-(RobotWidth/2);
        double L = DeltaThetaGoal*TurnRadius/(MaxSpeed*SpeedConstant*Dt);
        double R = DeltaThetaGoal*(TurnRadius+RobotWidth)/(MaxSpeed*SpeedConstant*Dt);
        Driver.leftSpeed = L;
        Driver.rightSpeed = R;

    }
    @Override
    public void update(){
        if (!First){
            double Dt = timer.get()-lastTime;
            ExDt = ((ExDt*9)+Dt)/10; //running avg of update time
            UpdatePosAndHeading(Dt);
        }
        else{
            First = false;
        }
        lastTime = timer.get();
        CheckPoint();
        if(Counter >= Xs.length){
            Driver.leftSpeed = 0; //stop if done with path
            Driver.rightSpeed = 0;
            Driver.update();
            setFinished(true);
            
        }
        else{
        OutputUpdate(ExDt);
        Driver.update(); // move the robot :)
        }
        LastEncPos[0] = Driver.GetLeftEncoder();
        LastEncPos[1] = Driver.GetRightEncoder();

    }
    @Override
    public String toString() {
        return "PathStep";
    }

}
