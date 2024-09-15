package com.example.emotnionsdiary

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import com.example.emotionsdiary.EmotionsCircle

// Constants for argument keys
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DiaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiaryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary_emotions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI components
//        val saveButton: Button = view.findViewById(R.id.saveButton)
        val nextButton: Button = view.findViewById(R.id.diaryNextButton)
        val emotionsEditText: EditText = view.findViewById(R.id.input_emotionsEditText)
        val contentEditText: EditText = view.findViewById(R.id.contentEditText)

        // Set up the click listener for the 'Next' button to navigate to EmotionsCircle Fragment
        nextButton.setOnClickListener {
            val title = emotionsEditText.text.toString()
            val content = contentEditText.text.toString()

            // Create a new instance of EmotionsCircle and pass the data via arguments

            val emotionsCircleFragment = EmotionsCircle.newInstance(title, content)

            // Replace the fragment and pass the data
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, emotionsCircleFragment)
                .commit()
        }

        // Set up the 'Save' button listener
//        saveButton.setOnClickListener(object : OnClickListener {
//            override fun onClick(v: View?) {
//                val userTitleInput = emotionsEditText.text.toString()
//                val userContentInput = contentEditText.text.toString()
//
//                Log.d("UserInput", "Title: '$userTitleInput', Content: '$userContentInput'")
//                val resp = backendService.saveEmotionsEditText(userTitleInput)
//
//                // Show a toast message confirming the input
//                Toast.makeText(requireActivity(), "You entered: $userTitleInput", Toast.LENGTH_LONG).show()
//
//                // Create an Intent to navigate to the Next Activity (or Fragment if desired)
//                val intent = Intent(requireContext(), EmotionsCircle::class.java)
//                intent.putExtra("TITLE", userTitleInput)
//                intent.putExtra("CONTENT", userContentInput)
//                startActivity(intent)
//            }
//        })
    }
}
