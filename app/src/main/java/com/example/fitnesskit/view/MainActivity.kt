package com.example.fitnesskit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesskit.R
import com.example.fitnesskit.databinding.ActivityMainBinding
import com.example.fitnesskit.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var scheduleAdapter: ScheduleAdapter? = null
    val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*scheduleAdapter = ScheduleAdapter(viewModel.lesson, viewModel.trainer)
        binding.rvSchedule.adapter = scheduleAdapter*/

    }
}