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
import com.example.hvaquest.Question.Question

import com.example.hvaquest.R
import com.example.hvaquest.ViewModel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {

    private lateinit var viewModel : QuestViewModel;
    private lateinit var myView: View;
    private lateinit var question: Question;
    var counter: Int = 0;

    // This is progressInt. It keeps track of the quests.
    private val args: QuestionFragmentArgs by navArgs();

    // Called after onCreate. Graphical initialisations.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_question, container, false);
        activity?.setTitle("Question");
        return myView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnConfirm.setOnClickListener {
            onClick();
        }

        viewModel = ViewModelProviders.of(this).get(QuestViewModel::class.java);

        initViews();
    }

    private fun initViews(){
        question = viewModel.getQuestion(args.progressIndex);

        // Page progress is assigned using the QuestionFragmentArgs.
        // This progressInt is from the navigation_graph.
        // viewModel.getListSize() gets the length of the QuestionRepository.
        // args.pageIndex starts at 1, because it's its default value.
        tvProgress.text = getString(R.string.progress_text, args.pageIndex, viewModel.getListSize())

        // Assign text view for question to the actual String from QuestionRepository.
        tvQuestion.text = question.question;

        // Assign the radio buttons to the choices in the QuestionRepository.
        answer1.text = question.choices[0];
        answer2.text = question.choices[1];
        answer3.text = question.choices[2];

        // Track the questIndex so the MainActivity.kt can make check on backButton.
        viewModel.questIndexTracker = args.progressIndex;
    }

    private fun onClick(){
        // If choice one of the buttons is selected.
        if (rgQuestions.checkedRadioButtonId != -1) {

            val choiceText = myView.findViewById<RadioButton>(rgQuestions.checkedRadioButtonId)?.text;

            // Compares whether the checked RadioButton's text is the same as the question.correct answer text.
            if ( choiceText == question.correctAnswer) {
                // Navigate to LocationFragment with progressInt as argument.
                val action = QuestionFragmentDirections.actionQuestionFragmentToLocationFragment(args.progressIndex, args.pageIndex);
                findNavController().navigate(action);
            } else {
                Toast.makeText(context, "Wrong answer.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(context, "Please select an answer.", Toast.LENGTH_LONG).show();
        }
    }
}
