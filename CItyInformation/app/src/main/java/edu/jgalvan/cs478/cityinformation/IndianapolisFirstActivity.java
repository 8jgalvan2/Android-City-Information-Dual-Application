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
 * Created by Jonathan Galvan on 3/13/16.
 */
public class IndianapolisFirstActivity extends Activity implements  IndianapolisListFragment.onListItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Necessary for checking phone rotations.
        // Does not create a second instance of a fragment if rotated vertically to horizontally
        if(savedInstanceState == null) {

            setContentView(R.layout.activity_indianapolis);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            IndianapolisListFragment list = new IndianapolisListFragment();

            fragmentTransaction.add(R.id.indianapoliscontainer, list);
            fragmentTransaction.commit();

        }
    }

    // Inflates the action menu with Chicago menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.indianapolis_menu_list, menu);

        return true;
    }


    // Completes a given command when the user clicks on the menu option
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            // Redirects the user to Chicago's list of places
            case R.id.indianapolis :

                Intent i = new Intent(IndianapolisFirstActivity.this, ChicagoFirstActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onItemSelected(int position) {

        // Creates and Initializes the webpage fragment and stores it into the backstack
        // Puts the fragment onto the framelayout
        // Redirects the user to the clicked point of interest information found online
        String webUrl = "";
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        IndianapolisWebFragment iwf = new IndianapolisWebFragment();

        switch (position) {

            case 0:
                webUrl = "http://www.indianapolismotorspeedway.com/";
                break;

            case 1:
                webUrl = "https://www.childrensmuseum.org/";
                break;

            case 2:
                webUrl = "http://www.indianamuseum.org/";
                break;

            case 3:
                webUrl = "http://www.lucasoilstadium.com/about.aspx";
                break;

        }

        iwf.init(webUrl);
        ft.add(R.id.indianapoliscontainer, iwf);
        ft.addToBackStack(null);
        ft.commit();
        fm.executePendingTransactions();

    }

}