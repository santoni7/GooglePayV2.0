package com.skillup.bigdig.googlepayv2.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.skillup.bigdig.googlepayv2.entity.BankCard;

import java.util.List;

@Dao
public interface BankCardDao {

    @Query("SELECT * FROM bankcard")
    List<BankCard> getAll();

    @Insert
    void insert(BankCard bankCard);

    @Update
    void update(BankCard bankCard);
}
