package com.example.testapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DocumentUploadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.document_upload)

        val addressInput: EditText = findViewById(R.id.input_address)
        val buttonOpenMaps: Button = findViewById(R.id.button_open_maps)
        val buttonOpenCamera: Button = findViewById(R.id.button_open_camera)

        buttonOpenMaps.setOnClickListener {
            val address = addressInput.text.toString()
            val geoUri = "geo:0,0?q=${Uri.encode(address)}"
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        buttonOpenCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 101)
        }
    }
}
