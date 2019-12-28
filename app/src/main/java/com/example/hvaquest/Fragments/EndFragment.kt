package com.example.hvaquest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.hvaquest.R
import kotlinx.android.synthetic.main.fragment_end.*

class EndFragment : Fragment() {

    lateinit var myView: View;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        myView = inflater.inflate(R.layout.fragment_end, container, false);

        // Inflate the layout for this fragment
        return myView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        btnFinish.setOnClickListener {
            onClick();
        }
    }

    private fun onClick(){
        // Restart the quest.
        val action = EndFragmentDirections.actionEndFragmentToStartFragment();
        findNavController().navigate(action);
    }

}
