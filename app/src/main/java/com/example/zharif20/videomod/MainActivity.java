package com.example.zharif20.videomod;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends ActionBarActivity {

    Button button;
    Button fullScreenButton;
    boolean fullScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //locate the button
        button = (Button)findViewById(R.id.myButton);
        fullScreenButton = (Button)findViewById(R.id.myFullScreenButton);


        //capture button clicks
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                fullScreen = false;

                //Start new activity class

                Intent myIntent = new Intent(MainActivity.this,VideoViewActivity.class );
                startActivity(myIntent);
            }
            });

        //capture button clicks
        fullScreenButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                fullScreen = true;

                //Start new activity class

                Intent myIntent = new Intent(MainActivity.this,VideoViewActivity.class );
                myIntent.putExtra("fullScreen" TRUE);
                myIntent.put
                startActivity(myIntent);
            }
        });
        }
        }

// //reference the VideoView using the id in the xml layout

//VideoView vidView = (VideoView)findViewById(R.id.myVideo);

//

////prepare the uri endpoint

//String vidAddress = "https://www.youtube.com/watch?v=GCdwKhTtNNw";

//Uri vidUri = Uri.parse(vidAddress);

//vidView.setVideoURI(vidUri);

//

//

//MediaController vidControl = new MediaController(this);

//vidControl.setAnchorView(vidView);

//vidView.setMediaController(vidControl);

//

//vidView.start();/*

//

//

//}

