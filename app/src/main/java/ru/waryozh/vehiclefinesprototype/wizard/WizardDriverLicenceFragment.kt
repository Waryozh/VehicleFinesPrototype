package ru.waryozh.vehiclefinesprototype.wizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.waryozh.vehiclefinesprototype.R

class WizardDriverLicenceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wizard_driver_licence, container, false)
        return view
    }
}
