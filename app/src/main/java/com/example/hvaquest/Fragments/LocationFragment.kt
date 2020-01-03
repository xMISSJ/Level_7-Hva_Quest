package com.example.hvaquest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hvaquest.Question.Question

import com.example.hvaquest.R
import com.example.hvaquest.ViewModel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_location.*

class LocationFragment : Fragment() {

    private lateinit var viewModel : QuestViewModel;
    private lateinit var question: Question;
    private lateinit var myView: View;
    private lateinit var locationImage: ImageView;

    // This is progressInt. It keeps track of the quests.
    private val args: LocationFragmentArgs by navArgs();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_location, container, false);
        locationImage = myView.rootView.findViewById(R.id.ivLocation);
        activity?.title = "Location Clue";

        return myView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNextQuestion.setOnClickListener {
            onClick();
        }

        viewModel = ViewModelProviders.of(this).get(QuestViewModel::class.java);
        initViews();
    }

    private fun initViews(){

        question = viewModel.getQuestion(args.progressIndex);
        var image = question.clue;

        locationImage.setImageDrawable(ContextCompat.getDrawable(context!!, image));
    }

    private fun onClick(){
        // Checks whether questions in the listOf<Question> in QuestionRepository still need to be completed.
        if (args.progressIndex + 1 < viewModel.getListSize()) {
            // Increase the progressIndex by 1, so it goes to the next question according to the questionRepository.
            // Increase the pageIndex by 1, so it goes to the next page.
            val action = LocationFragmentDirections.actionLocationFragmentToQuestionFragment(args.progressIndex + 1, args.pageIndex + 1);
            findNavController().navigate(action);
            // When all the questions are completed...
        } else {
            // Go to the last fragment.
            val action = LocationFragmentDirections.actionLocationFragmentToEndFragment();
            findNavController().navigate(action);
        }
    }
}
