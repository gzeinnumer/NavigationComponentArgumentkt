package com.gzeinnumer.navigationcomponentargumentkt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dashboard.*

//todo 4
class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //todo 8
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)

        tv_name.text = DashboardFragmentArgs.fromBundle(arguments).username

        return view
    }

}
