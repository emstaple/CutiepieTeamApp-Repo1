package com.parse.loginsample.basic;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

/**
 * Created by gaoy on 7/8/15.
 */
public class FriendRelation {
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
                        if (true){
                            isSuccessful = true;
                        } else {
                            isSuccessful = false;
                        }
                    }
                }
        ).executeAsync();

        return isSuccessful;
    }

}
