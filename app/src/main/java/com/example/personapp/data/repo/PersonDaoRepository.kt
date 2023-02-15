package com.example.personapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.personapp.data.entitiy.Persons
import com.example.personapp.room.PersonsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDaoRepository(var pdao:PersonsDao) {
    var personLists: MutableLiveData<List<Persons>>

    init {
        personLists = MutableLiveData()
    }

    fun personComing(): MutableLiveData<List<Persons>> {
        return personLists
    }

    fun personRegister(person_name: String, person_phone: String) {

        val job = CoroutineScope(Dispatchers.Main).launch {
            val newRegister = Persons(0, person_name, person_phone)
            pdao.personAdd(newRegister)
        }
    }

        fun personUpdate(person_id: Int, person_name: String, person_phone: String) {
            val job = CoroutineScope(Dispatchers.Main).launch {
                val updatedPerson = Persons(person_id, person_name, person_phone)
                pdao.personUpdate(updatedPerson)
            }
        }

        fun personSearch(searchkey: String) {
            val job = CoroutineScope(Dispatchers.Main).launch {
                personLists.value = pdao.personSearchs(searchkey)
            }
        }

        fun personDelete(person_id: Int) {
            val job = CoroutineScope(Dispatchers.Main).launch {
                val deletedPerson = Persons(person_id, "", "")
                pdao.personDelete(deletedPerson)
                allPerson()
            }
        }

        fun allPerson() {
            val job = CoroutineScope(Dispatchers.Main).launch {
                personLists.value = pdao.allPersons()
            }
        }

}


