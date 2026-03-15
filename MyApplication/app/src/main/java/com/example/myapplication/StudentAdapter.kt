package com.example.myapplication

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(android.R.id.text1)
        val tvInfo: TextView = view.findViewById(android.R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val s = students[position]
        holder.tvName.text = "${s.name} - ${s.score}"


        holder.tvInfo.text = "Grade : ${s.grade} | Mention : ${s.mention} | ${if (s.isRecu()) "Reçu" else "Recalé"}"
        }
    override fun getItemCount() = students.size
}