package com.example.personapp.ui.adapter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.personapp.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonRegisterViewModel @Inject constructor (var prepo : PersonDaoRepository): ViewModel() {
    fun register(person_name:String,person_phone:String){
        prepo.personRegister(person_name,person_phone)

    }
}