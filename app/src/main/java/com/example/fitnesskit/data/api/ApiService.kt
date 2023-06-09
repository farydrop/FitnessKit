package com.example.fitnesskit.data.api

import com.example.fitnesskit.model.Lesson
import com.example.fitnesskit.model.Trainer
import com.example.fitnesskit.model.Trainers
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("schedule/get_v3/?club_id=2")
    suspend fun getTrainers(): Response<Trainers>

    @GET("schedule/get_v3/?club_id=2")
    suspend fun getLessons(): Response<Trainers>
}
