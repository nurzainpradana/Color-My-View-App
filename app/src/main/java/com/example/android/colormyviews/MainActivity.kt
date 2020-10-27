package com.example.android.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var redButton: Button
    lateinit var yellowButton: Button
    lateinit var greenButton: Button

    lateinit var boxOneText: TextView
    lateinit var boxTwoText: TextView
    lateinit var boxThreeText: TextView
    lateinit var boxFourText: TextView
    lateinit var boxFiveText: TextView

    lateinit var rootConstraintLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
    }

    private fun setListener() {
        boxOneText = findViewById(R.id.box_one_text)
        boxTwoText = findViewById(R.id.box_two_text)
        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)

        greenButton = findViewById(R.id.green_button)
        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)

        rootConstraintLayout = findViewById(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(boxOneText,
                boxTwoText,
                boxThreeText,
                boxFourText,
                boxFiveText,
                rootConstraintLayout,
                yellowButton,
                redButton,
                greenButton)

        for (item in clickableViews){
            item.setOnClickListener { makeDrawabled(it) }
        }
    }

    private fun makeDrawabled(view: View){
        when (view.id) {
            // Boxes using Color Class colors for the background
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.gambar_satu)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.gambar_dua)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.gambar_tiga)
            R.id.box_four_text -> view.setBackgroundResource(R.drawable.gambar_empat)
            R.id.box_five_text -> view.setBackgroundResource(R.drawable.gambar_lima)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun makeColored(view: View){
        when (view.id) {
            // Boxes using Color Class colors for the background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }

    }
}