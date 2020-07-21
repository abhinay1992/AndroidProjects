package edu.niu.cs.z1856513.threadbounce;

import android.graphics.Canvas;

public class AnimationArena {

    private Ball ball;

    public AnimationArena()
    {
        ball = new Ball();
    }

    //Method to update the location of the ball
    public void updateLocationBall(int width,int height)
    {
        ball.move(0,0,width,height);
    }

    //Method for drawing
    public void draw(Canvas drawBall)
    {
        //Set background color for canvas
        drawBall.drawRGB(156,174,216);
        //Draw the ball
        ball.draw(drawBall);
    }
}
