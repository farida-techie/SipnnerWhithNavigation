package com.malkinfo.sinnerwithnavigation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.Navigation
import com.malkinfo.sinnerwithnavigation.MainActivity
import com.malkinfo.sinnerwithnavigation.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.lang.NullPointerException


class MainFragment : Fragment() {
    private lateinit var ac : MainFragmentDirections.GotoFirstFra
    private lateinit var ac1 : MainFragmentDirections.GotosecondFrag
    private lateinit var ac2 : MainFragmentDirections.GotoThirdFrag

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendToFragment()


    }
    fun sendToFragment() {
        spiTypa.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                   when(position){
                       0 ->{

                           setTargetFragment(MainFragment(),2)
                       }
                       1 ->{
                           ac = MainFragmentDirections.gotoFirstFra()
                           Navigation.findNavController(view!!).navigate(ac)
                       }
                       2->{
                           ac1 = MainFragmentDirections.gotosecondFrag()
                           Navigation.findNavController(view!!).navigate(ac1)
                       }
                       3->{
                           ac2 = MainFragmentDirections.gotoThirdFrag()
                           Navigation.findNavController(view!!).navigate(ac2)
                       }
                   }




                    Toast.makeText(
                        context,
                        "You Selected ${parent?.getItemAtPosition(position).toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }


            }
    }

}

