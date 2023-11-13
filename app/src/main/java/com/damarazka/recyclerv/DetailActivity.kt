package com.damarazka.recyclerv

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>("key_hero", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>("key_hero")
        }
        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        tvDetailName.text = dataHero?.name
        tvDetailDescription.text = dataHero?.description
        ivDetailPhoto.setImageResource(dataHero!!.photo)
    }
}