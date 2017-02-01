package edu.jgalvan.cs478.cityinformation;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Jonathan Galvan on 3/14/16.
 */
public class IndianapolisListFragment extends ListFragment {

    private onListItemSelectedListener listener;

    // Interface that will communicate with the main activity
    public interface onListItemSelectedListener {
        public void onItemSelected(int position);
    }

    // Attaches the current activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (onListItemSelectedListener) activity;

        }

        catch (ClassCastException c) {
            listener = null;

        }


    }

    // Method that will Create and inflate all the necessary information into the Indianapolis Listview
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.indianapolis_listview,container,false);

        String [] locations = {"Indianapolis Motor Speedway", "The Children's Museum", "Indiana State Museum"
                ,"Lucas Oil Stadium"};

        setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.indianapolis_row,R.id.indianapolistitem,locations));
        return view;
    }

    // Catches the position of the clicked item in the List menu and returns it to the method of the interface
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        getListView().setItemChecked(position, true);
        listener.onItemSelected(position);
    }

}