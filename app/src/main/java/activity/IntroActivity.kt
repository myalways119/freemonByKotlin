package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.example.freemonbykotlin.R
import common.SharedPreferencesManager
import android.content.SharedPreferences
import android.widget.Toast


class IntroActivity : AppCompatActivity() {
    val SPLASH_VIEW_TIME: Long = 150000
    var storedPhoneNum:String? = null
    var storedAndroidId:String? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //Check Authority

        //Get User Inforrmation from


        //Get User information from DB
        GetStoredData();

        //Delay
        Handler().postDelayed({
            //startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }

    fun GetStoredData()
    {
        SharedPreferencesManager.SetStringValue(applicationContext, SharedPreferencesManager.KEY_PHONE_NUM, "01022223333" )
        var phoneNum = SharedPreferencesManager.GetStringValue(applicationContext, SharedPreferencesManager.KEY_PHONE_NUM, "")
        Toast.makeText(this, phoneNum, Toast.LENGTH_LONG).show()
    }
}