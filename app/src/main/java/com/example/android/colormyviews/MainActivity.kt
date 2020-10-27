package com.example.android.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    // Inisialisasi Button
    lateinit var redButton: Button
    lateinit var yellowButton: Button
    lateinit var greenButton: Button

    // Inisialisasi TextView
    lateinit var boxOneText: TextView
    lateinit var boxTwoText: TextView
    lateinit var boxThreeText: TextView
    lateinit var boxFourText: TextView
    lateinit var boxFiveText: TextView

    // Inisialisasi CheckBox
    lateinit var checkBoxOne: CheckBox
    lateinit var checkBoxTwo: CheckBox
    lateinit var checkBoxThree: CheckBox
    lateinit var checkBoxFour: CheckBox
    lateinit var checkBoxFive: CheckBox

    // Inisialisasi Layout
    lateinit var rootConstraintLayout: View

    // Inisialisasi Array List
    lateinit var selectedBox : ArrayList<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set Listener
        setListener()
    }

    private fun setListener() {
        // Mencari view berdasarkan ID
        boxOneText = findViewById(R.id.box_one_text)
        boxTwoText = findViewById(R.id.box_two_text)
        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)

        greenButton = findViewById(R.id.green_button)
        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)

        checkBoxOne = findViewById(R.id.check_box_one)
        checkBoxTwo = findViewById(R.id.check_box_two)
        checkBoxThree = findViewById(R.id.check_box_three)
        checkBoxFour = findViewById(R.id.check_box_four)
        checkBoxFive = findViewById(R.id.check_box_five)

        rootConstraintLayout = findViewById(R.id.constraint_layout)

        // Menampung view
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

        // Membuat Array List
        selectedBox = ArrayList()
    }

    private fun makeDrawabled(view: View){
        when (view.id) {
            // Boxes using Color Class colors for the background
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.gambar_satu)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.gambar_dua)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.gambar_tiga)
            R.id.box_four_text -> view.setBackgroundResource(R.drawable.gambar_empat)
            R.id.box_five_text -> view.setBackgroundResource(R.drawable.gambar_lima)

            R.id.yellow_button -> makeColoredByCheckBox(Color.YELLOW)
            R.id.red_button -> makeColoredByCheckBox(Color.RED)
            R.id.green_button -> makeColoredByCheckBox(Color.GREEN)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
    /*
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

     */

    fun onCheckBoxClicked(view: View) {
        // Action ketika checkbox di klik
        if(view is CheckBox){
            when(view){
                checkBoxOne -> checkAndAddToArrayList(checkBoxOne, boxOneText)
                checkBoxTwo -> checkAndAddToArrayList(checkBoxTwo, boxTwoText)
                checkBoxThree -> checkAndAddToArrayList(checkBoxThree, boxThreeText)
                checkBoxFour -> checkAndAddToArrayList(checkBoxFour, boxFourText)
                checkBoxFive -> checkAndAddToArrayList(checkBoxFive, boxFiveText)
            }
        }
    }

    fun checkAndAddToArrayList(checkBox : CheckBox, view: View){
        // Mengecek apakah checked atau tidak
        // Jika checked akan ditambahkan ke arrayList selectedBox
        // Jika tidak, maka tidak akan ditambahkan / dihapus dari arrayList
        val isChecked: Boolean = checkBox.isChecked
        if (isChecked){
            selectedBox.add(view)
        } else {
            selectedBox.remove(view)
        }
    }

    fun makeColoredByCheckBox(color: Int){
        // Mengganti background view yang ada di arrayList selectedBox berdasarkan warna yang dikirim pada parameter
        for (item in selectedBox){
            item.setBackgroundColor(color)
        }
    }
}