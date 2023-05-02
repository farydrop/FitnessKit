package com.example.fitnesskit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.R
import com.example.fitnesskit.databinding.ScheduleItemBinding
import com.example.fitnesskit.model.Lesson
import com.example.fitnesskit.model.Trainer
import com.example.fitnesskit.model.Trainers

class ScheduleAdapter(
//    private val lessonList: List<Lesson>,
//    private val trainerList: List<Trainer>,
) : RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder>() {

    //var listStart = emptyList<BestSellerItem>()
    //private var listStart = emptyList<Trainers>()

    /*class ScheduleHolder(view: View):RecyclerView.ViewHolder(view){
        *//*val discountPrice: TextView = view.findViewById<TextView>(R.id.discount_price)
        val priceWithoutDiscount: TextView = view.findViewById<TextView>(R.id.price_without_discount)
        val title: TextView = view.findViewById<TextView>(R.id.title)
        val picture = view.findViewById<ImageView>(R.id.picture)
        val isFavorites = view.findViewById<ImageView>(R.id.favorites)*//*
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.schedule_item,parent,false)
        return ScheduleHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        holder.discountPrice.text = listStart[position].discount_price.toString()
        holder.priceWithoutDiscount.text = listStart[position].price_without_discount.toString()
        holder.title.text = listStart[position].title

        Picasso.with(holder.picture.context)
            .load(listStart[position].picture)
            .into(holder.picture)

    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    fun setlist(list: List<BestSellerItem>){
        listStart = list
        notifyDataSetChanged()
    }
*/
    //private var listStart = emptyList<Trainers>()
    //private var listTrainer = emptyList<Pair<Lesson,Trainer>>()
    private var listTrainer = emptyList<Trainer>()
    private var listLesson = emptyList<Lesson>()

    class ScheduleHolder(view: View) : RecyclerView.ViewHolder(view) {

        val trainerName: TextView = view.findViewById<TextView>(R.id.tvTrainerName)
        val lessonName: TextView = view.findViewById<TextView>(R.id.tvLessonsName)
        val startTime: TextView = view.findViewById<TextView>(R.id.tvStartTime)
        val endTime: TextView = view.findViewById<TextView>(R.id.tvEndTime)
        val place: TextView = view.findViewById<TextView>(R.id.tvPlace)
        /*fun bind(trainers: Trainer) {
            //itemBinding.tvStartTime.text = lesson.startTime
            //itemBinding.tvLessonsName.text = lesson.name
            //itemBinding.tvEndTime.text = lesson.endTime
            //itemBinding.ivColor.background
            itemBinding.tvTrainerName.text = trainers.full_name
            //itemBinding.tvPlace.text = lesson.place
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        /*val itemBinding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleHolder(itemBinding)*/
        val view = LayoutInflater.from(parent.context).inflate(R.layout.schedule_item,parent,false)
        return ScheduleHolder(view)
    }

    override fun getItemCount(): Int = listTrainer.size + listLesson.size

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        /*val lesson: Lesson = lessonList[position]
        val trainer: Trainer = trainerList[position]*/
        //val schedule = listTrainer[position]
        holder.trainerName.text = listTrainer[position].name
        holder.lessonName.text = listLesson[position].name
        holder.startTime.text = listLesson[position].startTime
        holder.endTime.text = listLesson[position].endTime
        holder.place.text = listLesson[position].place
        //holder.bind(schedule)
    }

    fun setList(list: List<Trainer>,list2: List<Lesson>){
        listTrainer = list
        listLesson = list2
        notifyDataSetChanged()
    }

}