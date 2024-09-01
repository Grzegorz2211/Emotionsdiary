package com.example.emotnionsdiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LowActivityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LowActivityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_low_activity, container, false)
        val emotionsButonsFragment: Button = view.findViewById(R.id.btnPowrotLA)
        // Set up the click handler
        emotionsButonsFragment.setOnClickListener {
            // Handle button click
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EmotionsButonsFragment()).commit()
        }
        // Tablica z identyfikatorami przycisków
        val buttonIds = arrayOf(R.id.btnZazdrosny,R.id.btnZgorzknialy,R.id.btnZmieszany,R.id.btnNieszczesliwy,R.id.btnZniechecony,R.id.btnSmutny,R.id.btnWzruszony,R.id.btnPonury,R.id.btnPrzybity,R.id.btnZawstydzony,R.id.btnZgnebiony,R.id.btnRozczarowany,R.id.btnOtepialy,R.id.btnZmeczony,R.id.btnOspaly,R.id.btnOciezaly,R.id.btnZnudzony1,R.id.btnApatyczny,R.id.btnWyciszony,R.id.btnSpokojny,R.id.btnCichy,R.id.btnNieaktywny,R.id.btnRozleniwiony,R.id.btnBierny,R.id.btnNiesmialy,R.id.btnPowazny,R.id.btnSenny)


        for (id in buttonIds) {
            view.findViewById<Button>(id).setOnClickListener { button ->
                // Pobierz tekst z przycisku
                val buttonText = (button as Button).text
                // Wyświetl Toast z nazwą przycisku
                Toast.makeText(activity, "Kliknięty przycisk: $buttonText", Toast.LENGTH_SHORT).show()
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
         * @return A new instance of fragment LowActivityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LowActivityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}