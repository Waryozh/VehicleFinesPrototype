package ru.waryozh.vehiclefinesprototype.wizard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_wizard_driver_licence.view.*
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.overview.OverviewActivity

class WizardDriverLicenceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wizard_driver_licence, container, false)
        view.btn_wizard_driver_licence_proceed.setOnClickListener { navigateToOverviewActivity() }
        return view
    }

    private fun navigateToOverviewActivity() {
        startActivity(Intent(requireContext(), OverviewActivity::class.java))
    }
}
