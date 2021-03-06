package com.malkinfo.sinnerwithnavigation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.malkinfo.sinnerwithnavigation.R
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

private lateinit var name:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            name = FirstFragmentArgs.fromBundle(it!!).urseNa
            tvName.text = name
        }
    }



}