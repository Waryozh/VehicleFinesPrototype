package ru.waryozh.vehiclefinesprototype.wizard.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.waryozh.vehiclefinesprototype.R

class SkipPassportNumberDialogFragment : DialogFragment() {
    private lateinit var listener: SkipPassportNumberDialogListener

    interface SkipPassportNumberDialogListener {
        fun onSkipPassportNumberDialogPositiveClick()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host fragment implements the callback interface
        try {
            listener = parentFragment as SkipPassportNumberDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement SkipPassportNumberDialogListener"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity!!.let {
            AlertDialog.Builder(it, 0)
                .setMessage(R.string.skip_passport_number_dialog_title)
                .setPositiveButton(R.string.skip_enter_dialog) { _, _ ->
                    listener.onSkipPassportNumberDialogPositiveClick()
                    dismiss()
                }
                .setNegativeButton(R.string.dismiss_enter_dialog) { _, _ ->
                    dismiss()
                }
                .create()
        }
    }
}
