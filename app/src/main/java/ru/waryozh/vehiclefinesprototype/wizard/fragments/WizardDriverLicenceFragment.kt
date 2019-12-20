package ru.waryozh.vehiclefinesprototype.wizard.fragments

import android.content.Intent
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
import kotlinx.android.synthetic.main.fragment_wizard_driver_licence.*
import kotlinx.android.synthetic.main.fragment_wizard_driver_licence.view.*
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.WizardDriverLicenceFragmentComponent
import ru.waryozh.vehiclefinesprototype.overview.OverviewActivity
import ru.waryozh.vehiclefinesprototype.wizard.WizardViewModel
import ru.waryozh.vehiclefinesprototype.wizard.dialogs.SkipDriverLicenceDialogFragment
import javax.inject.Inject

private const val SKIP_DRIVER_LICENCE_DIALOG_TAG = "SKIP_DRIVER_LICENCE_DIALOG_TAG"

class WizardDriverLicenceFragment : Fragment(),
    SkipDriverLicenceDialogFragment.SkipDriverLicenceDialogListener {

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

        view.btn_wizard_driver_licence_skip.setOnClickListener {
            SkipDriverLicenceDialogFragment().show(
                childFragmentManager,
                SKIP_DRIVER_LICENCE_DIALOG_TAG
            )
        }

        view.btn_wizard_driver_licence_proceed.setOnClickListener {
            // When this button is clicked, text input field might be empty
            // and with its error disabled, so ask view model to validate it.
            wizardViewModel.onDriverLicenceChanged(et_wizard_driver_licence.text.toString())
            if (wizardViewModel.isDriverLicenceInvalid.value == false) {
                wizardViewModel.setDriverLicence(et_wizard_driver_licence.text.toString())
                navigateToOverviewActivity()
            }
        }

        view.et_wizard_driver_licence.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                wizardViewModel.onDriverLicenceChanged(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        wizardViewModel.isDriverLicenceInvalid.observe(
            this,
            Observer { updateDriverLicenceError(it) })

        return view
    }

    private fun updateDriverLicenceError(isError: Boolean) {
        til_wizard_driver_licence.isErrorEnabled = isError
        til_wizard_driver_licence.error =
            if (isError) getString(R.string.licence_number_invalid) else null
    }

    private fun navigateToOverviewActivity() {
        startActivity(Intent(requireContext(), OverviewActivity::class.java))
        activity!!.finish()
    }

    override fun onSkipDriverLicenceDialogPositiveClick() {
        navigateToOverviewActivity()
    }
}
