package com.example.Wandroid.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WorkEntity::class], version = 1, exportSchema = false)
abstract class WorkDataBase : RoomDatabase() {
    abstract val dao: DataBaseDao?
}