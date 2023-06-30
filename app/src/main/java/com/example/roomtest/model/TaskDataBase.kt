package com.example.roomtest.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDataBase : RoomDatabase() {

    // acceso al dao
    abstract fun getTaskDao(): TaskDao

    // no necesitamos con companion object isntanciar la clase para ocuparla
    companion object {
        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getDatabe(context: Context): TaskDataBase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }

    }

}