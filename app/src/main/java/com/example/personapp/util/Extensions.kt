package com.example.personapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.personapp.R

fun Navigation.Switch(it:View,id:Int) {
   findNavController(it).navigate(id)
}
fun Navigation.Switch(it:View,id:NavDirections) {
    findNavController(it).navigate(id)
}
