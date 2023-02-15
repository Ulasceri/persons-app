package com.example.personapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.personapp.R
import com.example.personapp.databinding.FragmentPersonRegisterBinding
import com.example.personapp.ui.adapter.viewmodel.MainPageViewModel
import com.example.personapp.ui.adapter.viewmodel.PersonRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log
@AndroidEntryPoint
class PersonRegisterFragment : Fragment() {
    private lateinit var design:FragmentPersonRegisterBinding
    private lateinit var viewModel: PersonRegisterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_person_register, container, false)
        design.personRegisterToolbarTitle = "Kişi Kayıt"
        design.personRegisterFragment = this



        return design.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonRegisterViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun ButtonRegistery(person_name:String,person_phone:String){
       viewModel.register(person_name,person_phone)
    }
}
