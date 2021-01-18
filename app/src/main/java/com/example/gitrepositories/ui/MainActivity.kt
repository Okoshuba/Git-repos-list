package com.example.gitrepositories.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrepositories.R
import com.example.gitrepositories.Repository.Users
import com.example.gitrepositories.Repository.UsersAdapter
import com.example.gitrepositories.listener.Listener
import com.example.gitrepositories.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
    }

    private fun fetchData() {
        RetrofitBuilder.newApi.getUsers().enqueue(object: Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                showData(response.body()!!)
                //d("Check", "onResponse: ${response.body()!![0].id}")
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ошибка получения данных. Включите интернет соединение", Toast.LENGTH_SHORT).show()
            }
        })
    }

    //Метод, который формирует список пользователей в recyclerView
    private fun showData(users: List<Users>) {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = UsersAdapter(this, users, this)
    }

    //Обработчик нажатия на элемент коллекции
    override fun onItemClickListener(position: Int, html : String) {

        val intent = Intent(this, WebPageActivity::class.java)
        intent.putExtra("web", html)
        startActivity(intent)
    }
}
