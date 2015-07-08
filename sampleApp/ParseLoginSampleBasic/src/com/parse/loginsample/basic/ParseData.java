package com.parse.loginsample.basic;

import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;

/**
 * Created by puku on 7/7/15.
 */
public class ParseData {

    ParseObject events = new ParseObject("Event");
    ArrayList<Event> event_list = new ArrayList<>();


    public void storeEvents(Event event, boolean isAttending) {

              event_list.add(event);


            if (isAttending) {
                events.addAllUnique("Attending", event_list);
                event_list.remove(event);

            } else {
                events.addAllUnique("Interested", event_list);
                event_list.remove(event);
            }
            events.saveInBackground();


        }



    public void getEvents() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // object will be your events
                    ArrayList<Event> Attending_list = events.getArrayList("Attending");
                    ArrayList<Event> Interested_list = events.getArrayList("Interested");

                } else {
                    Log.e(TAG, "Exception caught!", e);
                }
            }
        });
    }




}
