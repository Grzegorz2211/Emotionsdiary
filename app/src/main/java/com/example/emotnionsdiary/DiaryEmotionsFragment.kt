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
import  android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DiaryEmotionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiaryEmotionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var backendService: EmotionsDiaryService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        backendService = EmotionsDiaryService()
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
        val saveButton: Button = view.findViewById(R.id.saveButton)

        val emotionsCircle: Button = view.findViewById(R.id.diaryNextButton)
        // Set up the click handler
        emotionsCircle.setOnClickListener {
            // Handle button click
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EmotionsCircle()).commit()
        }

        saveButton.setOnClickListener(object: OnClickListener {
            override fun onClick(v: View?) {
                val emotionsEditText: EditText = view.findViewById<EditText>(R.id.input_emotionsEditText)
                val userInput = emotionsEditText.text.toString()
                Log.d("UserInput", "Input: '$userInput'")
                val resp = backendService.saveEmotionsEditText(userInput.toString())
                Toast.makeText(requireActivity(), "You entered: $userInput", Toast.LENGTH_LONG).show()

            }
        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DiaryEmotionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DiaryEmotionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    //"@+id/input_emotionsEditText"
                }
            }
    }
}