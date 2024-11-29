package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private val dataset:List<Contact>,): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name: TextView =view.findViewById(R.id.contact_name)
        val online: Button =view.findViewById(R.id.message_button)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.item_contact,viewGroup,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text=dataset[position].name
        val  status:String=if(dataset[position].online)"Message" else  "Offline"
        viewHolder.online.setText(status)
        viewHolder.online.isEnabled=dataset[position].online
    }

    override fun getItemCount()=dataset.size


}