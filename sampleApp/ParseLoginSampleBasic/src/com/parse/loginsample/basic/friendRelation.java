package com.parse.loginsample.basic;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

/**
 * Created by puku on 7/7/15.
 */
public class friendRelation {

    boolean isSuccessful;


    public boolean areFriends(String userIdA, String userIdB) {

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/{userIDA}/friends/{userIDB}",
                null,
                HttpMethod.POST,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
            /* handle the result */
                        if (response){
                            isSuccessful = true;
                        }else{
                            isSuccessful = false;
                        }
                    }
                }
        ).executeAsync();

        return isSuccessful;
    }
}




// This is for transferring objects from one user to another.
// just a sample of code that can be used later

/*

// --- Sending ---
ParseProxyObject ppo = new ParseProxyObject(myParseObject);

Intent intent = new Intent(ParseProfileActivity.class);
intent.putExtra("parseObject", ppo);

// --- Receiving ---
        Intent intent = getIntent();
        ParseProxyObject ppo = (ParseProxyObject) intent.getSerializableExtra("parseObject");
        Log.v("Test", String.format("Proxy object name: %s", ppo.getString("name"));

*/




