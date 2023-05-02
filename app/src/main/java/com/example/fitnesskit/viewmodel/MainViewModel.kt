package com.example.fitnesskit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.data.repository.Repository
import com.example.fitnesskit.model.Lesson
import com.example.fitnesskit.model.Trainer
import com.example.fitnesskit.model.Trainers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    var repo = Repository()
    val myTrainersList: MutableLiveData<Response<Trainers>> = MutableLiveData()

    fun getTrainersList() {
        viewModelScope.launch {
            myTrainersList.value = repo.getTrainersApi()
        }
    }

}