package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import java.io.Console
import android.util.Log
import android.widget.Switch
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.core.text.set
import androidx.core.widget.doAfterTextChanged
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMiles: EditText;
    private lateinit var editTextKilometers: EditText;
    private lateinit var calculateButton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextMiles = findViewById(R.id.editTextMiles)
        editTextKilometers = findViewById(R.id.editTextKilometers)
        calculateButton = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener {
            if (editTextMiles.text.isBlank()){
                val builder = AlertDialog.Builder(this)
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                builder.setTitle("Пустые значения!")
                builder.setMessage("Поле мили не должно быть пустым!")
                builder.setPositiveButton("Понял") {
                        dialog, _ -> dialog.cancel()
                }
                builder.show()
            }
            else
            {
                val miles = editTextMiles.text.toString().toFloat()
                val result = miles / 0.62137
                val output = (result * 1000.0).roundToInt() / 1000.0
                editTextKilometers.setText(output.toString())
            }
        }
    }
}