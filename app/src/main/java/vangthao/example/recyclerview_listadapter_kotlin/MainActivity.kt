package vangthao.example.recyclerview_listadapter_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val mRvPerson by lazy { findViewById<RecyclerView>(R.id.rvPersons) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val persons = ArrayList<Person>()
        persons.add(Person("Thao A Vang"))
        persons.add(Person("Nguyen Van A"))
        persons.add(Person("Tran Thi B"))

        val personAdapter = PersonAdapter {
            Toast.makeText(this, "${it.name} clicked", Toast.LENGTH_SHORT).show()
        }

        mRvPerson.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            itemAnimator = DefaultItemAnimator()
            adapter = personAdapter
        }
        personAdapter.submitList(persons)
    }

    private fun onClick(person: Person) {
        Toast.makeText(this, "${person.name} clicked", Toast.LENGTH_SHORT).show()
    }
}