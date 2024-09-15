package com.example.emotnionsdiary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emotnionsdiary.database.Diary

class DiaryAdapter(private val diaries: List<Diary>) : RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {
    inner class DiaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val content: TextView = itemView.findViewById(R.id.tvContent)
        val emotion: TextView = itemView.findViewById(R.id.tvEmotion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return DiaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        val diary = diaries[position]
        holder.title.text = diary.title
        holder.content.text = diary.content
        holder.emotion.text = diary.emotion
    }

    override fun getItemCount(): Int = diaries.size
}
