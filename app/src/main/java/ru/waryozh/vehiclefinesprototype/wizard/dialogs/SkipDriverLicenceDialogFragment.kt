package ru.waryozh.vehiclefinesprototype.wizard.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.waryozh.vehiclefinesprototype.R

class SkipDriverLicenceDialogFragment : DialogFragment() {
    private lateinit var listener: SkipDriverLicenceDialogListener

    interface SkipDriverLicenceDialogListener {
        fun onSkipDriverLicenceDialogPositiveClick()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host fragment implements the callback interface
        try {
            listener = parentFragment as SkipDriverLicenceDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement SkipDriverLicenceDialogListener"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity!!.let {
            AlertDialog.Builder(it, 0)
                .setMessage(R.string.skip_driver_licence_dialog_title)
                .setPositiveButton(R.string.skip_enter_dialog) { _, _ ->
                    listener.onSkipDriverLicenceDialogPositiveClick()
                    dismiss()
                }
                .setNegativeButton(R.string.dismiss_enter_dialog) { _, _ ->
                    dismiss()
                }
                .create()
        }
    }
}
