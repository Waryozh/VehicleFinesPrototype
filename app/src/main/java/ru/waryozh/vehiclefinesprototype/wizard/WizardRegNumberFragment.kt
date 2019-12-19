package ru.waryozh.vehiclefinesprototype.wizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_wizard_reg_number.*
import kotlinx.android.synthetic.main.fragment_wizard_reg_number.view.*
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.WizardRegNumberFragmentComponent
import javax.inject.Inject

class WizardRegNumberFragment : Fragment() {

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
            .plus(WizardRegNumberFragmentComponent.Module())
            .inject(this)

        val view = inflater.inflate(R.layout.fragment_wizard_reg_number, container, false)
        view.btn_wizard_reg_number_proceed.setOnClickListener { navigateToWizardPassportNumberFragment() }
        return view
    }

    private fun navigateToWizardPassportNumberFragment() {
        wizardViewModel.setRegNumber(et_wizard_reg_number.text.toString())
        findNavController().navigate(WizardRegNumberFragmentDirections.actionWizardRegNumberFragmentToWizardPassportNumberFragment())
    }
}
