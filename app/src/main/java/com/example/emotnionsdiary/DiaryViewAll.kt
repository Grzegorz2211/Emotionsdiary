package com.example.emotnionsdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emotnionsdiary.adapters.DiaryAdapter
import com.example.emotnionsdiary.services.DiaryService

class DiaryViewAll : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var diaryAdapter: DiaryAdapter
    private lateinit var diaryService: DiaryService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_diary_view_all, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        diaryService = DiaryService(requireContext())

        val diaries = diaryService.getAllDiaries()

        diaryAdapter = DiaryAdapter(diaries.toMutableList(), diaryService)
        recyclerView.adapter = diaryAdapter

        return view
    }
}
