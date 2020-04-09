package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnShoeItemClickListener {


    lateinit var binding:ActivityMainBinding
    lateinit var shoelist: ArrayList<Shoes>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        shoelist = ArrayList()
        addShoes()

        ShoeRecycler.layoutManager = LinearLayoutManager(this)
        ShoeRecycler.addItemDecoration(DividerItemDecoration(this,1))
        ShoeRecycler. adapter = ShoeAdapter(shoelist, this)

    }

    fun addShoes(){
        shoelist.add(Shoes("Airforce","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airforce) )
        shoelist.add(Shoes("Airmaxb7","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airmaxb7) )
        shoelist.add(Shoes("Airmaxb8","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airmaxb8) )
        shoelist.add(Shoes("Airmaxb9","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.airmaxb9) )
        shoelist.add(Shoes("react","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.react) )
        shoelist.add(Shoes("r","good shoe,good shoe,good shoe,good shoe,good shoe,good shoe", R.drawable.r) )

    }

    override fun onItemClick(item: Shoes, position: Int) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ShoeDetailsActivity::class.java)
        intent.putExtra("SHOENAME", item.name)
        intent.putExtra("SHOEDESC", item.description)
        intent.putExtra("SHOELOGO", item.logo.toString())
        startActivity(intent)
    }
}
