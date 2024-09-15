package com.example.emotionsdiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.emotnionsdiary.EmotionsButonsFragment
import com.example.emotnionsdiary.R

// Constants for arguments
const val ARG_TITLE = "title"
const val ARG_CONTENT = "content"

/**
 * A simple [Fragment] subclass.
 * Use the [EmotionsCircle.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmotionsCircle : Fragment() {
    private var title: String? = null
    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            content = it.getString(ARG_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emotions_circle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("TYTUL" + title)
        println("content elo" + content)

        // Set the received data to TextViews or any other UI component
//        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
//        val contentTextView: TextView = view.findViewById(R.id.contentTextView)

//        titleTextView.text = title
//        contentTextView.text = content

        // Button to navigate to the next fragment
        val nextButton: Button = view.findViewById(R.id.nav_nextbutton)
        val emotionsButtonsFragment = EmotionsButonsFragment.newInstance(title, content)

        nextButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, emotionsButtonsFragment)
                .commit()

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param title The title of the diary entry.
         * @param content The content of the diary entry.
         * @return A new instance of fragment EmotionsCircle.
         */
        @JvmStatic
        fun newInstance(title: String?, content: String?) =
            EmotionsCircle().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_CONTENT, content)
                }
            }
    }
}
