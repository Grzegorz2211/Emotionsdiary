package com.example.emotnionsdiary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emotnionsdiary.R
import com.example.emotnionsdiary.database.Diary
import com.example.emotnionsdiary.services.DiaryService

class DiaryAdapter(
    private var diaries: MutableList<Diary>,
    private val diaryService: DiaryService
) : RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {

    inner class DiaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val diaryTitle: TextView = itemView.findViewById(R.id.tvDiaryTitle)
        val diaryContent: TextView = itemView.findViewById(R.id.tvDiaryContent)
        val diaryEmotion: TextView = itemView.findViewById(R.id.tvDiaryEmotion)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.diary_item, parent, false)
        return DiaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        val diary = diaries[position]
        holder.diaryTitle.text = diary.title
        holder.diaryContent.text = diary.content
        holder.diaryEmotion.text = diary.emotion

        holder.btnDelete.setOnClickListener {
            diaryService.deleteDiary(diary.id)

            diaries.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, diaries.size)
        }
    }

    override fun getItemCount(): Int = diaries.size
}
