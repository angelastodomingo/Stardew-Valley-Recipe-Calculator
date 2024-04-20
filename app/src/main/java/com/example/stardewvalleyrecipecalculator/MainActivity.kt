package com.example.stardewvalleyrecipecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.stardewvalleyrecipecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var mayonnaiseSelected = false
    private var eggSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //needed to do this otherwise the icons wont appear
        var imageView = findViewById<ImageView>(R.id.alert)
        imageView.setImageResource(R.drawable.exclamationmark)

        imageView = findViewById<ImageView>(R.id.egg)
        imageView.setImageResource(R.drawable.egg)

        imageView = findViewById<ImageView>(R.id.duckegg)
        imageView.setImageResource(R.drawable.duck_egg)

        imageView = findViewById<ImageView>(R.id.voidegg)
        imageView.setImageResource(R.drawable.void_egg)

        imageView = findViewById<ImageView>(R.id.dinoegg)
        imageView.setImageResource(R.drawable.dino_egg)

        imageView = findViewById<ImageView>(R.id.mayomachine)
        imageView.setImageResource(R.drawable.mayonnaise_machine)

        imageView = findViewById<ImageView>(R.id.resetbtn)
        imageView.setImageResource(R.drawable.reset)

        imageView = findViewById<ImageView>(R.id.calculatebtn)
        imageView.setImageResource(R.drawable.calculate)

        imageView = findViewById<ImageView>(R.id.mayonnise)
        imageView.setImageResource(R.drawable.mayonnise)

        imageView = findViewById<ImageView>(R.id.slot2egg)
        imageView.setImageResource(R.drawable.egg)

        imageView = findViewById<ImageView>(R.id.slot1machine)
        imageView.setImageResource(R.drawable.mayonnaise_machine)

        imageView = findViewById<ImageView>(R.id.slot2duckegg)
        imageView.setImageResource(R.drawable.duck_egg)

        imageView = findViewById<ImageView>(R.id.duckmayo)
        imageView.setImageResource(R.drawable.duck_mayo)

        imageView = findViewById<ImageView>(R.id.slot2voidegg)
        imageView.setImageResource(R.drawable.void_egg)

        imageView = findViewById<ImageView>(R.id.voidmayo)
        imageView.setImageResource(R.drawable.void_mayo)

        imageView = findViewById<ImageView>(R.id.slot2dinoegg)
        imageView.setImageResource(R.drawable.dino_egg)

        imageView = findViewById<ImageView>(R.id.dinomayo)
        imageView.setImageResource(R.drawable.dino_mayo)




        //results r set to invisible until certain ingredients are pressed
        binding.mayonnise.visibility = View.INVISIBLE
        binding.duckmayo.visibility = View.INVISIBLE
        binding.voidmayo.visibility = View.INVISIBLE
        binding.dinomayo.visibility = View.INVISIBLE

        //onclicklisterner for mayonnaise machine
        binding.mayomachine.setOnClickListener {

            mayonnaiseSelected = true

            binding.slot1machine.visibility = View.VISIBLE
        }

        //egg onclicklistener
        binding.egg.setOnClickListener {

            eggSelected = true
            //shows egg when pressed
            binding.slot2egg.visibility = View.VISIBLE
        }

        //duckegg onclicklistener
        binding.duckegg.setOnClickListener {

            eggSelected = true
            //shows duckegg in slot when pressed
            binding.slot2duckegg.visibility = View.VISIBLE
        }

        //voidegg onclicklistener

        binding.voidegg.setOnClickListener {

            eggSelected = true
            //shows voidegg in slot when pressed
            binding.slot2voidegg.visibility = View.VISIBLE
        }

        //dinoegg onclicklistener

        binding.dinoegg.setOnClickListener {

            eggSelected = true
            //shows dinoegg in slot when pressed
            binding.slot2dinoegg.visibility = View.VISIBLE
        }





// onclicklistener for calculate btn
        binding.calculatebtn.setOnClickListener {
            //checks if both mayonnaise machine and egg are selected
            if (mayonnaiseSelected && eggSelected) {
                //checks which ingredients r selected
                if (binding.slot1machine.visibility == View.VISIBLE && binding.slot2egg.visibility == View.VISIBLE) {
                    //displays mayonnaise
                    binding.mayonnise.visibility = View.VISIBLE
                } else if (binding.slot1machine.visibility == View.VISIBLE && binding.slot2duckegg.visibility == View.VISIBLE) {
                    //displays duck mayo
                    binding.duckmayo.visibility = View.VISIBLE
                } else if (binding.slot1machine.visibility == View.VISIBLE && binding.slot2voidegg.visibility == View.VISIBLE) {
                    //displays void mayo
                    binding.voidmayo.visibility = View.VISIBLE

                } else if (binding.slot1machine.visibility == View.VISIBLE && binding.slot2dinoegg.visibility == View.VISIBLE) {
                    //displays dino mayo
                    binding.dinomayo.visibility = View.VISIBLE
                }
            }
        }

        //reset btn onclicklistener
        binding.resetbtn.setOnClickListener {

            resetSelection()
            //clears out the selections
            binding.slot2egg.visibility = View.INVISIBLE
            binding.slot1machine.visibility = View.INVISIBLE
            binding.slot2duckegg.visibility = View.INVISIBLE
            binding.slot2voidegg.visibility = View.INVISIBLE
            binding.slot2dinoegg.visibility = View.INVISIBLE
        }

        // onclicklistener alert
        binding.alert.setOnClickListener {
            showAlert()
        }
    }

    private fun resetSelection() {
        //when reset btn is pressed, it clears out the selection
        mayonnaiseSelected = false
        eggSelected = false
        binding.mayonnise.visibility = View.INVISIBLE
        binding.duckmayo.visibility = View.INVISIBLE
        binding.voidmayo.visibility = View.INVISIBLE
        binding.dinomayo.visibility = View.INVISIBLE
    }


private fun showAlert() {
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Welcome to Stardew Valley Recipe Calculator!")
        .setMessage("To use the app, simply select one machine and one ingredient from the inventory to make a product! Once you combine these two, not only can you see the finished product, but you can also get a glimpse of the base profit you can earn from shipping it to the shipping bin! Please note that you cannot combine Machine + Machine nor ingredient + ingredient, as this will result in nothing. Enjoy!")
        .setNegativeButton("Close") { dialog, which ->
            dialog.dismiss()
        }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.show()
}
}
