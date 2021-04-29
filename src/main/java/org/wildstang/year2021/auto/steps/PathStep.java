package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.auto.subsystems.Drive;
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
    public float MaxSpeed = 20; //Fix this value
    public float AcceptableRadius = 0.1;
    public float AcceptableHeadingError = 0.1;
    public float RobotWidth = 0.5; //Fix this value.
    
    public float SpeedConstant = 0.05; //later should be replaced with array like headings

    // to keep track of position and heading
    public float X = 0; 
    public float Y = 0;
    public float Heading = 0; 
    public float NewHeading = 0;
    //path data
    //these are global varibles within the class, right? otherwise most of these need to be public or fed through functions.
    private float[] Xs;
    private float[] Ys;
    private float[] DyDx;
    private int Counter = 1; //index of next point
    //other stuff
    private float DeltaX = 0; 
    private float DeltaY = 0;
    private float PI = 3.1415;
    private boolean First;
    private float lastTime = 0;
    private float ExDt;
    private float OtherConstant = 0.5;
    
    public void initialize(float[] Xpts,float[] Ypts,float[] Dydxs) {
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
    private void UpdatePosAndHeading(float Dt){ //use circles and change in time to update position and heading
        float Dtheta = (MaxSpeed*Dt)*(Driver.rightSpeed - Driver.leftSpeed)/RobotWidth;
        NewHeading = Math.tan(Math.atan(Heading)+Dtheta);
        float Dist = ((MAXspeed*Dt)*Driver.leftSpeed) + (Dtheta*RobotWidth*0.5);
        float Theta = Math.atan(Heading);
        float NewTheta = Math.atan(NewHeading);
        if (Dtheta != 0){ //to prevent division by zero
            float Radius = (Driver.leftSpeed*(MaxSpeed)/Dtheta);
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
        float Distance = Math.sqrt(Math.pow(X-Xs[Counter],2)+Math.Pow(Y-Ys[Counter],2));
        float HeadErr = Math.abs(Heading-DyDx[Counter]);
        if ((HeadErr<AcceptableHeadingError)&&(Distance<AcceptableRadius)){
            Counter += 1;
        }
    }
    private void OutputUpdate(float Dt){  
        //currently set to take trinomial paths between points
        //Dt is the expected between updates
        float DiffX = Xs[Counter]-X;
        float DiffY = Ys[Counter]-Y;
        float DiffH = DyDx[Counter]-Heading;
        float D = Y;
        float C = Heading;
        float A = -2*((DiffY/Math.pow(DiffX,3))-(Heading/Math.pow(DiffX,2))-(DiffH/(2*Math.pow(DiffX,2))));
        //that seems really random, but math, unless I did something wrong.
        float B = 0.5*((DiffH/DiffX)-(3*A*DiffX));
        float D2yDx2 = B*2;
        //Ax^3+Bx^2+Cx+D = y, x=0 is current x
        // DyDx = 3Ax^2 +2Bx + C
        //This rough approximation is probably wrong and/or horribly inefficient:
        float ExDeltaX = MaxSpeed*SpeedConstant*Dt/(Math.sqrt(1+Math.pow(Heading,2)));
       // float ExDeltaX = Math.tan(Heading)*((Driver.leftSpeed*MaxSpeed*Dt)+(RobotWidth/2))/(Math.sqrt(Math.pow(Heading,2)+1));
        float HeadingGoal = (3*A*Math.pow(ExDeltaX,2))+(2*B*ExDeltaX)+C;
        float DeltaThetaGoal = Math.atan(HeadingGoal)-Math.atan(Heading);
        float DthDt = DeltaThetaGoal/Dt;
        float RminusL = RobotWidth*DthDt/MaxSpeed;
        float L = -1*RminusL/2 + OtherConstant;
        float R = RminusL/2 + OtherConstant;



    }
    public void update() {
        if (!First){
            float Dt = timer.get()-lastTime;
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
