// Copyright 2004-present Facebook. All Rights Reserved.

package com.parse.loginsample.basic;

import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by gaoy on 7/7/15.
 */
public class ParseData {
    ParseObject events = ParseObject.create(Event.class);

    private static final String TAG = "Event";

    public void storeEvents(Event event, boolean isAttending) {

        if (isAttending) {
            events.add("Attending", event);

        } else {
            events.add("Interested", event);
        }
        events.saveInBackground();


    }



    public void getEvents() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // object will be your events
                    String Attending = events.getString("Attending");
                    String Interested = events.getString("Interested");
                } else {
                    Log.e(TAG, "Exception caught!", e);
                }
            }
        });
    }



}
