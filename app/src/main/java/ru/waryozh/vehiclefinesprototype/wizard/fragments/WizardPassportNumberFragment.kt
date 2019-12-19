package ru.waryozh.vehiclefinesprototype.wizard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_wizard_passport_number.*
import kotlinx.android.synthetic.main.fragment_wizard_passport_number.view.*
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.WizardPassportNumberFragmentComponent
import ru.waryozh.vehiclefinesprototype.wizard.WizardViewModel
import ru.waryozh.vehiclefinesprototype.wizard.dialogs.SkipPassportNumberDialogFragment
import javax.inject.Inject

private const val SKIP_PASSPORT_NUMBER_DIALOG_TAG = "SKIP_PASSPORT_NUMBER_DIALOG_TAG"

class WizardPassportNumberFragment : Fragment(),
    SkipPassportNumberDialogFragment.SkipPassportNumberDialogListener {

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
            .plus(WizardPassportNumberFragmentComponent.Module())
            .inject(this)

        val view = inflater.inflate(R.layout.fragment_wizard_passport_number, container, false)

        view.btn_wizard_passport_number_proceed.setOnClickListener {
            wizardViewModel.setPassportNumber(et_wizard_passport_number.text.toString())
            navigateToWizardDriverLicenceFragment()
        }

        view.btn_wizard_passport_number_skip.setOnClickListener {
            SkipPassportNumberDialogFragment().show(
                childFragmentManager,
                SKIP_PASSPORT_NUMBER_DIALOG_TAG
            )
        }

        return view
    }

    private fun navigateToWizardDriverLicenceFragment() {
        findNavController().navigate(WizardPassportNumberFragmentDirections.actionWizardPassportNumberFragmentToWizardDriverLicenceFragment())
    }

    override fun onSkipPassportNumberDialogPositiveClick() {
        navigateToWizardDriverLicenceFragment()
    }
}
