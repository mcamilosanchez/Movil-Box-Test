package com.example.testmovilbox.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import com.example.testmovilbox.R
import com.example.testmovilbox.databinding.DialogConfirmationBinding

class CustomDialog (private val context: Context) {
    private lateinit var bindingConfirmation: DialogConfirmationBinding
    private var customDialog: AlertDialog? = null
    private fun initializeViewBindingConfirmation(dialogView: View) {
        bindingConfirmation = DialogConfirmationBinding.bind(dialogView)
    }
    fun showLoadingDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
        customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(false)
            .create()
        customDialog?.show()
    }

    fun dismissLoadingDialog() {
        customDialog?.dismiss()
    }

    fun showConfirmationDialog(
        title: String,
        message: String,
        positiveButtonListener: () -> Unit
    ) {
        val dialogView = LayoutInflater.from(context)
            .inflate(R.layout.dialog_confirmation, null)

        initializeViewBindingConfirmation(dialogView)

        customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        bindingConfirmation.tVTitleDialogConfirmation.text = title
        bindingConfirmation.tVMessageDialogConfirmation.text = message

        bindingConfirmation.buttonOkDialogConfirmation.setOnClickListener {
            positiveButtonListener.invoke()
            customDialog?.dismiss()
        }
        customDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog?.show()
    }

}