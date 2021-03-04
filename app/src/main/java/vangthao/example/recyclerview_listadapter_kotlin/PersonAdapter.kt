package vangthao.example.recyclerview_listadapter_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val onClick: (Person) -> Unit) :
    ListAdapter<Person, PersonAdapter.PersonViewHolder>(PersonDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName by lazy { itemView.findViewById<TextView>(R.id.txt_name) }

        init {
//            itemView.setOnClickListener {
//                onClick(getItem(adapterPosition))
//            }
            txtName.setOnClickListener {
                onClick(getItem(adapterPosition))
            }
        }

        fun bind(person: Person) {
            txtName.text = person.name
        }
    }

}