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

class HighActivationFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_high_activation, container, false)

        val emotionsButtonFragment: Button = view.findViewById(R.id.PowrótHA)
        emotionsButtonFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EmotionsButtonsFragment.newInstance(title, content))
                .addToBackStack(null)
                .commit()
        }

        val buttonIds = arrayOf(
            R.id.btnZdumiony,
            R.id.btnPobudzony,
            R.id.btnZdziwiony,
            R.id.btnAktywny,
            R.id.btnSkupiony,
            R.id.btnPodekscytowany,
            R.id.btnChętny,
            R.id.btnEntuzjastyczny,
            R.id.btnUradowany,
            R.id.btnEuforyczny,
            R.id.btnOżywiony,
            R.id.btnPełenWerwy
        )

        for (id in buttonIds) {
            view.findViewById<Button>(id).setOnClickListener { button ->
                val buttonText = (button as Button).text.toString()

                backendService.saveDiary(title, content, buttonText)

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
            HighActivationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_CONTENT, content)
                }
            }
    }
}
