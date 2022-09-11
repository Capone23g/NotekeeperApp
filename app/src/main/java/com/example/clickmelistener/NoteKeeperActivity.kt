package com.example.clickmelistener

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clickmelistener.databinding.ActivityNoteKeeperBinding
import com.example.clickmelistener.databinding.ContentNoteKeeperBinding


class NoteKeeper : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoteKeeperBinding
    private lateinit var binding1: ContentNoteKeeperBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteKeeperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)



        binding.fab.setOnClickListener { view ->
            val activityIntent = Intent(this, NoteActivity::class.java)
            startActivity(activityIntent)

        }

        binding1.listitems.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding1.listitems.adapter = NoteRecyclerAdapter(this,DataManager.notes)



    }


    override fun onResume() {
        super.onResume()


    }
}


