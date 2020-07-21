package edu.niu.cs.z1856513.threadbounce;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class BounceThread extends Thread
{
    private SurfaceHolder ballHolder;
    private AnimationArena ballArena;
    private Boolean ballBouncing;

    public BounceThread(SurfaceHolder sh)
    {
        ballHolder = sh;

        //initialize boolean variable
        ballBouncing = true;
        ballArena = new AnimationArena();
    }//end constructor

    public void run()
    {
        try
        {
            while(ballBouncing)
            {
                //Create a canvas object and lock the object
                Canvas canvas = ballHolder.lockCanvas();

                //Update the ball location
                ballArena.updateLocationBall(canvas.getWidth(),canvas.getHeight());
                ballArena.draw(canvas);

                //Unlock the canvas
                ballHolder.unlockCanvasAndPost(canvas);
            }
        }
        catch(NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }//endRun

    public void endBounce()
    {
        ballBouncing = false;
    }
}//endBounceThread
