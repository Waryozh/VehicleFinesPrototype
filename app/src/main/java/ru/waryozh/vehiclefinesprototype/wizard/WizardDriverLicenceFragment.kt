package ru.waryozh.vehiclefinesprototype.wizard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_wizard_driver_licence.*
import kotlinx.android.synthetic.main.fragment_wizard_driver_licence.view.*
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.WizardDriverLicenceFragmentComponent
import ru.waryozh.vehiclefinesprototype.overview.OverviewActivity
import javax.inject.Inject

class WizardDriverLicenceFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val wizardViewModel: WizardViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(WizardViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().application as App).appComponent
            .plus(WizardDriverLicenceFragmentComponent.Module())
            .inject(this)

        val view = inflater.inflate(R.layout.fragment_wizard_driver_licence, container, false)
        view.btn_wizard_driver_licence_proceed.setOnClickListener { navigateToOverviewActivity() }
        return view
    }

    private fun navigateToOverviewActivity() {
        wizardViewModel.setDriverLicence(et_wizard_driver_licence.text.toString())
        startActivity(Intent(requireContext(), OverviewActivity::class.java))
    }
}
