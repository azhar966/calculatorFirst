package com.zebdul.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //find all buttons by id
        var add = findViewById<ImageView>(R.id.btnAdd).setOnClickListener {calculateIt(it)}
        var sub = findViewById<ImageView>(R.id.btnSub).setOnClickListener {calculateIt(it)}
        var mul = findViewById<ImageView>(R.id.btnMul).setOnClickListener {calculateIt(it)}
        var div = findViewById<ImageView>(R.id.btnDiv).setOnClickListener {calculateIt(it)}
    }    //make a function   & find the id of input & output fields
    private fun calculateIt(v:View) {
        val n1 = findViewById<EditText>(R.id.number1)
        val n2 = findViewById<EditText>(R.id.number2)
        val res = findViewById<TextView>(R.id.textView)
// define input and output as float
        val number1 : Float
        val number2 : Float
        val result : Float
 // use some if else statement for input is not empty and convert it to Float()
        if(TextUtils.isEmpty(n1.text.toString())){
            n1.error = "Enter number please"
            return}
        else{
            number1 = n1.text.toString().toFloat()}

        if(TextUtils.isEmpty(n2.text.toString())){
            n2.error = "Enter number please"
            return}
        else{
            number2 = n2.text.toString().toFloat()}
// use an when  for all btns function  with v.id (view id)
        when(v.id){
            // use id function to find button and impllement logic of it
            // and get text and change to string
            R.id.btnAdd -> {
                result = number1 + number2
                res.text = result.toString()}
// same as previous comment
            R.id.btnSub -> {
                result = number1 - number2
                res.text = result.toString()}
// same as previous comment
            R.id.btnMul -> {
                result = number1 * number2
                res.text = result.toString()}
// here implement not divisible with zero
            R.id.btnDiv -> { // use if else statement for zero
                if (number2 == 0.0F){
                    n2.error = "cannot div by zero"} // tell if zero for n2
                else if ((number1 == 0.0F)) {
                    n1.error = "cannot div by zero"} // tell if zero for n1
                else {
                    result = number1 / number2
                    res.text = result.toString()}
            }
        }
    }
}
