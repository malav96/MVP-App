/*
package com.rajeshjadav.android.mvputilityapp.common

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Environment
import android.provider.MediaStore
import android.system.Os.close
import android.text.Editable
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.FileProvider
import androidx.core.os.EnvironmentCompat
import com.rajeshjadav.android.mvputilityapp.R
import com.rajeshjadav.android.mvputilityapp.util.showAlertDialog
import com.rajeshjadav.android.mvputilityapp.util.showToast
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnNeverAskAgain
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

*/
/*
Setup DelayAutoCompleteTextView with adapter
fun setupAutoCompleteView() {
    context?.let {
        val autoCompleteAdapter = AgentFinderAutoCompleteAdapter(
            it,
            R.layout.simple_auto_complete_list_item,
            presenter
        )
        searchAutoCompleteTextView.threshold = 1
        searchAutoCompleteTextView.setAdapter(autoCompleteAdapter)
    }
}*//*



*/
/*
// TABLAYOUT INTEGRATION
<style name="TabLayoutStyle" parent="Widget.Design.TabLayout">
<item name="tabBackground">?attr/themeColorAccent</item>
<item name="tabGravity">fill</item>
<item name="tabMode">fixed</item>
<item name="tabIndicatorColor">@color/white</item>
<item name="tabMaxWidth">0dp</item>
<item name="tabIndicatorHeight">3dp</item>
<item name="tabTextColor">@color/darkThemeSecondaryTextColor</item>
<item name="tabSelectedTextColor">@color/white</item>
</style>

<android.support.design.widget.TabLayout
android:id="@+id/tabLayout"
style="@style/TabLayoutStyle"
android:layout_width="match_parent"
android:layout_height="wrap_content"
app:tabBackground="@color/white"
app:tabIndicatorColor="@color/colorAccent"
app:tabSelectedTextColor="@color/colorAccent"
app:tabTextColor="@color/gray" />

override fun setupTabLayout() {
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_suburb)))
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_agent)))
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_agency)))
    tabLayout.getTabAt(selectedTabPosition)?.select()
    tabLayout.addOnTabSelectedListener(this)
    if (isLargeSizeTablet()) {
        backgroundImageView.scaleType = ImageView.ScaleType.FIT_END
    }
}*//*



//SPINNER
<array name="agent_finder_agent_types">
<item>Sales agents</item>
<item>Property managers</item>
<item>Commercial</item>
<item>Business</item>
<item>All</item>
</array>

override fun showAgentCategorySpinner() {
    val agentCategorySpinnerAdapter = ArrayAdapter(
        context,
        R.layout.spinner,
        resources.getStringArray(R.array.agent_finder_agent_types)
    )
    agentCategorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    agentCategorySpinner.adapter = agentCategorySpinnerAdapter
}


//TOOLBAR
<android.support.design.widget.AppBarLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
android:id="@+id/appbarLayout"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:theme="@style/ThemeOverlay.AppCompat.Dark">

<android.support.v7.widget.Toolbar
android:id="@+id/toolbar"
android:layout_width="match_parent"
android:layout_height="?attr/actionBarSize"
android:background="?attr/themeColorPrimary"
app:layout_scrollFlags="scroll|enterAlways|snap"
app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
app:subtitleTextAppearance="@style/ToolbarSubTitleTextStyle"
app:titleTextAppearance="@style/ToolbarTitleTextStyle" />

</android.support.design.widget.AppBarLayout>

<android.support.design.widget.AppBarLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
android:id="@+id/appbarLayout"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:theme="@style/ThemeOverlay.AppCompat.Dark">

<android.support.v7.widget.Toolbar
android:id="@+id/toolbar"
android:layout_width="match_parent"
android:layout_height="?attr/actionBarSize"
android:background="?attr/themeColorPrimary"
app:layout_scrollFlags="scroll|enterAlways|snap"
app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />

<android.support.design.widget.TabLayout
android:id="@+id/tabLayout"
style="@style/TabLayoutStyle"
android:layout_width="match_parent"
android:layout_height="wrap_content" />

</android.support.design.widget.AppBarLayout>



STYLES
<style name="ToolbarTitleTextStyle" parent="TextAppearance.Widget.AppCompat.Toolbar.Title">
<item name="android:textSize">16sp</item>
<item name="android:textColor">@color/white</item>
</style>

<style name="ToolbarSubTitleTextStyle" parent="TextAppearance.Widget.AppCompat.Toolbar.Subtitle">
<item name="android:textSize">13sp</item>
<item name="android:textColor">@color/white</item>
</style>

<style name="SpinnerStyle" parent="Widget.AppCompat.Spinner">
<item name="android:layout_marginTop">12dp</item>
<item name="android:layout_marginBottom">12dp</item>
</style>

<style name="UnderlinedSpinnerStyle" parent="Widget.AppCompat.Spinner.Underlined">
<item name="android:height">48dp</item>
</style>



<style name="AccentCurveButtonStyle" parent="Widget.AppCompat.Button.Colored">
<item name="android:height">36dp</item>
<item name="android:minHeight">0dp</item>
<item name="android:background">@drawable/bg_curved_accent_button</item>
</style>

<style name="AccentFullButtonStyle" parent="Widget.AppCompat.Button.Colored">
<item name="android:height">40dp</item>
<item name="android:minHeight">0dp</item>
<item name="android:background">?attr/themeColorAccent</item>
</style>

<style name="AccentBorderlessButtonStyle" parent="Widget.AppCompat.Button.Borderless.Colored">
<item name="android:background">@color/transparent</item>
</style>

bg_curved_accent_button
<?xml version="1.0" encoding="utf-8"?>

<shape xmlns:android="http://schemas.android.com/apk/res/android"
android:shape="rectangle">

<corners android:radius="24dp" />

<solid android:color="?attr/themeColorAccent" />

<padding
android:left="16dp"
android:right="16dp" />
</shape>

<style name="ResidentialAppTheme.Alert" parent="Theme.AppCompat.Light.Dialog.Alert">
<item name="colorAccent">?themeColorAccent</item>
<item name="themeColorAccent">@color/colorAccent</item>
</style>

<style name="ResidentialAppTheme.SplashTheme">
<item name="android:windowBackground">@drawable/bg_splash</item>
</style>

<style name="ResidentialAppTheme" parent="Theme.AppCompat.Light.NoActionBar">
<item name="colorPrimary">@color/colorPrimary</item>
<item name="colorPrimaryDark">@color/colorPrimaryDark</item>
<item name="colorAccent">@color/colorAccent</item>
<item name="themeColorPrimary">@color/colorPrimary</item>
<item name="themeColorPrimaryDark">@color/colorPrimaryDark</item>
<item name="themeColorAccent">@color/colorAccent</item>
<item name="themeMapDrawFill">@color/mapDrawFill</item>
<item name="themeNoRecordBottom">@color/noRecordBottom</item>
<item name="android:importantForAutofill" tools:targetApi="o">noExcludeDescendants</item>
</style>





        TEXTWATCHER
usernameEditText.addTextChangedListener(this)
passwordEditText.addTextChangedListener(this)
override fun afterTextChanged(editable: Editable?) {
    when {
        editable === usernameEditText.editableText -> {
            presenter.onUsernameTextChanged(usernameEditText.enteredText)
        }
        editable === passwordEditText.editableText -> {
            presenter.onPasswordTextChanged(passwordEditText.enteredText)
        }
    }
}

override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
}

override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
}


COMMON ONCLICK
override fun onClick(view: View) {
    when (view.id) {
        R.id.loginButton -> {
            presenter.validateInputFields(
                usernameEditText.enteredText,
                passwordEditText.enteredText
            )
        }
        R.id.forgotPasswordButton -> {
            presenter.onForgotPasswordButtonClick()
        }
        R.id.registerButton -> when {
            isFromHomeScreen -> {
                presenter.onRegisterButtonClick()
            }
            isFromActivateRegistration -> {
                presenter.onRegisterButtonClick()
            }
            else -> {
                close()
            }
        }
    }
}

TEXTINPUT LAYOUT
override fun showUsernameError() {
    usernameTextInputLayout.error = getString(R.string.error_enter_user_name)
    usernameEditText.requestFocus()
}




CAMERA HANDLING
override fun showCamera() {
    openCameraAppWithPermissionCheck()
}

@NeedsPermission(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
fun openCameraApp() {
    val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    if (takePictureIntent.resolveActivity(activity?.packageManager) != null) {
        try {
            var photoFile: File?
            context?.let { context ->
                photoFile = PropertyDetailsUtils.createImageFile(context)
                photoFile?.let {
                    capturedCurrentPhotoPath = it.absolutePath
                    val photoURI = FileProvider.getUriForFile(
                        context,
                        getString(R.string.app_authorities),
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                }
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        startActivityForResult(
            takePictureIntent,
            REQUEST_CODE_IMAGE_CAPTURE
        )
    } else {
        showToast(getString(R.string.error_camera_app_not_found))
    }
}


<string name="app_authorities">au.com.reiwa.fileprovider</string>
fun createImageFile(context: Context): File? {
    val imageFileName =
        "JPEG_" + SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(Date()) + "_"
    var storageDir =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
    if (storageDir == null || !storageDir.isDirectory) {
        storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    }
    val image = File.createTempFile(imageFileName, ".jpg", storageDir)
    return if (Environment.MEDIA_MOUNTED != EnvironmentCompat.getStorageState(image)) {
        null
    } else image
}

@OnNeverAskAgain(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
fun onCameraPermissionDenied() {
    activity?.let {
        showAlertDialog(
            context = it,
            title = getString(R.string.dialog_title_permission_camera_storage),
            message = getString(R.string.error_message_permission_permanent_denial_camera_storage),
            themeResId = getDialogTheme(propertyCategoryId),
            positiveButtonText = getString(R.string.action_settings),
            negativeButtonText = getString(R.string.button_not_now),
            positiveButtonCallBack = DialogInterface.OnClickListener { _, _ ->
                activity?.openAppSettings()
            },
            negativeButtonCallBack = DialogInterface.OnClickListener { _, _ ->
            }
        )
    }
}*/
