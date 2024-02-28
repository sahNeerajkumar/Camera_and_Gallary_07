package com.example.camera_and_gallary_07

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.FileProvider
import java.io.File

class GalleryActivityPermission : AppCompatActivity() {
    lateinit var imageView:ImageView
    lateinit var galleryperbtn:Button

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_permission)

        val FILE_NAME = "photo.jpg"
        imageView = findViewById(R.id.image_View);
        galleryperbtn = findViewById(R.id.galleryPermission);


        galleryperbtn.setOnClickListener {
            // val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            //val filePhoto = getPhotoFile(FILE_NAME)
            var filePhoto = getPhotoFile(FILE_NAME)
            val providerFile = FileProvider.getUriForFile(
                this,
                "com.example.androidcamera.fileprovider",
                filePhoto
            )
            intent.putExtra(MediaStore.EXTRA_OUTPUT, providerFile)
        }
    }

        private fun getPhotoFile(fileName: String): File {
            val directoryStorage = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            return File.createTempFile(fileName, ".jpg", directoryStorage)
        }

}



