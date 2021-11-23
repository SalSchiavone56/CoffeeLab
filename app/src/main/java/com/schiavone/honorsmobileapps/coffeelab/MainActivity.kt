package com.schiavone.honorsmobileapps.coffeelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

lateinit var quantityNumber:TextView
class MainActivity : AppCompatActivity() {
    var number = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        quantityNumber = findViewById(R.id.quantity_number)
        val minusButton: Button = findViewById(R.id.minus_button)
        minusButton.setOnClickListener { view ->
            updateQuantity(-1)
        }
        val plusButton: Button = findViewById(R.id.plus_button)
        plusButton.setOnClickListener { view ->
            updateQuantity(1)
        }
        val orderButton: Button = findViewById(R.id.order_button)
        orderButton.setOnClickListener { view ->
            submitOrder()
        }
    }

    fun updateQuantity(update: Int) {
        if (number + update < 1) {
            Toast.makeText(this, R.string.toast_message1, Toast.LENGTH_LONG).show()
        } else if (number + update > 10) {
            Toast.makeText(this, R.string.toast_message2, Toast.LENGTH_LONG).show()
        } else {
            number += update
        }
        quantityNumber.text = number.toString()
    }

    fun submitOrder() {
        val name: EditText = findViewById(R.id.name_top)
        val whippedCream: CheckBox = findViewById(R.id.whipped_cream_box)
        val chocolate: CheckBox = findViewById(R.id.chocolate_box)
        val summaryText: TextView=findViewById(R.id.sum)
        var summary = "Thanks, ${name.text}!\n$number Coffees"
        var total = 0.00
        if(whippedCream.isChecked){
            total++
            summary += "\n+ Whipped Cream"
        }

        if(chocolate.isChecked){
            total+=2.0
            summary += "\n+ Chocolate"
        }

        total=(5+total)*number
        summary += "\nTotal: $${total}0"
        summaryText.text=summary
    }
}