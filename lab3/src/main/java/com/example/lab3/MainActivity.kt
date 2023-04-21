package com.example.lab3

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val planeImageView: ImageView = findViewById(R.id.imageView4)
        val buildImageView1 = findViewById<ImageView>(R.id.imageView5)
        val buildImageView2 = findViewById<ImageView>(R.id.imageView6)
        val cloudImageView1 = findViewById<ImageView>(R.id.imageView2)
        val cloudImageView2 = findViewById<ImageView>(R.id.imageView3)
        val sunImageView = findViewById<ImageView>(R.id.imageView)
        val flightAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.flight_animation)
        val buildAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.build_animations)
        val cloudAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.cloud_animation)
        val sunAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sun_animation)
        planeImageView.startAnimation(flightAnimation)
        buildImageView1.startAnimation(buildAnimation)
        buildImageView2.startAnimation(buildAnimation)
        cloudImageView1.startAnimation(cloudAnimation)
        cloudImageView2.startAnimation(cloudAnimation)
        sunImageView.startAnimation(sunAnimation)
    }
}