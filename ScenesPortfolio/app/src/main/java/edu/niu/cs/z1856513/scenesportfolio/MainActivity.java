/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 9                                          *
 *                  Description :- An application to display                *
 *                                  the puzzle scenes                       *
 ****************************************************************************/

package edu.niu.cs.z1856513.scenesportfolio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity
{
    private ViewGroup paintingContainer; //Holds various scenes
    private Transition transition;
    private Scene activeScene,passiveScene1,passiveScene2,passiveScene3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect ViewGroup and the RelativeLayout from activity_main.xml
        paintingContainer = findViewById(R.id.paintingLayout);

        //inflate the transition
        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        //Populate Scene Objects
        activeScene = Scene.getSceneForLayout(paintingContainer,R.layout.scene1,this);
        passiveScene1 = Scene.getSceneForLayout(paintingContainer,R.layout.scene2,this);
        passiveScene2 = Scene.getSceneForLayout(paintingContainer,R.layout.scene3,this);
        passiveScene3 = Scene.getSceneForLayout(paintingContainer,R.layout.scene4,this);

        //Make active scene Visible
        activeScene.enter();
    }

    public void changeScene(View v)
    {
        Scene tempScene = activeScene;
        activeScene = passiveScene1;
        passiveScene1 = passiveScene2;
        passiveScene2 = passiveScene3;
        passiveScene3 = tempScene;

        //Make the new active scene visible
        TransitionManager.go(activeScene,transition);
    }
}
