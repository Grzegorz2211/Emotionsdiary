package com.example.emotnionsdiary.emotions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.emotnionsdiary.Constant.ARG_CONTENT
import com.example.emotnionsdiary.Constant.ARG_TITLE
import com.example.emotnionsdiary.DiaryViewAll
import com.example.emotnionsdiary.R
import com.example.emotnionsdiary.services.DiaryService

class NegativeEmotionsFragment : Fragment() {
    private var title: String? = null
    private var content: String? = null
    private lateinit var backendService: DiaryService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            content = it.getString(ARG_CONTENT)
        }
        backendService = DiaryService(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_negative_emotions, container, false)
        val emotionsButtonsFragment: Button = view.findViewById(R.id.btnPowrótNE)

        val buttonIds = arrayOf(
            R.id.btnZaalarmowany,
            R.id.btnWściekły,
            R.id.btnZestresowany,
            R.id.btnRozzłoszczony,
            R.id.btnPrzestraszony,
            R.id.btnZdenerwowany,
            R.id.btnRoztrzęsiony,
            R.id.btnZaniepokojony,
            R.id.btnPrzekorny
        )
        emotionsButtonsFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    EmotionsButtonsFragment.newInstance(title, content)
                ).commit()
        }

        for (id in buttonIds) {
            view.findViewById<Button>(id).setOnClickListener { button ->
                val buttonText = (button as Button).text
                backendService.saveDiary(title, content, buttonText.toString())
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, DiaryViewAll())
                    .addToBackStack(null)
                    .commit()
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String?, content: String?) =
            NegativeEmotionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_CONTENT, content)
                }
            }
    }
}