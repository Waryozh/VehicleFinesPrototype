package ru.waryozh.vehiclefinesprototype.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_walkthrough.view.*
import ru.waryozh.vehiclefinesprototype.R

class WalkthroughFragment : Fragment() {
    companion object {
        private const val WALKTHROUGH_NOTE_STRING_ID = "WALKTHROUGH_NOTE_STRING_ID"

        fun create(@StringRes stringId: Int): WalkthroughFragment {
            val fragment = WalkthroughFragment()
            fragment.arguments = Bundle().apply {
                putInt(WALKTHROUGH_NOTE_STRING_ID, stringId)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_walkthrough, container, false)

        val noteStringId = arguments?.getInt(WALKTHROUGH_NOTE_STRING_ID) ?: 0
        view.tv_walkthrough_note.text = getString(noteStringId)

        return view
    }
}
