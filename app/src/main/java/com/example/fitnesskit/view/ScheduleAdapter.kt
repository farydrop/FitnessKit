package com.example.fitnesskit.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.databinding.ScheduleItemBinding
import com.example.fitnesskit.model.Lesson
import com.example.fitnesskit.model.Trainer
import com.example.fitnesskit.model.Trainers

class ScheduleAdapter(
    private val lessonList: List<Lesson>,
    private val trainerList: List<Trainer>,
) : RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder>() {

    class ScheduleHolder(private val itemBinding: ScheduleItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(lesson: Lesson, trainer: Trainer) {
            itemBinding.tvStartTime.text = lesson.startTime
            itemBinding.tvLessonsName.text = lesson.name
            itemBinding.tvEndTime.text = lesson.endTime
            //itemBinding.ivColor.background
            itemBinding.tvTrainerName.text = trainer.name
            itemBinding.tvPlace.text = lesson.place
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val itemBinding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleHolder(itemBinding)
    }

    override fun getItemCount(): Int = lessonList.size

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        val lesson: Lesson = lessonList[position]
        val trainer: Trainer = trainerList[position]
        holder.bind(lesson, trainer)
    }
}