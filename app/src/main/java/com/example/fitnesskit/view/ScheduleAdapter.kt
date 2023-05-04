package com.example.fitnesskit.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.databinding.ScheduleItemBinding
import com.example.fitnesskit.model.Lesson
import com.example.fitnesskit.model.Trainer

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder>() {

    private var listTrainer = emptyList<Trainer>()
    private var listLesson = emptyList<Lesson>()

    inner class ScheduleHolder(private val itemBinding: ScheduleItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(trainer: Trainer, lesson: Lesson) {
            itemBinding.tvStartTime.text = lesson.startTime
            itemBinding.tvLessonsName.text = lesson.name
            itemBinding.tvEndTime.text = lesson.endTime
            itemBinding.ivColor.setBackgroundColor(Color.parseColor(lesson.color))
            itemBinding.tvTrainerName.text = trainer.full_name
            itemBinding.tvPlace.text = lesson.place
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        return ScheduleHolder(
            ScheduleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listTrainer.size

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        val trainer = listTrainer[position]
        val lesson = listLesson[position]
        holder.bind(trainer, lesson)

    }

    fun setList(trainer: List<Trainer>, lesson: List<Lesson>) {
        listTrainer = trainer
        listLesson = lesson
        notifyDataSetChanged()
    }

}