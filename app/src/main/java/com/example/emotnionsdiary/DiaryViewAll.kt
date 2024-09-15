package com.example.emotnionsdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emotnionsdiary.database.DiaryDatabaseHelper

class DiaryViewAll : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var diaryAdapter: DiaryAdapter
    private lateinit var diaryDatabaseHelper: DiaryDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_diary_view_all, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        diaryDatabaseHelper = DiaryDatabaseHelper(requireContext())
        val diaries = diaryDatabaseHelper.getAllDiaries()

        diaryAdapter = DiaryAdapter(diaries)
        recyclerView.adapter = diaryAdapter

        return view
    }
}
