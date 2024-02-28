package com.example.camera_and_gallary_07

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import java.security.Permissions

class MainActivity : AppCompatActivity() {
    private lateinit var cameranadgalleryimages: ImageView
    private lateinit var cameraPer_text: TextView
    private lateinit var cameraPer_button: Button
    private lateinit var galleryPer_text: TextView
    private lateinit var galleryPer_button: Button

    @SuppressLint("MissingInflatedId", "ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cameranadgalleryimages = findViewById(R.id.Camera_And_Gallery_Show_image)
        cameraPer_button = findViewById(R.id.cameraPermission_Button)
        cameraPer_text = findViewById(R.id.cameraPermission_textView)
        galleryPer_text = findViewById(R.id.galleryPremission_textView)
        galleryPer_button = findViewById(R.id.galleryPremission_button)


        cameraPer_button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cheakCameraPermission()
            }
        }
        galleryPer_button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cheakGalleryPermission()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun cheakCameraPermission() {
        if (ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            cameraPer_text.text = "Camera has granted permission"
            openCameraAndTakeImage()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ), 10
            )
        }
    }
    @SuppressLint("SetTextI18n")
    fun cheakGalleryPermission() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED) {
            galleryPer_text.text = "Gallery has granted permission"
            //openCameraAndTakeImage()
        }
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 20)
        }
    }










    fun openCameraAndTakeImage() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 10)
    }


    @SuppressLint("SetTextI18n")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    )     {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 10) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                cameraPer_text.text = "Camera has granted permission"
                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                startActivity(intent)
            } else {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                //val uri = Uri.fromParts("packege", packageName, null)
                val uri = Uri.fromParts("packege", packageName, null)
                intent.setData(uri)
                startActivity(intent)
            } }

        if (requestCode == 20) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                galleryPer_text.text = "Camera has granted permission"
                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                startActivity(intent)
            } else {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                //val uri = Uri.fromParts("packege", packageName, null)
                val uri = Uri.fromParts("packege", packageName, null)
                intent.setData(uri)
                startActivity(intent)
            } }




    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10 && resultCode == RESULT_OK) {
            val image = data?.extras?.get("data") as Bitmap
            cameranadgalleryimages.setImageBitmap(image)
        }
    }
}

