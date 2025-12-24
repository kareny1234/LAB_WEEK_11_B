package com.example.lab_week_11_b

import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var photoFile: File

    private val takePhoto =
        registerForActivityResult(ActivityResultContracts.TakePicture()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.photo_button).setOnClickListener {
            photoFile = File(getExternalFilesDir(null), "photo.jpg")
            val uri = FileProvider.getUriForFile(
                this,
                "com.example.lab_week_11_b.camera",
                photoFile
            )
            takePhoto.launch(uri)
        }
    }
}
