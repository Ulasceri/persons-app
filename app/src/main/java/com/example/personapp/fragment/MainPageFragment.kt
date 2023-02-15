package com.example.personapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.personapp.R
import com.example.personapp.data.entitiy.Persons
import com.example.personapp.databinding.FragmentMainPageBinding
import com.example.personapp.ui.adapter.PersonsAdapter
import com.example.personapp.ui.adapter.viewmodel.MainPageViewModel
import com.example.personapp.ui.adapter.viewmodel.PersonRegisterViewModel
import com.example.personapp.util.Switch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var design:FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel
    override fun onCreateView(



        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)
        design.mainPageFragment = this

        design.mainPageToolbarTitle="Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarMainPage)


        viewModel.personLists.observe(viewLifecycleOwner){
            val adapter = PersonsAdapter(requireContext(),it,viewModel)
            design.personAdapter = adapter
        }


        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainPageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun fabClick(it:View){
        Navigation.Switch(it,R.id.personRegisterTransition)

    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }


    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa","Dönüldü")
        viewModel.loadPersons()

    }

}