package com.skillup.bigdig.googlepayv2.room;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseProvider {
    private static String DATABASE_NAME = "GooglePay.db";
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance == null)
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}
