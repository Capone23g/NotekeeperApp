package com.example.clickmelistener

import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class NoteRecyclerAdapter (private val context: Context, private val notes: List<NoteInfo>): RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>(){



    // Create Layout inflater which will help us to inflate layout resources

    private val layoutInflater = LayoutInflater.from(context)

   

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val itemView = layoutInflater.inflate(
            R.layout.item_note_list,parent,false)

        return ViewHolder(itemView)
        // The return type for onCreateViewHolder is an instance of ViewHolder that contains a reference to the inflated view

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     

      val note = notes[position]
      holder.textCourse?.text = note.course?.title
      holder.textTitle?.text = note.title
    }

    override fun getItemCount() = notes.size






    class ViewHolder(itemView:View?): RecyclerView.ViewHolder(itemView!!){


        val textCourse = itemView?.findViewById<TextView?>(R.id.textCourse)
        val textTitle = itemView?.findViewById<TextView?>(R.id.textNote)



    }


}