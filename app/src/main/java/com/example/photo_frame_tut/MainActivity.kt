package com.example.photo_frame_tut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var image :ImageView
    var currentImage =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val prev = findViewById<FloatingActionButton>(R.id.imgprev)
        val next = findViewById<FloatingActionButton>(R.id.imgnext)

        prev.setOnClickListener {

            //this method is used to get info of the id of the current image
            val idcurrentimageString = "pic$currentImage"

            //convert string id into integer address associated with it
            val idcurrentimageint = this.resources.getIdentifier(idcurrentimageString,"id",packageName)

            //to find the integer address of the current image
            image=findViewById(idcurrentimageint)

            image.alpha= 0F
            currentImage =(4+currentImage -1)%4

            val idimagetoshowstring = "pic$currentImage"
            val  idimagetoshowint = this.resources.getIdentifier(idimagetoshowstring,"id",packageName)

            image = findViewById(idimagetoshowint)
            image.alpha=1F


        }

        next.setOnClickListener {

            val idcurrentimagestring = "pic$currentImage"

            val idcurrentimageint = this.resources.getIdentifier(idcurrentimagestring,"id",packageName)

            image = findViewById(idcurrentimageint)

            image.alpha =0F

            currentImage = (4+currentImage+1)%4

            val idimagetoshowstring = "pic$currentImage"
            val idimagetoshowint = this.resources.getIdentifier(idimagetoshowstring,"id",packageName)

            image=findViewById(idimagetoshowint)
            image.alpha=1F

        }

    }
}