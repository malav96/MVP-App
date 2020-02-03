/*
package com.rajeshjadav.android.mvputilityapp.unused

import android.content.ActivityNotFoundException
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.provider.CalendarContract
import android.provider.ContactsContract
import android.support.v4.os.EnvironmentCompat
import androidx.core.net.toUri
import androidx.core.os.EnvironmentCompat
import au.com.reiwa.R
import au.com.reiwa.ui.common.model.BranchOffice
import au.com.reiwa.ui.common.model.Realtor
import au.com.reiwa.ui.propertysearch.propertydetails.model.HomeOpen
import au.com.reiwa.ui.propertysearch.propertydetails.model.PropertyDetails
import au.com.reiwa.util.formatHtmlText
import au.com.reiwa.util.showToast
import com.google.android.gms.maps.model.LatLng
import com.rajeshjadav.android.mvputilityapp.R
import com.rajeshjadav.android.mvputilityapp.util.formatHtmlText
import com.rajeshjadav.android.mvputilityapp.util.showToast
import java.io.File
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.collections.ArrayList

object PropertyDetailsUtils {

    fun sharePropertyDetails(context: Context, message: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            type = "text/plain"
            putExtra(
                Intent.EXTRA_TEXT,
                context.getString(R.string.share_property_message, message)
            )
        }
        context.startActivity(
            Intent.createChooser(
                shareIntent,
                context.getString(R.string.action_share_property)
            )
        )
    }

    fun addEventToCalendar(
        context: Context,
        title: String,
        homeOpen: HomeOpen,
        propertyDetails: PropertyDetails?
    ) {
        val addEventIntent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI

            putExtra(
                CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                homeOpen.startDateTime.getCalender().timeInMillis
            )
            putExtra(
                CalendarContract.EXTRA_EVENT_END_TIME,
                homeOpen.endDateTime?.getCalender()?.timeInMillis
            )

            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(
                CalendarContract.Events.DESCRIPTION,
                context.getString(
                    R.string.label_event_description,
                    propertyDetails?.priceText,
                    propertyDetails?.bedrooms,
                    propertyDetails?.bathrooms,
                    propertyDetails?.carspaces,
                    propertyDetails?.listingUrl,
                    propertyDetails?.headline,
                    formatHtmlText(propertyDetails?.description ?: "")
                )
            )
            putExtra(CalendarContract.Events.EVENT_LOCATION, propertyDetails?.addressText)
        }
        try {
            context.startActivity(addEventIntent)
        } catch (e: ActivityNotFoundException) {
            showToast(context.getString(R.string.error_calendar_app_not_found))
            e.printStackTrace()
        }
    }

    private fun String.getCalender(onlyDateComponent: Boolean = false): Calendar {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
        try {
            calendar.time = dateFormat.parse(this)
            if (onlyDateComponent) {
                calendar.set(Calendar.HOUR, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return calendar
    }

    fun showDirections(context: Context, latLng: LatLng) {
        val mapIntent = Intent(
            Intent.ACTION_VIEW,
            context.getString(
                R.string.uri_directions_format,
                latLng.latitude,
                latLng.longitude
            ).toUri()
        )
        mapIntent.`package` = context.getString(R.string.map_app_package_name)
        if (mapIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(mapIntent)
        } else {
            showToast(context.getString(R.string.error_map_app_not_found))
        }
    }

    fun showLocationInMapFromAddress(context: Context, address: String) {
        val mapIntent = Intent(
            Intent.ACTION_VIEW,
            context.getString(
                R.string.uri_address_search_format,
                address
            ).toUri()
        )
        mapIntent.`package` = context.getString(R.string.map_app_package_name)
        if (mapIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(mapIntent)
        } else {
            showToast(context.getString(R.string.error_map_app_not_found))
        }
    }

    fun showLocationInMapFromCoordinates(context: Context, latLng: LatLng, displayLabel: String) {
        val mapIntent = Intent(
            Intent.ACTION_VIEW,
            context.getString(
                R.string.uri_location_search_format,
                latLng.latitude,
                latLng.longitude,
                displayLabel
            ).toUri()
        )
        mapIntent.`package` = context.getString(R.string.map_app_package_name)
        if (mapIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(mapIntent)
        } else {
            showToast(context.getString(R.string.error_map_app_not_found))
        }
    }

    fun showStreetView(context: Context, latLng: LatLng) {
        val mapIntent = Intent(
            Intent.ACTION_VIEW,
            context.getString(
                R.string.uri_streetview_format,
                latLng.latitude,
                latLng.longitude
            ).toUri()
        )
        mapIntent.`package` = context.getString(R.string.map_app_package_name)
        if (mapIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(mapIntent)
        } else {
            showToast(context.getString(R.string.error_street_view_app_not_found))
        }
    }

    fun addContact(
        context: Context,
        realtor: Realtor,
        branchOffice: BranchOffice?,
        showAgency: Boolean?
    ) {
        val addContactIntent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, realtor.name)
            putExtra(ContactsContract.Intents.Insert.PHONE, realtor.primaryPhone)
            putExtra(
                ContactsContract.Intents.Insert.PHONE_TYPE,
                ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
            )
            putExtra(ContactsContract.Intents.Insert.PHONE_ISPRIMARY, true)
            putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE, realtor.secondaryPhone)
            putExtra(
                ContactsContract.Intents.Insert.SECONDARY_PHONE,
                ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
            )
            putExtra(ContactsContract.Intents.Insert.EMAIL, realtor.emailAddress)
            putExtra(
                ContactsContract.Intents.Insert.EMAIL_TYPE,
                ContactsContract.CommonDataKinds.Email.TYPE_WORK
            )
            putExtra(ContactsContract.Intents.Insert.EMAIL_ISPRIMARY, true)
            putExtra(ContactsContract.Intents.Insert.JOB_TITLE, realtor.title)
            if (showAgency == true) {
                putExtra(ContactsContract.Intents.Insert.COMPANY, branchOffice?.name)
                putExtra(ContactsContract.Intents.Insert.POSTAL, branchOffice?.address)
            }
            putExtra(
                ContactsContract.Intents.Insert.POSTAL_TYPE,
                ContactsContract.CommonDataKinds.StructuredPostal.TYPE_WORK
            )
            val dataList = ArrayList<ContentValues>()
            val contentValues = ContentValues()
            contentValues.put(
                ContactsContract.Data.MIMETYPE,
                ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE
            )
            contentValues.put(ContactsContract.CommonDataKinds.Website.URL, "")
            contentValues.put(
                ContactsContract.CommonDataKinds.Website.TYPE,
                ContactsContract.CommonDataKinds.Website.TYPE_WORK
            )
            dataList.add(contentValues)
        }
        if (addContactIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(addContactIntent)
        } else {
            showToast(context.getString(R.string.error_contacts_app_not_found))
        }
    }

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
}
*/
