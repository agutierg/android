package com.agutierrez.yu_gimarket.views;

import java.util.Timer;
import java.util.TimerTask;

import com.agutierrez.yu_gimarket.R;
import com.agutierrez.yu_gimarket.components.ProgressWheel;
 
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.Window;
 
public class SplashScreenActivity extends Activity {
 
    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 5000;
    
	boolean running;
	ProgressWheel pw_two;
	int progress = 0;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
 
        setContentView(R.layout.splash_screen);
 
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
 
                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);
 
                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };
 
        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
                
        pw_two = (ProgressWheel) findViewById(R.id.progressBarThree);     
        
        int[] pixels = new int[] { 0x000000, 0x000000, 0x000000,
            0x000000, 0x000000, 0x000000, 0x00000000, 0x00000000};
        Bitmap bm = Bitmap.createBitmap(pixels, 8, 1, Bitmap.Config.ARGB_8888);
        Shader shader = new BitmapShader(bm,
            Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        pw_two.setRimShader(shader);
        
        pw_two.spin();
        
        
    }
}
