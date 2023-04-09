package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

    private lateinit var countryList: ListView
    private var countries = ArrayList<Country>()
    private val countriesName = arrayListOf("Россия", "США", "Казахстан", "Китай", "Япония")
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countryList = findViewById(R.id.countryList)
        setTextViewClickListener(countryList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,  countriesName)
        countryList.adapter = adapter
    }

    private fun addCountry(countryName: String): Country {

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val url = "https://restcountries.com/v3.1/translation/$countryName"
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        val body = response.body()!!.string()
        val country = JSONArray(body)
        val name = country.getJSONObject(0)
            .getJSONObject("translations")
            .getJSONObject("rus")
        val commonName = name.get("common")
        val officialName = name.get("official")
        val flag = country.getJSONObject(0).getJSONObject("flags").get("png")
        val capital = country.getJSONObject(0).getJSONArray("capital").get(0)
        return Country(commonName.toString(), flag.toString(), officialName.toString(),  capital.toString())
    }

    private fun setTextViewClickListener(listView: ListView) {
        listView.setOnItemClickListener { _, _, position, _ ->
            val country = addCountry(countriesName[position])
            val intent = Intent(this, CountryActivity::class.java)
            intent.putExtra("country", country)
            startActivity(intent)
        }
    }
}