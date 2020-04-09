package com.example.shoeshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoeshop.databinding.ActivityShoeDetailsBinding
import kotlinx.android.synthetic.main.activity_shoe_details.*

class ShoeDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityShoeDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shoe_details)

        shoe_name.text = getIntent().getStringExtra("SHOENAME")
        shoe_description.text = getIntent().getStringExtra("SHOEDESC")
        image_shoe.setImageResource(getIntent().getStringExtra("SHOELOGO").toInt())
    }
}
