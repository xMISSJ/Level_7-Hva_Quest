package com.example.hvaquest.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hvaquest.Question

import com.example.hvaquest.R
import com.example.hvaquest.ViewModel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    private lateinit var viewModel : QuestViewModel;
    private lateinit var myView: View;
    private lateinit var question: Question;

    // This is progressInt. It keeps track of the quests.
    private val args: QuestionFragmentArgs by navArgs();

    // Called after onCreate. Graphical initialisations.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_question, container, false);
        return myView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnConfirm.setOnClickListener {
            onClick();
        }

        initViewModel();
        setFragmentValues();
    }

    private fun setFragmentValues(){
        question = viewModel.getQuestion(args.progressInt);

        // Page progress is assigned using the QuestionFragmentArgs.
        // This progressInt is from the navigation_graph.
        // The argument is defined below the <argument/> tab in questFragment.
        // viewModel.getListSize() gets the length of the QuestionRepository.
        tvProgress.text = getString(R.string.progress_text, args.progressInt, viewModel.getListSize())

        // Assign text view for question to the actual String from QuestionRepository.
        tvQuestion.text = question.question;

        // Assign the radio buttons to the choices in the QuestionRepository.
        answer1.text = question.choices[0];
        answer2.text = question.choices[1];
        answer3.text = question.choices[2];
    }

    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this).get(QuestViewModel::class.java);
    }

    private fun onClick(){
        // If choice one of the buttons is selected.
        if (rgQuestions.checkedRadioButtonId != -1) {

            val choiceText = myView.findViewById<RadioButton>(rgQuestions.checkedRadioButtonId)?.text;

            // Compares whether the checked RadioButton's text is the same as the question.correct answer text.
            if ( choiceText == question.correctAnswer) {
                // Navigate to LocationFragment with progressInt as argument.
                val action = QuestionFragmentDirections.actionQuestionFragmentToLocationFragment(args.progressInt)
                findNavController().navigate(action);
            }
        } else {
            Toast.makeText(context, "Please pick an answer.", Toast.LENGTH_LONG).show();
        }
    }
}
