package com.malkinfo.sinnerwithnavigation.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.Navigation
import com.malkinfo.sinnerwithnavigation.R
import kotlinx.android.synthetic.main.fragment_main.*



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
        sendToFragment(view)



    }
    fun sendToFragment(v:View) {
        spiTypa.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                    ) {
                        when (position) {
                            0 -> {

                                btnSub.setOnClickListener {
                                    Toast.makeText(activity, "Please Selected Item", Toast.LENGTH_SHORT).show()
                                }
                            }
                            1 -> {
                                btnSub.setOnClickListener {sendFirstFrag(v)}
                            }
                            2 -> {
                                btnSub.setOnClickListener {sendSecond(v)}
                            }
                            3 -> {
                                btnSub.setOnClickListener {sendThrid(v)}
                            }
                        }
                        Toast.makeText(
                                context,
                                "You Selected ${parent?.getItemAtPosition(position).toString()}",
                                Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        var type = parent?.getItemAtPosition(0)
                        type.toString()



                    }
                }

    }
    private fun sendFirstFrag(v:View){
        ac = MainFragmentDirections.gotoFirstFra()
        ac.urseNa = etName.text.toString()
        Navigation.findNavController(v).navigate(ac)
    }
    private fun sendSecond(v:View){
        ac1 = MainFragmentDirections.gotosecondFrag()
        ac1.urseNa = etName.text.toString()
        Navigation.findNavController(v).navigate(ac1)

    }
    private fun sendThrid(v:View){
        ac2 = MainFragmentDirections.gotoThirdFrag()
        ac2.urseNa = etName.text.toString()
        Navigation.findNavController(v).navigate(ac2)
    }

}

