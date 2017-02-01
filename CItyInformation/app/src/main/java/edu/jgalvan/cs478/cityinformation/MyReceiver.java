package edu.jgalvan.cs478.cityinformation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by user on 3/12/16.
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        if(intent.getAction().equals("edu.jgalvan.cs478.citySelector.Chicago")) {

            Intent i = new Intent(context, ChicagoFirstActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(i);

        }

        if(intent.getAction().equals("edu.jgalvan.cs478.citySelector.Indianapolis")) {

            Intent i = new Intent(context, IndianapolisFirstActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(i);

        }
    }
}
