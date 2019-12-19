package ru.waryozh.vehiclefinesprototype.wizard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_wizard_welcome.view.*
import ru.waryozh.vehiclefinesprototype.R

class WizardWelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wizard_welcome, container, false)

        view.btn_welcome_enter.setOnClickListener {
            findNavController().navigate(WizardWelcomeFragmentDirections.actionWelcomeFragmentToWizardRegNumberFragment())
        }

        return view
    }
}
