package com.codepath.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TlY3TERiJVRcNKyYklK3XjSBwmJY6UNfKuhrIFQ5")
                .clientKey("IOdYpBK4KVS9A73L9C5Q6Qwsr4HPlgORIlNEZhTf")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
