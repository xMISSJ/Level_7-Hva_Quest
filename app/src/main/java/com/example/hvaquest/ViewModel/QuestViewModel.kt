package com.example.hvaquest.ViewModel

import androidx.lifecycle.ViewModel
import com.example.hvaquest.Fragments.QuestionFragment
import com.example.hvaquest.Fragments.QuestionFragmentArgs
import com.example.hvaquest.Question.QuestionRepository
import com.example.hvaquest.Question.Question

class QuestViewModel : ViewModel() {

    private val questionRepository = QuestionRepository();

    var questIndexTracker = 0;

    fun getQuestion(index: Int) : Question {
        return questionRepository.getQuestion(index);
    }

    fun getListSize() : Int {
        return questionRepository.getListSize();
    }
}