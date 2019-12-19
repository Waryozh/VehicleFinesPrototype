package ru.waryozh.vehiclefinesprototype.wizard.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_wizard_reg_number.*
import kotlinx.android.synthetic.main.fragment_wizard_reg_number.view.*
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.WizardRegNumberFragmentComponent
import ru.waryozh.vehiclefinesprototype.wizard.WizardViewModel
import ru.waryozh.vehiclefinesprototype.wizard.dialogs.SkipRegNumberDialogFragment
import javax.inject.Inject

private const val SKIP_REG_NUMBER_DIALOG_TAG = "SKIP_REG_NUMBER_DIALOG_TAG"

class WizardRegNumberFragment : Fragment(),
    SkipRegNumberDialogFragment.SkipRegNumberDialogListener {

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

        view.btn_wizard_reg_number_proceed.setOnClickListener {
            // When this button is clicked, text input field might be empty
            // and with its error disabled, so ask view model to validate it.
            wizardViewModel.onRegNumberChanged(et_wizard_reg_number.text.toString())
            if (wizardViewModel.isRegNumberInvalid.value == false) {
                navigateToWizardPassportNumberFragment()
            }
        }

        view.btn_wizard_reg_number_skip.setOnClickListener {
            SkipRegNumberDialogFragment().show(
                childFragmentManager,
                SKIP_REG_NUMBER_DIALOG_TAG
            )
        }

        view.et_wizard_reg_number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                wizardViewModel.onRegNumberChanged(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        wizardViewModel.isRegNumberInvalid.observe(this, Observer { updateRegNumberError(it) })

        return view
    }

    private fun updateRegNumberError(isError: Boolean) {
        til_wizard_reg_number.isErrorEnabled = isError
        til_wizard_reg_number.error = if (isError) getString(R.string.reg_number_invalid) else null
    }

    private fun navigateToWizardPassportNumberFragment() {
        wizardViewModel.setRegNumber(et_wizard_reg_number.text.toString())
        findNavController().navigate(WizardRegNumberFragmentDirections.actionWizardRegNumberFragmentToWizardPassportNumberFragment())
    }

    override fun onSkipRegNumberDialogPositiveClick() {
        // When skipping reg number, we can also skip passport number and transition directly to driver licence fragment
        findNavController().navigate(WizardRegNumberFragmentDirections.actionWizardRegNumberFragmentToWizardDriverLicenceFragment())
    }
}
