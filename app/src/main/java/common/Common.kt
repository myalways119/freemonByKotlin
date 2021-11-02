package common

import android.Manifest
import android.content.Context
import android.content.Context.TELEPHONY_SERVICE
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.PhoneNumberUtils
import android.telephony.TelephonyManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import java.util.*

class Common
{
    fun GetPhoneNumber(): String {
        val telephony = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        var phoneNumber = ""
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
            {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                return ""
            }
            if (telephony.line1Number != null)
            {
                phoneNumber = telephony.line1Number
            }

            if (phoneNumber.startsWith("+82")) {
                phoneNumber = phoneNumber.replace("+82", "0")
            }
            phoneNumber = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                PhoneNumberUtils.formatNumber
                (
                    phoneNumber,
                    Locale.getDefault().country
                )
            } else {
                PhoneNumberUtils.formatNumber(phoneNumber)
            }
        } catch (e: Exception)
        {
            e.printStackTrace()
        }

        return phoneNumber
    }
}