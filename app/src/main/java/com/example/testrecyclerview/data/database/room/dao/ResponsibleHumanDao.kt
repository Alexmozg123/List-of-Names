package com.example.testrecyclerview.data.database.room.dao

import androidx.room.*
import com.example.testrecyclerview.model.ResponsibleHuman

@Dao
interface ResponsibleHumanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResponsibleHuman(responsibleHuman: ResponsibleHuman)

    // TODO: get realization this query later in filters
//    @Transaction
//    @Query("SELECT * FROM responsible_human_table")
//    fun getResponsibleHumansWithEvents(): List<ResponsibleHumanWithEvents>

    @Query("SELECT * FROM responsible_human_table")
    fun getAllResponsibleHumans() : List<ResponsibleHuman>

    @Update
    fun updateResponsibleHuman(responsibleHuman: ResponsibleHuman)

    @Delete
    fun deleteResponsibleHuman(responsibleHuman: ResponsibleHuman)

}