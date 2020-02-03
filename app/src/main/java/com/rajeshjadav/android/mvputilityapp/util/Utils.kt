package com.rajeshjadav.android.mvputilityapp.util

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import com.rajeshjadav.android.mvputilityapp.MainApplication
import com.rajeshjadav.android.mvputilityapp.R

fun showToast(message: String?) {
    message?.let {
        Toast.makeText(MainApplication.applicationContext(), it, Toast.LENGTH_LONG).show()
    }
}

/**
 * Dialog functions
 */
fun showAlertDialog(
    @NonNull context: Context,
    @Nullable title: String? = null,
    @NonNull message: String,
    @NonNull isCancelable: Boolean = false,
    @NonNull positiveButtonText: String? = context.getString(R.string.button_ok),
    @Nullable negativeButtonText: String? = null,
    @Nullable neutralButtonText: String? = null,
    @Nullable positiveButtonCallBack: DialogInterface.OnClickListener? = null,
    @Nullable negativeButtonCallBack: DialogInterface.OnClickListener? = null,
    @Nullable neutralButtonCallBack: DialogInterface.OnClickListener? = null
) {
    val builder = context.let { AlertDialog.Builder(it) }
    title?.let { builder.setTitle(title) }
    builder.setMessage(message)
    if (positiveButtonCallBack != null)
        builder.setPositiveButton(positiveButtonText, positiveButtonCallBack::onClick)
    else {
        builder.setPositiveButton(positiveButtonText) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
    }
    if (negativeButtonText != null && negativeButtonCallBack != null) {
        builder.setNegativeButton(negativeButtonText, negativeButtonCallBack::onClick)
    }
    if (neutralButtonText != null && neutralButtonCallBack != null) {
        builder.setNeutralButton(neutralButtonText, neutralButtonCallBack::onClick)
    }
    builder.setCancelable(isCancelable)
    builder.show()
}

fun showSingleSelectionDialog(
    @NonNull context: Context,
    @NonNull list: Array<String>,
    @NonNull onClickListener: DialogInterface.OnClickListener,
    @NonNull defaultItem: Int = -1,
    @NonNull themeResId: Int = 0,
    @Nullable title: String? = null,
    @NonNull isCancelable: Boolean = true,
    @NonNull isDisplayRadioButton: Boolean = true
) {
    val builder = context.let { AlertDialog.Builder(it, themeResId) }
    title?.let { builder.setTitle(title) }
    builder.setCancelable(isCancelable)
    when {
        isDisplayRadioButton -> builder.setSingleChoiceItems(
            list,
            defaultItem,
            onClickListener::onClick
        )
        else -> builder.setItems(list, onClickListener::onClick)
    }
    builder.show()
}

fun formatHtmlText(htmlContent: String): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(htmlContent)
    }
}

fun parseColor(colorHex: String?, defaultColor: Int): Int {
    return try {
        val newColorHex: String? = if (colorHex?.contains("#") == true) {
            colorHex
        } else {
            "#$colorHex"
        }
        Color.parseColor(newColorHex)
    } catch (exception: IllegalArgumentException) {
        defaultColor
    }
}
