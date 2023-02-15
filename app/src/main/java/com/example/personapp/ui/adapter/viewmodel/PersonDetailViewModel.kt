package com.example.personapp.ui.adapter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.personapp.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor (var prepo : PersonDaoRepository): ViewModel() {

    fun update(person_id: Int, person_name: String, person_phone: String) {
        prepo.personUpdate(person_id,person_name,person_phone)
    }
}