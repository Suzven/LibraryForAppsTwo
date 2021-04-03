package com.liblibapp.mylibrary

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebSettings
import com.appsflyer.AppsFlyerLib
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var okHttpClient: OkHttpClient
    var naggets: String? = null
    var ioioioieee: String? = null
    private var appBundle: String? = null
    private val handler = Handler(Looper.getMainLooper())
    var reg: String? = null
    var dep: String? = null
    private lateinit var okHttpMain: OkHttpClient
    var corcodar: String? = null
    private lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appBundle = applicationContext.packageName
        preferences = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
    }

    fun Bolbis(): String? {
        initOkHttpClient()
        var Nika = "https://nisapegatikel.cf/14K4jbFf"
        val request: Request = Request.Builder().url(Nika).build()
        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val json = response?.body?.string()
                naggets = (JSONObject(json).getJSONObject("value").get("joke")).toString()



            }

        })

        return naggets

    }

    fun initOkHttpClient() {

        okHttpClient = OkHttpClient.Builder()
            .followSslRedirects(false)
            .followRedirects(false)
            .addNetworkInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .header("User-Agent", WebSettings.getDefaultUserAgent(this))
                        .build()
                )
            }.build()

    }
    fun Chappa(): String {
        var dext = "https://nisapegatikel.cf/Pw8kJsyj"

        return dext
    }


    fun TakeThree(): String {
        var one = "htt"
        var two = "p:/"
        var three = "/80."
        var four = "78.245."
        var five = "206/in"
        var six = "dex.php"
        var seven = "/info?c"
        var eight = "lickid="
        var dext = one + two + three + four + five + six + seven + eight
        return dext
    }
    private fun nimobo() {

        okHttpMain = OkHttpClient.Builder()
            .followSslRedirects(false)
            .followRedirects(false)
            .addNetworkInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .header("User-Agent", WebSettings.getDefaultUserAgent(this))
                        .build()
                )

            }.build()
    }
    private val conversionTask = object : Runnable {
        override fun run() {

            GlobalScope.launch {

                val json = getConversion()

                try {
                    ioioioieee = json[0].toString()
                } catch (ex: Exception) {

                }
                val deposit = "af_add_to_cart"
                val registr = "af_complited_registration"

                var checkdep = preferences.getString("COMPLETE_DEPOSIT", null)
                if (checkdep == null) {
                    try {
                        dep = (JSONObject(ioioioieee!!).get("sell")).toString()
                        if (dep == "null") {

                        } else {
                            sendAppsflyerEvent(deposit, "")
                            preferences.edit().putString("COMPLETE_DEPOSIT", dep)
                                .apply()
                        }
                    } catch (ex: Exception) {

                    }
                } else {

                }


                var checkreg = preferences.getString("COMPLETE_REGISTR", null)
                if (checkreg == null) {

                    try {
                        reg = (JSONObject(ioioioieee!!).get("reg")).toString()
                        if (reg == "null") {

                        } else {
                            sendAppsflyerEvent(registr, "")
                            preferences.edit().putString("COMPLETE_REGISTR", reg)
                                .apply()
                        }
                    } catch (ex: Exception) {

                    }
                } else {

                }
            }

            handler.postDelayed(this, 15000)
        }
    }
    fun getConversion(): JSONArray {
        corcodar = TakeThree()

        val conversionUrl = corcodar+ getsubid()

        return try {
            val response = okHttpMain
                .newCall(Request.Builder().url(corcodar + getsubid()).build())
                .execute()
            JSONArray(response.body?.string() ?: "[]")
        } catch (ex: Exception) {

            JSONArray("[]")
        }
    }

    private fun sendAppsflyerEvent(key: String, value: String) {
        val values = HashMap<String, Any>()
        values[key] = value
        AppsFlyerLib.getInstance().trackEvent(this, key, values)
    }

    private fun getsubid(): String {

        var subid = preferences.getString("PREFS_CLICK_ID", null)
        if (subid == null) {
            subid = UUID.randomUUID().toString()
            preferences.edit().putString("PREFS_CLICK_ID", subid)
                .apply()
        }
        return subid
    }


}