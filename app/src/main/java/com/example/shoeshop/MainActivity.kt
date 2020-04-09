package com.example.shoeshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var binding:ActivityMainBinding
    lateinit var shoelist: ArrayList<Shoes>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        shoelist = ArrayList()
        addShoes()

        ShoeRecycler.layoutManager = LinearLayoutManager(this)
        ShoeRecycler.addItemDecoration(DividerItemDecoration(this,1))
        ShoeRecycler. adapter = ShoeAdapter(shoelist)

    }

    fun addShoes(){
        shoelist.add(Shoes("Airforce","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airforce) )
        shoelist.add(Shoes("Airmaxb7","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airmaxb7) )
        shoelist.add(Shoes("Airmaxb8","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airmaxb8) )
        shoelist.add(Shoes("Airmaxb9","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airmaxb9) )
        shoelist.add(Shoes("react","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.react) )
        shoelist.add(Shoes("r","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.r) )

    }
}
