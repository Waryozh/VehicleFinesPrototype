package ru.waryozh.vehiclefinesprototype.wizard.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.waryozh.vehiclefinesprototype.R

class SkipRegNumberDialogFragment : DialogFragment() {
    private lateinit var listener: SkipRegNumberDialogListener

    interface SkipRegNumberDialogListener {
        fun onSkipRegNumberDialogPositiveClick()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host fragment implements the callback interface
        try {
            listener = parentFragment as SkipRegNumberDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement SkipRegNumberDialogListener"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity!!.let {
            AlertDialog.Builder(it, 0)
                .setMessage(R.string.skip_reg_number_dialog_title)
                .setPositiveButton(R.string.skip_enter_dialog) { _, _ ->
                    listener.onSkipRegNumberDialogPositiveClick()
                    dismiss()
                }
                .setNegativeButton(R.string.dismiss_enter_dialog) { _, _ ->
                    dismiss()
                }
                .create()
        }
    }
}
