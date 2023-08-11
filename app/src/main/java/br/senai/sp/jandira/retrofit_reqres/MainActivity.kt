package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RretrofitHelper.getInstance().create(ApiService::class.java)

        //Botão de Get
        findViewById<Button>(R.id.btnGet).setOnClickListener{
//          Log.e("Getting data", "Teste do botão Get")
            getUserById()
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

    private fun getUserById() {
        lifecycleScope.launch {
            val result = apiService.getUserById("1")

            if(result.isSuccessful){
                Log.e("Get", "${result.body()?.data}")
            }else{
                Log.e("Get error", "${result.errorBody()}")
            }
        }
    }
}