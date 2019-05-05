package com.example.a777.simpletextfilewriter

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.a777.simpletextfilewriter.di.ActivityModule
import com.example.a777.simpletextfilewriter.di.DaggerAppComponent
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    @Inject
    lateinit var textFile: TextFile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPermissions()
        injectDependency()
        imgBtnSaveFile.setOnClickListener { saveFile() }
    }

    private fun injectDependency(){
        val activityComponent = DaggerAppComponent.builder()
              .activityModule(ActivityModule() )
              .build()
        activityComponent.inject(this)
    }


    private fun setupPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1234)

    }

    private fun saveFile() {
        //val date1 = System.currentTimeMillis()
        //val fileName = "${date1.toString()}.txt"

        val fileName = textFile.getFileName()


        val dir1 = Environment.getExternalStorageDirectory()
        val dir2 = "$dir1/AisBrigade/Texts"

        val dir = File(dir2)
        dir.mkdir()

        //dir.createNewFile() // создание папки если её нет

        val file1 = File(dir2, fileName)

        File(file1.path).writeText(etTextFile.text.toString())

        Log.d(TAG, "OK, path - ${file1.path}")

        Toast.makeText(this, "Путь: ${file1.path}", Toast.LENGTH_LONG).show()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            1234 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Разрешение получено!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Разрешение НЕ получено!!", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}
