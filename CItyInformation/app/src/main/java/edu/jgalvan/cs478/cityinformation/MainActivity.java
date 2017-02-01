package edu.jgalvan.cs478.cityinformation;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Jonathan on 3/16/16.
 */
public class MainActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Clears the notification screen from the stack
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}