package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
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
//          Log.e("Putting data", "Teste do botão Put")
            updateUser()
        }

        //Botão de Post
        findViewById<Button>(R.id.btnPost).setOnClickListener{
//          Log.e("Post data", "Teste do botão Post")
            createUser()
        }

        //Botão de Delete
        findViewById<Button>(R.id.btnDelete).setOnClickListener{
//            Log.e("Delete data", "Teste do botão Delete")
            deeleteUser()
        }

    }

    //Lista um usuario
    private fun getUserById() {
        lifecycleScope.launch {
            val result = apiService.getUserById("1")

            if(result.isSuccessful){
                Log.i("Get", "${result.body()?.data}")
            }else{
                Log.e("Get error", "${result.errorBody()}")
            }
        }
    }

    // Cria um usuario
    private fun createUser() {
        lifecycleScope.launch {
            val body = JsonObject().apply{
                addProperty("name", "Julia Julia Julia")
                addProperty("job", "Dev Full Stack Sênior")
            }

            val result = apiService.createUser(body)

            if(result.isSuccessful){
                Log.i("Create data", "${result.body()}")
            }else{
                Log.e("Create data", "${result.errorBody()}")
            }
        }
    }

    //Atualiza os dados de um usuario existente
    private fun updateUser() {
        lifecycleScope.launch {
            val body = JsonObject().apply{
                addProperty("name", "Juliaaa")
                addProperty("job", "Dev Full Stack Sênior")
            }

            val result = apiService.updateUser("1", body)

            if(result.isSuccessful){
                Log.i("Update data", "${result.body()}")
            }else{
                Log.e("Update data", "${result.errorBody()}")
            }
        }
    }

    //Deleta um usuario
    private fun deeleteUser() {
        lifecycleScope.launch {
            val result = apiService.deleteUser(("10"))

            if(result.isSuccessful){
                Log.i("Delete data", "${result}")
            }else{
                Log.e("Delete data", "${result.errorBody()}")
            }

        }
    }

}