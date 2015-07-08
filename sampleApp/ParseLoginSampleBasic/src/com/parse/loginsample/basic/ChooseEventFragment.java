package com.parse.loginsample.basic;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.parse.ParseUser;

import java.util.List;

/**
 * Created by emstaple on 7/6/15.
 */
public class ChooseEventFragment extends Fragment {

    private static final String USER_NAME_KEY = "name";
    private static final String OBJECT_ID_KEY = "objectId";
    private static final String USER_FB_ID_KEY = "authData";
    private static final String USER_FRIEND_EVENT_LIST_KEY = "friendList";
    private static final String EVENT_OBJECT = "Event";
    private static final String USER_NAME_KEY = "name";

    private ParseUser mParseUser;
    private List<Event> mFriendEvents;
    private Event mEvent;
    private Button mInterestedButton;
    private Button mDeclineButton;

    public static ChooseEventFragment newInstance() {
        return new ChooseEventFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParseUser = ParseUser.getCurrentUser();
        updateEventList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        View v = inflater.inflate(R.layout.choose_event_fragment, container, false);

        mInterestedButton = (Button) v.findViewById(R.id.interested_button);
        mInterestedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add event to user's "Interested" list and add the user to event's
                //"Interested" list
            }
        });

        mDeclineButton = (Button) v.findViewById(R.id.decline_button);
        mDeclineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Remove from user's "Friends" events list
            }
        });

        return v;
    }

    private void updateEventList() {
        new FetchItemsTask().execute();
    }

    private class FetchItemsTask extends AsyncTask<Void, Void, List<Event>> {

        public FetchItemsTask() {}

        @Override
        protected List<Event> doInBackground(Void... params) {
                return new DataFetcher().fetchUserFriendEvents();
        }

        @Override
        protected void onPostExecute(List<Event> items) {
            mFriendEvents = items;
            mEvent = mFriendEvents.get(0);
            //setupAdapter();
        }
    }
}
