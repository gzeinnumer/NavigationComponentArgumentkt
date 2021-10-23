package com.gzeinnumer.navigationcomponentargumentkt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

//todo 2
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //todo 7
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.findViewById<Button>(R.id.btn).setOnClickListener {
//            val action = MainFragmentDirections.action_mainFragment_to_dashboardFragment(ed_name.text.toString())
            val action = MainFragmentDirections.action_mainFragment_to_dashboardFragment()
            view.findNavController().navigate(action)
        }
        return view
    }

}
