package com.example.personapp.data.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "persons")
data class Persons(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "person_id")var person_id:Int,
                   @ColumnInfo(name = "person_name")var person_name:String,
                   @ColumnInfo(name = "person_phone") var person_phone:String) : java.io.Serializable
{
}