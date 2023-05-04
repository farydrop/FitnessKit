package com.example.fitnesskit.view

import android.annotation.SuppressLint
import android.graphics.*
import android.graphics.drawable.*
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.R
import com.example.fitnesskit.databinding.ScheduleItemBinding
import com.example.fitnesskit.model.Lesson
import com.example.fitnesskit.model.Trainer
import java.util.Collections

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder>() {

    private var listTrainer = emptyList<Trainer>()
    private var listLesson = emptyList<Lesson>()

    inner class ScheduleHolder(private val itemBinding: ScheduleItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(trainer: Trainer, lesson: Lesson) {
            itemBinding.tvStartTime.text = lesson.startTime
            itemBinding.tvLessonsName.text = lesson.name
            itemBinding.tvEndTime.text = lesson.endTime
            itemBinding.tvTrainerName.text = trainer.full_name
            itemBinding.tvPlace.text = lesson.place

            val bitmap = (ContextCompat.getDrawable(itemView.context,R.drawable.rounded_corner) as GradientDrawable)
            bitmap.setColor(Color.parseColor(lesson.color))
            itemBinding.ivColor.setImageDrawable(bitmap)
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

    fun Drawable.overrideColor(@ColorInt colorInt: Int) {
        when (this) {
            is GradientDrawable -> setColor(colorInt)
            is ShapeDrawable -> paint.color = colorInt
            is ColorDrawable -> color = colorInt
        }
    }

}