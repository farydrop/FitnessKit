package com.example.fitnesskit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.R
import com.example.fitnesskit.databinding.ActivityMainBinding
import com.example.fitnesskit.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Collections

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var recyclerView: RecyclerView
    val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*scheduleAdapter = ScheduleAdapter(viewModel.lesson, viewModel.trainer)
        binding.rvSchedule.adapter = scheduleAdapter

        //recyclerView.layoutManager = GridLayoutManager(context,2)
        viewModel.getTrainersList()
        viewModel.myTrainersList.observe(this) { list ->
            list.body()?.let { adapter.setlist(it.results) }
        }*/

        recyclerView = binding.rvSchedule
        scheduleAdapter = ScheduleAdapter()
        recyclerView.adapter = scheduleAdapter
        viewModel.getTrainersList()
        viewModel.myTrainersList.observe(this) { list ->
            list.body()?.let {
                scheduleAdapter.setList(it.trainers,it.lessons)
            }
        }

    }
}