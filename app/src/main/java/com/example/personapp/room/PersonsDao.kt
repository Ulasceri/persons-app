package com.example.personapp.room

import androidx.core.app.Person
import androidx.room.*
import com.example.personapp.data.entitiy.Persons
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons")
    suspend fun allPersons() : List<Persons>

    @Query("SELECT * FROM persons WHERE person_name like '%' || :personWords || '%'")
    suspend fun personSearchs(personWords:String) : List<Persons>

    @Insert
    suspend fun personAdd(persons: Persons)

    @Update
    suspend fun personUpdate(persons: Persons)

    @Delete
    suspend fun personDelete(persons: Persons)

    }


