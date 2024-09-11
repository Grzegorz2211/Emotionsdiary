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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PostiveEmotionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostiveEmotionsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_postive_emotions, container, false)
        val emotionsButonsFragment: Button = view.findViewById(R.id.btnPowrótPE)
        // Set up the click handler
        emotionsButonsFragment.setOnClickListener {
            // Handle button click
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EmotionsButonsFragment()).commit()
        }
        // Tablica z identyfikatorami przycisków
        val buttonIds = arrayOf(R.id.btnRozbawiony, R.id.btnDumny, R.id.btnCzuły, R.id.btnSzczęśliwy,R.id.btnZachwycony,R.id.btnUradowany,R.id.btnRadosny,R.id.btnSerdeczny,R.id.btnZadowolony,R.id.btnNostalgiczny,R.id.btnSkromny,R.id.btnPogodny,R.id.btnRozluźniony,R.id.btnWypoczęty,R.id.btnSpokojny,R.id.btnOdprężony)


        for (id in buttonIds) {
            view.findViewById<Button>(id).setOnClickListener { button ->
                // Pobierz tekst z przycisku
                val buttonText = (button as Button).text
                val resp = backendService.saveEmotion(buttonText.toString())
                Toast.makeText(requireActivity(), "You entereds: $resp", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PostiveEmotionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PostiveEmotionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}