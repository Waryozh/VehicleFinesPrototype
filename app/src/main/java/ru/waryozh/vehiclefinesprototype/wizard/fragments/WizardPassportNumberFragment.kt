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
import kotlinx.android.synthetic.main.fragment_wizard_passport_number.*
import kotlinx.android.synthetic.main.fragment_wizard_passport_number.view.*
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.WizardPassportNumberFragmentComponent
import ru.waryozh.vehiclefinesprototype.util.showSoftKeyboard
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

        view.btn_wizard_passport_number_skip.setOnClickListener {
            SkipPassportNumberDialogFragment().show(
                childFragmentManager,
                SKIP_PASSPORT_NUMBER_DIALOG_TAG
            )
        }

        view.btn_wizard_passport_number_proceed.setOnClickListener {
            // When this button is clicked, text input field might be empty
            // and with its error disabled, so ask view model to validate it.
            wizardViewModel.onPassportNumberChanged(et_wizard_passport_number.text.toString())
            if (wizardViewModel.isPassportNumberInvalid.value == false) {
                wizardViewModel.passportNumber = et_wizard_passport_number.text.toString()
                navigateToWizardDriverLicenceFragment()
            }
        }

        view.et_wizard_passport_number.showSoftKeyboard()

        view.et_wizard_passport_number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                wizardViewModel.onPassportNumberChanged(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        wizardViewModel.isPassportNumberInvalid.observe(
            this,
            Observer { updatePassportNumberError(it) })

        return view
    }

    private fun updatePassportNumberError(isError: Boolean) {
        til_wizard_passport_number.isErrorEnabled = isError
        til_wizard_passport_number.error =
            if (isError) getString(R.string.passport_number_invalid) else null
    }

    private fun navigateToWizardDriverLicenceFragment() {
        findNavController().navigate(WizardPassportNumberFragmentDirections.actionWizardPassportNumberFragmentToWizardDriverLicenceFragment())
    }

    override fun onSkipPassportNumberDialogPositiveClick() {
        navigateToWizardDriverLicenceFragment()
    }
}
