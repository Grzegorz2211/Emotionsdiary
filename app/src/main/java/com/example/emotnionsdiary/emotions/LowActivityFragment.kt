package com.example.emotnionsdiary.emotions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.emotnionsdiary.Constant.ARG_CONTENT
import com.example.emotnionsdiary.Constant.ARG_TITLE
import com.example.emotnionsdiary.services.DiaryService
import com.example.emotnionsdiary.R

class LowActivityFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        val view = inflater.inflate(R.layout.fragment_low_activity, container, false)
        val emotionsButtonFragment: Button = view.findViewById(R.id.btnPowrotLA)

        emotionsButtonFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    EmotionsButonsFragment.newInstance(title, content)
                ).commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttonIds = arrayOf(
            R.id.btnZazdrosny,
            R.id.btnZgorzknialy,
            R.id.btnZmieszany,
            R.id.btnNieszczesliwy,
            R.id.btnZniechecony,
            R.id.btnSmutny,
            R.id.btnWzruszony,
            R.id.btnPonury,
            R.id.btnPrzybity,
            R.id.btnZawstydzony,
            R.id.btnZgnebiony,
            R.id.btnRozczarowany,
            R.id.btnOtepialy,
            R.id.btnZmeczony,
            R.id.btnOspaly,
            R.id.btnOciezaly,
            R.id.btnZnudzony1,
            R.id.btnApatyczny,
            R.id.btnWyciszony,
            R.id.btnSpokojny,
            R.id.btnCichy,
            R.id.btnNieaktywny,
            R.id.btnRozleniwiony,
            R.id.btnBierny,
            R.id.btnNiesmialy,
            R.id.btnPowazny,
            R.id.btnSenny
        )

        for (id in buttonIds) {
            view.findViewById<Button>(id).setOnClickListener { button ->
                val buttonText = (button as Button).text
                val resp = backendService.saveDiary(title, content, buttonText.toString())
                Toast.makeText(requireActivity(), "You entereds: $resp", Toast.LENGTH_LONG).show()
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(title: String?, content: String?) =
            LowActivityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_CONTENT, content)
                }
            }
    }
}