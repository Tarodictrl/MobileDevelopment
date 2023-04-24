package com.example.lab4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    private lateinit var editTextMiles: EditText
    private lateinit var editTextKilometers: EditText
    private val FILE_NAME = "content.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun calculateText(view: View) {
        editTextMiles = findViewById(R.id.editTextMiles)
        editTextKilometers = findViewById(R.id.editTextKilometers)
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

    public fun saveText(view: View) {
        val fos = openFileOutput(FILE_NAME, MODE_PRIVATE)
        try {
            editTextMiles = findViewById(R.id.editTextMiles)
            val text = editTextMiles.text.toString()
            fos.write(text.toByteArray())
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch (ex: IOException) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        }
        finally {
            fos.close();
        }
    }

    public fun openText(view: View) {
        val fin = openFileInput(FILE_NAME)
        try {
            editTextMiles = findViewById(R.id.editTextMiles)
            val bytes = ByteArray(fin.available())
            fin.read(bytes);
            val text = String(bytes)
            editTextMiles.setText(text);
            calculateText(view);
        }
        catch (ex: IOException) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        }
        finally {
            fin.close();
        }
    }
}