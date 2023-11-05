package com.atsalaja.myfirstcarapp.car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.atsalaja.myfirstcarapp.R
import com.bumptech.glide.Glide

class DetailCarActivity : AppCompatActivity() {
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_car)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Car"
        actionbar.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.gray_light))
        setContentView(R.layout.activity_detail_car)

        val tvNameCar: TextView = findViewById(R.id.tv_detail_name)
        val imgCarDetail: ImageView = findViewById(R.id.img_detail_cars)
        val tvDetailSpec: TextView = findViewById(R.id.tv_set_spec)
        val tvDetaiDesc: TextView = findViewById(R.id.tv_set_description)

        val car = intent.getParcelableExtra<Car>(EXTRA_CAR)

        if (car != null) {
            tvNameCar.text = car.name
            Glide.with(this)
                .load(car.image)
                .into(imgCarDetail)
            tvDetailSpec.text = car.transmisi + "\n" + car.bbm + "\n" + car.cc
            tvDetaiDesc.text = car.description
        }
    }

    private fun shareCarInfo() {
        val shareText = "Share Button Success!"

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    companion object {
        const val EXTRA_CAR = "extra_car"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_car, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                shareCarInfo()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}