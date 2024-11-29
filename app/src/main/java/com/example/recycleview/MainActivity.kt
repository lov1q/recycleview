package com.example.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //формируем список
        val dataset=buildList(20)
        // Находим recyclerview на макете
        val rv: RecyclerView =findViewById(R.id.rvContacts)
        // Создаем адаптер
        // Подключаем адаптер к recyclerview для заполнения элементов
        rv.adapter=ContactsAdapter(dataset)
        // Настроить диспетчер компоновки для размещения элементов
        rv.layoutManager= LinearLayoutManager(this)

    }

    //метод для формирования списка
    fun buildList(n:Int):List<Contact>{
        val list= mutableListOf<Contact>()
        for (i in 1..n/2){
            list.add(Contact("Студент #$i",true))
        }
        for (i in n/2+1..n){
            list.add(Contact("Студент #$i)",false))
        }
        return list
    }

}