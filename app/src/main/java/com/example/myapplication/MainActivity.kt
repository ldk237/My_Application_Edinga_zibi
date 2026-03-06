package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val PICK_FILE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnImport = findViewById<Button>(R.id.btnImport)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val tvMoyenne = findViewById<TextView>(R.id.tvMoyenne)

        recyclerView.layoutManager = LinearLayoutManager(this)

        btnImport.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            startActivityForResult(intent, PICK_FILE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_FILE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                val inputStream = contentResolver.openInputStream(uri)
                inputStream?.let {
                    val students = readExcelFile(it)
                    val moyenne = students.map { s -> s.score }.average()
                    val tvMoyenne = findViewById<TextView>(R.id.tvMoyenne)
                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                    tvMoyenne.text = "Moyenne : %.2f | Grade : ${calculateGrade(moyenne)} | ${calculateMention(moyenne)}".format(moyenne)
                    recyclerView.adapter = StudentAdapter(students)
                }
            }
        }
    }
}