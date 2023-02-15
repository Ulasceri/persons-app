package com.example.personapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.personapp.R
import com.example.personapp.databinding.FragmentPersonDetailBinding
import com.example.personapp.ui.adapter.viewmodel.MainPageViewModel
import com.example.personapp.ui.adapter.viewmodel.PersonDetailViewModel
import com.example.personapp.ui.adapter.viewmodel.PersonRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment : Fragment() {
    private lateinit var design: FragmentPersonDetailBinding
    private lateinit var viewModel: PersonDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design =
            DataBindingUtil.inflate(inflater, R.layout.fragment_person_detail, container, false)
        design.personDetailFragment = this
        design.personDetailToolbarTitle = "Kişi Detay"

        val bundle: PersonDetailFragmentArgs by navArgs()
        val incomingPerson = bundle.person

        design.personObject = incomingPerson



        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonDetailViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun ButtonUpdate(person_id: Int, person_name: String, person_phone: String) {
        viewModel.update(person_id,person_name,person_phone)
    }
}
