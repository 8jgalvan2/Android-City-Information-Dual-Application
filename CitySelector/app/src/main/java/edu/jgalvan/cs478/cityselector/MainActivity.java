

package edu.jgalvan.cs478.cityselector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Jonathan Galvan on 3/12/16.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Method that will send a broadcast intent to open Chicago's point of interests in the second App (City Information)
    // when the chicago button is pressed
    public void sendChicagoIntent(View v) {

        Intent intent = new Intent();

        intent.setAction("edu.jgalvan.cs478.citySelector.Chicago");
        sendBroadcast(intent);

    }

    // Method that will send a broadcast intent to open Indianapolis's point of interest in the second App (City Information)
    // when the Indianapolis button is pressed
    public void sendIndianapolisIntent(View v) {

        Intent intent = new Intent();

        intent.setAction("edu.jgalvan.cs478.citySelector.Indianapolis");
        sendBroadcast(intent);

    }


}
