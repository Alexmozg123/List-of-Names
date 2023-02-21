package com.example.testrecyclerview.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testrecyclerview.data.database.room.dao.EventDao
import com.example.testrecyclerview.data.database.room.dao.ResponsibleHumanDao
import com.example.testrecyclerview.data.database.room.dao.SongDao
import com.example.testrecyclerview.model.Event
import com.example.testrecyclerview.model.EventSongCrossRef
import com.example.testrecyclerview.model.ResponsibleHuman
import com.example.testrecyclerview.model.Song

@Database(
    entities = [
        Event::class,
        ResponsibleHuman::class,
        EventSongCrossRef::class,
        Song::class
    ],
    version = 1
)
abstract class WorshipDatabase : RoomDatabase() {

    abstract fun getResponsibleHumanDao(): ResponsibleHumanDao

    abstract fun getEventDao(): EventDao

    abstract fun getSongDao(): SongDao

    companion object {

        private var database: WorshipDatabase? = null

        @Synchronized
        fun getInstance(context: Context): WorshipDatabase {
            return if (database == null) {
                database = Room
                    .databaseBuilder(context, WorshipDatabase::class.java, "worshipDB")
                    .fallbackToDestructiveMigration()
                    .build()
                database as WorshipDatabase
            } else database as WorshipDatabase
        }
    }
}