package com.example.emotnionsdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.emotionsdiary.EmotionsCircle

class DiaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary_emotions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextButton: Button = view.findViewById(R.id.diaryNextButton)
        val emotionsEditText: EditText = view.findViewById(R.id.input_emotionsEditText)
        val contentEditText: EditText = view.findViewById(R.id.contentEditText)

        nextButton.setOnClickListener {
            val title = emotionsEditText.text.toString()
            val content = contentEditText.text.toString()


            val emotionsCircleFragment = EmotionsCircle.newInstance(title, content)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, emotionsCircleFragment)
                .commit()
        }
    }
}
