package com.example.emotnionsdiary.emotions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.emotnionsdiary.Constant.ARG_CONTENT
import com.example.emotnionsdiary.Constant.ARG_TITLE
import com.example.emotnionsdiary.R

class EmotionsButonsFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_emotions_butons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val positiveEmotionsButton: Button = view.findViewById(R.id.nav_PositiveEmotions)
        positiveEmotionsButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PostiveEmotionsFragment.newInstance(title, content))
                .addToBackStack(null)
                .commit()
        }

        val highActivationFragment: Button = view.findViewById(R.id.nav_HighActivation)
        highActivationFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HighActivationFragment.newInstance(title, content))
                .addToBackStack(null)
                .commit()
        }

        val lowActivityFragment: Button = view.findViewById(R.id.nav_LowActivity)
        lowActivityFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LowActivityFragment.newInstance(title, content))
                .addToBackStack(null)
                .commit()
        }

        val negativeEmotionsFragment: Button = view.findViewById(R.id.nav_NegativeEmotions)
        negativeEmotionsFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NegativeEmotionsFragment.newInstance(title, content))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String?, content: String?) =
            EmotionsButonsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_CONTENT, content)
                }
            }

    }
}
