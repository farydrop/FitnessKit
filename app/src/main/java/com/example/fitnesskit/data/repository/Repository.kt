package com.example.fitnesskit.data.repository

import com.example.fitnesskit.data.api.RetrofitInstance
import com.example.fitnesskit.model.Lesson
import com.example.fitnesskit.model.Trainer
import com.example.fitnesskit.model.Trainers
import retrofit2.Response

class Repository {

    suspend fun getTrainersApi(): Response<Trainers> {
        return RetrofitInstance.api.getTrainers()
    }

    suspend fun getLessonApi(): Response<Trainers> {
        return RetrofitInstance.api.getLessons()
    }

}