package com.example.hvaquest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.hvaquest.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    private lateinit var myView: View;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_start, container, false);
        return myView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnStart.setOnClickListener{
            startQuest();
        }
    }

    private fun startQuest() {
        // Navigate to QuestionFragment with ProgressInt as argument.
        // args.progressInt has value of 0 by default, passes this to next fragment.
        val action = StartFragmentDirections.actionStartFragmentToQuestionFragment();
        findNavController().navigate(action);
    }
}
