package com.example.Wandroid.room

import android.content.Context
import androidx.room.Room

class WorkHelp private constructor(context: Context) {
    val dao: DataBaseDao?
    private val workDataBase: WorkDataBase

    companion object {
        @Volatile
        private var insatnce: WorkHelp? = null
        fun getInsatnce(context: Context): WorkHelp? {
            if (insatnce == null) {
                synchronized(WorkHelp::class.java) {
                    if (insatnce == null) {
                        insatnce = WorkHelp(context)
                    }
                }
            }
            return insatnce
        }
    }

    init {
        workDataBase = Room.databaseBuilder(context, WorkDataBase::class.java, "xl.db")
            .allowMainThreadQueries().build()
        dao = workDataBase.dao
    }
}