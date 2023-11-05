package com.atsalaja.myfirstcarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val actionBar = supportActionBar
        actionBar!!.title = "About Me"
        actionBar.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.gray_light))
        setContentView(R.layout.activity_about)

        val imageAbout: ImageView = findViewById(R.id.img_item_about)
        val srcImg = R.drawable.atsalface
        Glide.with(this)
            .load(srcImg)
            .apply(RequestOptions())
            .into(imageAbout)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}