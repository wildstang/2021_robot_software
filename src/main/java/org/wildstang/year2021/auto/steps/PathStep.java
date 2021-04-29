package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.subsystems.Drive;
import org.wildstang.framework.timer.WsTimer;


/**
This is a flexible drive step that tries to follow a path, given by two arrays containing points and an array containing DyDxs for angle robot should be at.
A gyroscope would improve accuracy, not implememnted here.
I doubt it will be able to correctly follow long paths, but should be able to correctly preform smaller manuvers?
Also will not necasarilly travel in strait lines, so perhaps shouldnt drive to close to wall.
Note: headings are set up as slopes, not angles.
*/
public class PathStep extends AutoStep {

    WsTimer timer = new WsTimer();
    Drive Driver = new Drive();
    //paramaters
    public double MaxSpeed = 20; //Fix this value
    public double AcceptableRadius =  0.1;
    public double AcceptableHeadingError =  0.1;
    public double RobotWidth =  0.5; //Fix this value.
    
    public double SpeedConstant =  0.05; //later should be replaced with array like headings

    // to keep track of position and heading
    public double X = 0; 
    public double Y = 0;
    public double Heading = 0; 
    public double NewHeading = 0;
    //path data
    //these are global varibles within the class, right? otherwise most of these need to be public or fed through functions.
    private double[] Xs;
    private double[] Ys;
    private double[] DyDx;
    private int Counter = 1; //index of next point
    //other stuff
    private double DeltaX = 0; 
    private double DeltaY = 0;
    private double PI = 3.1415;
    private boolean First;
    private double lastTime = 0;
    private double ExDt;
    private double OtherConstant = 0.5;

    public void initialize(double[] Xpts,double[] Ypts,double[] Dydxs) {
        ExDt = 0.01; //???
        Driver.leftSpeed = 0;
        Driver.rightSpeed = 0;
        timer.Start();
        Counter = 1;
        DyDx = Dydxs;
        Xs = Xpts;
        Ys = Ypts;
        Heading = DyDx[0]; // initial position and heading given by first elements of Xs,Ys,DyDx
        Y = Ys[0];
        X = Xs[0];  
        First = true; 
        lastTime = 0;
        OtherConstant = 0.5;
    }
    private void UpdatePosAndHeading(double Dt){ //use circles and change in time to update position and heading
        double Dtheta = (MaxSpeed*Dt)*(Driver.rightSpeed - Driver.leftSpeed)/RobotWidth;
        NewHeading = Math.tan(Math.atan(Heading)+Dtheta);
        double Dist = ((MaxSpeed*Dt)*Driver.leftSpeed) + (Dtheta*RobotWidth*0.5);
        double Theta = Math.atan(Heading);
        double NewTheta = Math.atan(NewHeading);
        if (Dtheta != 0){ //to prevent division by zero
            double Radius = (Driver.leftSpeed*(MaxSpeed)/Dtheta);
            DeltaX = Radius*(Math.cos(NewTheta)-Math.cos(Theta));
            DeltaY = Radius*(Math.sin(NewTheta)-Math.sin(Theta));
        }
        else{//strait line b/c no change in angle
            DeltaX = Dist*Math.cos(Heading);
            DeltaY = Dist*Math.sin(Heading);
        }
        X += DeltaX;
        Y += DeltaY;
        Heading = NewHeading;
    }
    private void CheckPoint(){
        double Distance = Math.sqrt(Math.pow(X-Xs[Counter],2)+Math.pow(Y-Ys[Counter],2));
        double HeadErr = Math.abs(Heading-DyDx[Counter]);
        if ((HeadErr<AcceptableHeadingError)&&(Distance<AcceptableRadius)){
            Counter += 1;
        }
    }
    private void OutputUpdate(double Dt){  
        //currently set to take trinomial paths between points
        //Dt is the expected between updates
        double DiffX = Xs[Counter]-X;
        double DiffY = Ys[Counter]-Y;
        double DiffH = DyDx[Counter]-Heading;
        double D = Y;
        double C = Heading;
        double A = -2*((DiffY/Math.pow(DiffX,3))-(Heading/Math.pow(DiffX,2))-(DiffH/(2*Math.pow(DiffX,2))));
        //that seems really random, but math, unless I did something wrong.
        double B = 0.5*((DiffH/DiffX)-(3*A*DiffX));
        double D2yDx2 = B*2;
        //Ax^3+Bx^2+Cx+D = y, x=0 is current x
        // DyDx = 3Ax^2 +2Bx + C
        //This rough approximation is probably wrong and/or horribly inefficient:
        double ExDeltaX = MaxSpeed*SpeedConstant*Dt/(Math.sqrt(1+Math.pow(Heading,2)));
       // double ExDeltaX = Math.tan(Heading)*((Driver.leftSpeed*MaxSpeed*Dt)+(RobotWidth/2))/(Math.sqrt(Math.pow(Heading,2)+1));
        double HeadingGoal = (3*A*Math.pow(ExDeltaX,2))+(2*B*ExDeltaX)+C;
        double DeltaThetaGoal = Math.atan(HeadingGoal)-Math.atan(Heading);
        double DthDt = DeltaThetaGoal/Dt;
        double RminusL = RobotWidth*DthDt/MaxSpeed;
        double L = -1*RminusL/2 + OtherConstant;
        double R = RminusL/2 + OtherConstant;



    }
    public void update() {
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

    }

    public String toString() {
        return "PathStep";
    }

}
