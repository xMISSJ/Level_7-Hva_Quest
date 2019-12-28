package com.example.hvaquest.ViewModel

import androidx.lifecycle.ViewModel
import com.example.hvaquest.QuestionRepository
import com.example.hvaquest.Question

class QuestViewModel : ViewModel() {

    private val questionRepository = QuestionRepository();

    fun getQuestion(index: Int) : Question {
        return questionRepository.getQuestion(index);
    }

    fun getListSize() : Int {
        return questionRepository.getListSize();
    }
}