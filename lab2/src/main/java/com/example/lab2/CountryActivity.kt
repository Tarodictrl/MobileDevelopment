package com.example.lab2

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.net.URL


class CountryActivity : AppCompatActivity() {

    private lateinit var countryCapitalTextView: TextView
    private lateinit var countryOfficialTextView: TextView
    private lateinit var flagImage: ImageView
    private lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val arguments = intent.extras
        var name = "Название"
        var capital = "Сталица"
        var officialName = "Официальное название"
        var flag = "Флаг"

        if (arguments != null) {
            country = arguments.getSerializable("country") as Country
            name = country.name.toString()
            capital = country.capital.toString()
            officialName = country.officialName.toString()
            flag = country.flag.toString()
        }
        setContentView(R.layout.activity_country)
        countryCapitalTextView = findViewById(R.id.countryCapitalTextView)
        countryOfficialTextView = findViewById(R.id.countryOfficialTextView)
        flagImage = findViewById(R.id.FlagImageView)
        countryCapitalTextView.text = capital
        countryOfficialTextView.text = officialName
        val flagUrl = URL(flag)
        val icon = BitmapFactory.decodeStream(flagUrl.openConnection().getInputStream())
        flagImage.setImageBitmap(icon)
        this.title = name
    }
}
