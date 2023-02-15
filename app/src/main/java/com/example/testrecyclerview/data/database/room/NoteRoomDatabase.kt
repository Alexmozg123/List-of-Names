package com.example.testrecyclerview.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.testrecyclerview.data.database.room.dao.NoteDao
import com.example.testrecyclerview.model.Instrument

@Database(entities = [Instrument::class], version = 1)
abstract class NoteRoomDatabase : androidx.room.RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        private var database: NoteRoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteRoomDatabase {
            return if (database == null) {
                database = Room
                    .databaseBuilder(context, NoteRoomDatabase::class.java, "noteDB")
                    .fallbackToDestructiveMigration()
                    .build()
                database as NoteRoomDatabase
            } else database as NoteRoomDatabase
        }
    }
}