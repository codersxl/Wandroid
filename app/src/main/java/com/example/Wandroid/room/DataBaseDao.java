package com.example.Wandroid.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataBaseDao {

    @Insert
    void inserts(WorkEntity...workEntities);
    @Update
    void updates(WorkEntity...workEntities);
    @Delete
    void deteles(WorkEntity...workEntities);
    @Query("select * from xl")
    List<WorkEntity> Querys();
    @Query("delete  from xl")
    void deteAll();
    //根据IID
}
