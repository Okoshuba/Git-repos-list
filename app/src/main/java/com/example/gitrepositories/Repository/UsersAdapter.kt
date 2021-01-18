package com.example.gitrepositories.Repository

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrepositories.listener.Listener
import kotlinx.android.synthetic.main.activity_items.view.*

class UsersAdapter (private val context: Context,
                    private val users: List<Users>,
                    val callback: Listener) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.gitrepositories.R.layout.activity_items,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        //val owner = owners[position]

        holder.id.text = user.id
        holder.name.text = user.name
        holder.owner.text = user.owner.login
        holder.description.text = user.description

        holder.itemView.setOnClickListener {callback.onItemClickListener(position, user.html_url)}
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val id: TextView = itemView.idUser
        val name: TextView = itemView.nameUser
        val owner: TextView = itemView.ownerUser
        val description: TextView = itemView.descUser
    }
}