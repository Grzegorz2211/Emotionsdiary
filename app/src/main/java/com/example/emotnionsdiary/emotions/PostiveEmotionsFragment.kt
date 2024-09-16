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
import com.example.emotnionsdiary.services.DiaryService
import com.example.emotnionsdiary.R

class PostiveEmotionsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_postive_emotions, container, false)
        val emotionsButtonsFragment: Button = view.findViewById(R.id.btnPowrótPE)
        emotionsButtonsFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    EmotionsButonsFragment.newInstance(title, content)
                ).commit()
        }
        val buttonIds = arrayOf(
            R.id.btnRozbawiony,
            R.id.btnDumny,
            R.id.btnCzuły,
            R.id.btnSzczęśliwy,
            R.id.btnZachwycony,
            R.id.btnUradowany,
            R.id.btnRadosny,
            R.id.btnSerdeczny,
            R.id.btnZadowolony,
            R.id.btnNostalgiczny,
            R.id.btnSkromny,
            R.id.btnPogodny,
            R.id.btnRozluźniony,
            R.id.btnWypoczęty,
            R.id.btnSpokojny,
            R.id.btnOdprężony
        )

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
            PostiveEmotionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_CONTENT, content)
                }
            }

    }
}