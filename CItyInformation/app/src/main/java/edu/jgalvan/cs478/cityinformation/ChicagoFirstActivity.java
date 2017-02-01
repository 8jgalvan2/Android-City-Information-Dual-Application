package edu.jgalvan.cs478.cityinformation;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Jonathan Galvan on 3/12/16.
 */
public class ChicagoFirstActivity extends Activity implements ChicagoListFragment.onListItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Necessary for checking phone rotations.
        // Does not create a second instance of a fragment if rotated vertically to horizontally
        if(savedInstanceState == null) {

            setContentView(R.layout.activity_first);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ChicagoListFragment list = new ChicagoListFragment();

            fragmentTransaction.add(R.id.frameContainer, list);
            fragmentTransaction.commit();
        }


    }

    // Inflates the action menu with Indianapolis menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);

        return true;
    }

    // Completes a given command when the user clicks on the menu option
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            // Redirects the user to Indianapolis's list of places
            case R.id.chicago :

                Intent i = new Intent(ChicagoFirstActivity.this, IndianapolisFirstActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    // Listens for the item selected in the Chicago List Menu
    @Override
    public void onItemSelected(int position) {

        // Creates and Initializes the webpage fragment and stores it into the backstack
        // Puts the fragment onto the framelayout
        // Redirects the user to the clicked point of interest information found online
        String webUrl = "";
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ChicagoWebFragment cwf = new ChicagoWebFragment();

        switch (position) {

            case 0:
                webUrl = "http://www.cityofchicago.org/city/en/depts/dca/supp_info/millennium_park.html";
                break;

            case 1:
                webUrl = "https://en.wikipedia.org/wiki/Museum_of_Science_and_Industry_(Chicago)";
                break;

            case 2:
                webUrl = "http://www.artic.edu/";
                break;

            case 3:
                webUrl = "http://www.willistower.com/";
                break;

            case 4:
                webUrl = "http://www.lpzoo.org/";
                break;

            case 5:
                webUrl = "https://en.wikipedia.org/wiki/Navy_Pier";
                break;

            case 6:
                webUrl = "http://www.johnhancock.com/?EngineId=gsn&l=PPC:gsn:john+hancock_Brand";
                break;

            case 7:
                webUrl = "http://www.soldierfield.net/";
                break;

            case 8:
                webUrl = "http://www.sheddaquarium.org/";
                break;

            case 9:
                webUrl = "https://www.fieldmuseum.org/";
                break;

            case 10:
                webUrl = "http://www.adlerplanetarium.org/?gclid=CNqrpYeKxssCFZaEaQodLmME3g";
                break;

            case 11:
                webUrl = "http://chicago.cubs.mlb.com/chc/ballpark/";
                break;

        }

        cwf.init(webUrl);
        ft.add(R.id.frameContainer, cwf);
        ft.addToBackStack(null);
        ft.commit();
        fm.executePendingTransactions();

    }

}