package com.example.mrfre.pova;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Application;
import android.util.Log;

import java.util.List;

public class Server extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("b083aef21605d9155a7486bccfe22ffb99a2802c")
                // if desired
                .clientKey("02be838f9b38ea90c235a1c1f986af6fb9bef0b9")
                .server("http://18.144.45.55:80/parse/")
                .build()
        );
    }
}