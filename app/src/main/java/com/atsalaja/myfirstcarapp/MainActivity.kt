package com.atsalaja.myfirstcarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atsalaja.myfirstcarapp.car.Car
import com.atsalaja.myfirstcarapp.car.DataCar
import com.atsalaja.myfirstcarapp.car.DetailCarActivity
import com.atsalaja.myfirstcarapp.car.DetailCarActivity.Companion.EXTRA_CAR

class MainActivity : AppCompatActivity() {

    private lateinit var rvCars: RecyclerView
    private val list = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "Honda Motor Cars"
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.gray_light))
        setContentView(R.layout.activity_main)

        rvCars = findViewById(R.id.rv_cars)
        rvCars.setHasFixedSize(true)

        list.addAll(DataCar.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCars.layoutManager = LinearLayoutManager(this)
        val listCarAdapter = ListCarAdapter(list)
        rvCars.adapter = listCarAdapter

        listCarAdapter.setOnItemClickCallback(object : ListCarAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Car){
                showSelectedCar(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showSelectedCar(car: Car) {
        Toast.makeText(this, "Kamu memilih " + car.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, DetailCarActivity::class.java)
        intent.putExtra(EXTRA_CAR, car)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}