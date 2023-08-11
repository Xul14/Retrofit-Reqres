package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Botão de Get
        findViewById<Button>(R.id.btnGet).setOnClickListener{
            Log.e("Getting data", "Teste do botão Get")
        }

        //Botão de Put
        findViewById<Button>(R.id.btnPut).setOnClickListener{
            Log.e("Putting data", "Teste do botão Put")
        }

        //Botão de Post
        findViewById<Button>(R.id.btnPost).setOnClickListener{
            Log.e("Post data", "Teste do botão Post")
        }

        //Botão de Delete
        findViewById<Button>(R.id.btnDelete).setOnClickListener{
            Log.e("Delete data", "Teste do botão Delete")
        }

    }
}