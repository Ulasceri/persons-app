package com.example.personapp.ui.adapter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personapp.data.entitiy.Persons
import com.example.personapp.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor (var prepo : PersonDaoRepository): ViewModel(){
    var personLists = MutableLiveData<List<Persons>>()

    init {
        loadPersons()
        personLists = prepo.personComing()
    }

    fun search(searchkey:String){
        prepo.personSearch(searchkey)

    }
    fun delete(person_id: Int){
        prepo.personDelete(person_id)
    }

    fun loadPersons(){
        prepo.allPerson()
    }



}