package ru.waryozh.vehiclefinesprototype.wizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_wizard_reg_number.view.*
import ru.waryozh.vehiclefinesprototype.R

class WizardRegNumberFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wizard_reg_number, container, false)
        view.btn_wizard_reg_number_proceed.setOnClickListener { navigateToWizardPassportNumberFragment() }
        return view
    }

    private fun navigateToWizardPassportNumberFragment() {
        findNavController().navigate(WizardRegNumberFragmentDirections.actionWizardRegNumberFragmentToWizardPassportNumberFragment())
    }
}
