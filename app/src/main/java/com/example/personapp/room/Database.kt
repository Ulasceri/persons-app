package com.example.personapp.room

import androidx.room.RoomDatabase
import com.example.personapp.data.entitiy.Persons

@androidx.room.Database(entities = [Persons::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getPersonsDao() : PersonsDao
}

