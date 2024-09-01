package com.example.emotnionsdiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewOfTheDiary : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerViewJournal: RecyclerView
    //private lateinit var journalAdapter: JournalAdapter

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_of_the_diary, container, false)
        recyclerViewJournal = view.findViewById(R.id.recyclerViewJournal)
        // Tutaj możesz dodać kod do inicjalizacji RecyclerView i adaptera
        //val view = inflater.inflate(R.layout.fragment_view_of_the_diary, container, false)
        //recyclerViewJournal = view.findViewById(R.id.recyclerViewJournal)

        // Przykładowe dane do dziennika
        //val journalEntries = listOf(
            //JournalEntry("Radość", "Czułem się bardzo szczęśliwy dzisiaj!"),
            //JournalEntry("Smutek", "Miałem trudny dzień."),
            //JournalEntry("Złość", "Wkurzyłem się na kolegę."),
            // Dodaj więcej wpisów według potrzeby
       // )

        // Inicjalizacja adaptera z danymi
       // recyclerViewJournal.layoutManager = LinearLayoutManager(context)
       // recyclerViewJournal.adapter = JournalAdapter(journalEntries)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewOfTheDiary().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}



