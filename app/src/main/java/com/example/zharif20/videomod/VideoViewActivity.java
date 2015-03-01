package com.example.zharif20.videomod;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
//import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by zharif20 on 2/20/15.
 */
public class VideoViewActivity extends Activity{

    //variables
    ProgressDialog pgDialog;
    VideoView videoview;
    VideoView fullscreenview;


    //insert url video
    String vidUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    //https://www.youtube.com/watch?v=1uyM4_a9t6o
    //http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4
    //http://www.androidbegin.com/tutorial/AndroidCommercial.3gp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get layout from video.xml
        setContentView(R.layout.videoview_main);
        //find your videoview from video_main xml layout
        videoview = (VideoView)findViewById(R.id.VideoView);

        //get layout from video.xml
        setContentView(R.layout.videoview_main);
        //find Fullscreen view from videoview_main xml layout
        fullscreenview = (VideoView)findViewById(R.id.FullScreenView);

        //execute streamvideo asyntax

        //create a progressbar
        pgDialog = new ProgressDialog(VideoViewActivity.this);

        //setprogressbar title
        pgDialog.setTitle("Video Title"); // get title from XML
        //set progressbar message
        pgDialog.setMessage("Buffering");
        pgDialog.setIndeterminate(false);
        pgDialog.setCancelable(false);
        //show progressbar
        pgDialog.show();

        try {
            //start the mediacontroller
            MediaController mediaController = new MediaController(VideoViewActivity.this);
            mediaController.setAnchorView(videoview);
            //get the url from string videourl
            Uri video = Uri.parse(vidUrl);
            videoview.setMediaController(mediaController);
            videoview.setVideoURI(video);

            //get duration for the video
            videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.i(vidUrl, "Duration = " + videoview.getDuration());
                }
            });

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            //View decorView = getWindow().getDecorView();
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            //int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            //        | View.SYSTEM_UI_FLAG_FULLSCREEN;
            //decorView.setSystemUiVisibility(uiOptions);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();

        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            //close the progressbar and play the video
            @Override
            public void onPrepared(MediaPlayer mp) {
                pgDialog.dismiss();
                videoview.start();

            }
        });



    }
}
