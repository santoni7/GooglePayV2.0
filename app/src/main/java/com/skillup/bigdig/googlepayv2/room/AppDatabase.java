package com.skillup.bigdig.googlepayv2.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.skillup.bigdig.googlepayv2.entity.BankCard;

@Database(entities = {BankCard.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BankCardDao getBankCardDao();
}
