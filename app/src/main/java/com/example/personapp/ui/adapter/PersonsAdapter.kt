package com.example.personapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Switch
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.personapp.R
import com.example.personapp.data.entitiy.Persons
import com.example.personapp.databinding.CardDesignBinding
import com.example.personapp.fragment.MainPageFragmentDirections
import com.example.personapp.ui.adapter.viewmodel.MainPageViewModel
import com.example.personapp.util.Switch
import com.google.android.material.snackbar.Snackbar

class PersonsAdapter (var mContext: Context,
                      var PersonList:List<Persons>,
                      var viewModel: MainPageViewModel) :
    RecyclerView.Adapter<PersonsAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design:CardDesignBinding) : RecyclerView.ViewHolder(design.root){
        var design:CardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:CardDesignBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_design,parent,false)
        return CardDesignHolder(design)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = PersonList.get(position)
        val d = holder.design

        d.personObject = person

        d.lineCard.setOnClickListener {
            val gecis = MainPageFragmentDirections.actionMainPageFragmentToPersonDetailFragment2(person = person)
            Navigation.Switch(it,gecis)
        }

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${person.person_name} Silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.delete(person.person_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return PersonList.size
    }

}