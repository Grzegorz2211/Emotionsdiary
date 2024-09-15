package com.example.emotnionsdiary

import DiaryAdapter
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

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Initialize Database Helper
        diaryDatabaseHelper = DiaryDatabaseHelper(requireContext())

        // Fetch diary entries from the database
        val diaries = diaryDatabaseHelper.getAllDiaries()  // This should return a mutable list

        // Initialize Adapter with the list and database helper
        diaryAdapter = DiaryAdapter(diaries.toMutableList(), diaryDatabaseHelper)  // Ensure mutable list
        recyclerView.adapter = diaryAdapter

        return view
    }
}
