package com.example.nutrafresh.dashboard

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nutrafresh.R
import com.example.nutrafresh.adapters.fruits_adapter
import com.example.nutrafresh.models.url_model
import java.io.FileDescriptor
import java.io.IOException


var image_uri: Uri? = null
private val RESULT_LOAD_IMAGE = 123
val IMAGE_CAPTURE_CODE = 654
class dashboard : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: fruits_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        var recv=findViewById<RecyclerView>(R.id.recv)
        loadRecView(recv);
        var camera=findViewById<CardView>(R.id.camera)
        var gallery=findViewById<CardView>(R.id.gallery)
Log.i("check","on create")
        camera.setOnClickListener {
           // checkCameraPermission()
        }
        gallery.setOnClickListener(View.OnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, 123)

        })



        camera?.setOnClickListener(View.OnClickListener {
           openCamera()

        })


        //TODO chose image from gallery
        gallery?.setOnClickListener(View.OnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE)
        })
    }

    var image_uri: Uri? = null
    private val RESULT_LOAD_IMAGE = 123
    val IMAGE_CAPTURE_CODE = 654

    //TODO opens camera so that user can capture image
    private fun openCamera() {
        print("openCamera");
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1888)

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_CAPTURE_CODE && resultCode == Activity.RESULT_OK) {
            //imageView.setImageURI(image_uri);
            //Toast.makeText(this,image_uri.toString(),Toast.LENGTH_SHORT).show()
            val bitmap = uriToBitmap(image_uri!!)
            //frame?.setImageBitmap(bitmap)
            setDialog1(
                this,
                bitmap)
        }
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            image_uri = data.data
            //imageView.setImageURI(image_uri);
            val bitmap = uriToBitmap(image_uri!!)
            //frame?.setImageBitmap(bitmap)
            setDialog1(
                this,
                bitmap)
        }
    }
    private fun setDialog1(dashboard: dashboard, bitmap: Bitmap?) {

        val alertadd = android.app.AlertDialog.Builder(this)
        val factory = LayoutInflater.from(this)
        val view1: View = factory.inflate(R.layout.activity_details_page, null)
        var ft_img=view1.findViewById<ImageView>(R.id.ft_img)
        // var ft_name=view1.findViewById<TextView>(R.id.ft_name)
        var bt_ok=view1.findViewById<TextView>(R.id.button_okk)
        bt_ok.text="Confirm?\n"
        bt_ok.setOnClickListener {
            alertadd.setOnDismissListener {
                alertadd.setCancelable(true)
            }
        }
        ft_img.setImageBitmap(bitmap)
        //ft_name.text=ft1Name
        //ft_desc.text=ft1Desc
        alertadd.setView(view1)

        alertadd.show()
    }

    //TODO takes URI of the image and returns bitmap
    private fun uriToBitmap(selectedFileUri: Uri): Bitmap? {
        try {
            val parcelFileDescriptor = contentResolver.openFileDescriptor(selectedFileUri, "r")
            val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
            val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            parcelFileDescriptor.close()
            return image
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }





    private fun loadRecView(recv: RecyclerView?) {
        layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        adapter = fruits_adapter(this)
        if (recv != null) {
            recv.layoutManager = layoutManager
            recv.adapter = adapter
        }
         var url_list = mutableListOf<url_model>()
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        adapter.seturllist(url_list);
    }


}