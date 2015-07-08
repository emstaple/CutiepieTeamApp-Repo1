package com.parse.loginsample.basic;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;
import java.util.List;

/**
 * Created by emstaple on 7/6/15.
 */
public class Event extends ParseObject {
    private String eventObjectId;
    private String Title;
    private Date Time;
    private android.location.Location Location;
    private String Details;
    private ParseUser CurrentInvitingUser;
    private ParseUser PreviousInvitingUser;
    private List<ParseUser> InterestedUsers;
    private List<ParseUser> AttendingUsers;

    public Event(String title, Date time, android.location.Location location,
                 String details, ParseUser user) {
        setTitle(title);
        setTime(time);
        setDetails(details);
        setLocation(location);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public android.location.Location getLocation() {
        return Location;
    }

    public void setLocation(android.location.Location location) {
        Location = location;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getEventObjectId() {
        return eventObjectId;
    }

    public ParseUser getCurrentInvitingUser() {
        return CurrentInvitingUser;
    }

    public void setCurrentInvitingUser(ParseUser currentInvitingUser) {
        CurrentInvitingUser = currentInvitingUser;
    }

    public ParseUser getPreviousInvitingUser() {
        return PreviousInvitingUser;
    }
}
