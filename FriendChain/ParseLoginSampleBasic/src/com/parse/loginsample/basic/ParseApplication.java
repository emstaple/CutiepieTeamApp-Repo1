/*
 *  Copyright (c) 2014, Parse, LLC. All rights reserved.
 *
 *  You are hereby granted a non-exclusive, worldwide, royalty-free license to use,
 *  copy, modify, and distribute this software in source code or binary form for use
 *  in connection with the web services and APIs provided by Parse.
 *
 *  As with any software that integrates with the Parse platform, your use of
 *  this software is subject to the Parse Terms of Service
 *  [https://www.parse.com/about/terms]. This copyright notice shall be
 *  included in all copies or substantial portions of the software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 *  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 *  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.parse.loginsample.basic;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;

import java.util.Date;

public class ParseApplication extends Application {

  public Event event;

  //public Event event = new Event("title", new Date(1,12,2), new ParseUser());
  public ParseData parseData;

  @Override
  public void onCreate() {
    super.onCreate();

    ParseObject.registerSubclass(Event.class);
    // Required - Initialize the Parse SDK

    event = ParseObject.create(Event.class);

    event.setTitle("Title");
    event.setTime(new Date(1, 2, 3));
    parseData = new ParseData();

    Parse.enableLocalDatastore(this);

    Parse.initialize(this, "hhK2e56IYofzH8HTuoXskijZnRODN64N8r7W31Hk", "P3lkYbVuu6xdi00lfJJGHZOSjYsgqC5g5ygXTMuo");

    Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

    ParseFacebookUtils.initialize(this);

    parseData.storeEvents(event, true);




  }
}
