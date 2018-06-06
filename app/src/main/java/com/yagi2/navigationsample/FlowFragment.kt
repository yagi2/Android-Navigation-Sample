package com.yagi2.navigationsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class FlowFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val number = arguments?.let {
            FlowFragmentArgs.fromBundle(it).number
        }

        return when (number) {
            1 -> inflater.inflate(R.layout.fragment_one, container, false)
            2 -> inflater.inflate(R.layout.fragment_two, container, false)
            3 -> inflater.inflate(R.layout.fragment_three, container, false)
            else -> throw IllegalArgumentException()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.next_button).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_next_flow)
        )
    }
}
