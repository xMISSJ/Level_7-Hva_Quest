package com.example.hvaquest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hvaquest.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    // Use the progressInt from args in StartFragment to keep track of the pages.
    private val args: StartFragmentArgs by navArgs();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
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
        val action = StartFragmentDirections.actionStartFragmentToQuestionFragment(args.progressIndex, args.pageIndex);
        findNavController().navigate(action);
    }
}
