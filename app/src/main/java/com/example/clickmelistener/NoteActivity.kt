package com.example.clickmelistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.widget.Spinner
import com.example.clickmelistener.databinding.ActivityMainBinding
import android.widget.ArrayAdapter as ArrayAdapter

class NoteActivity : AppCompatActivity() {

    private var notePosition = POSITION_NOT_SET
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





    notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

    if(notePosition != POSITION_NOT_SET)
        displayNote()
    else {
// Noteinfo() will create a new empty note
        DataManager.notes.add(NoteInfo())
        notePosition = DataManager.notes.lastIndex



    }





     // val dm = DataManager()  -> THis becomes invalid since DataManager is no longer a class but is now a singleton
       // well populate our spinner with the DataManager Class
      //Now that we have created an instance of DataManager, we can
    // create the Adapter

        /*
        ArrayAdapter is an adapter class that we can use with in-memory data sources
        like arrays and lists
          ArrayAdapter is a generic type and it requires that we specify the kind of data that we are accessing
          - we are going to access instances of our CourseInfo class



-- Below the object(singleton) name itself which is "DatsManager" is used to access the courses
  we therefore access the same instance of the datamanager class
         */
      val adapterCourses = ArrayAdapter<CourseInfo>(this,
           android.R.layout.simple_spinner_item,
          DataManager.courses.values.toList() )


      adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


         binding.spinner2.adapter = adapterCourses


    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        binding.textNoteTitle.setText(note.title)
        binding.textNoteText.setText(note.text)
        val coursePosition = DataManager.courses.values.indexOf(note.course)
        binding.spinner2.setSelection(coursePosition)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_settings -> true
            R.id.action_next -> {
                moveText()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun moveText() {
        ++notePosition
        displayNote()
        invalidateOptionsMenu()
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        //to make sure this method is always called,make a call to the invalidateOptionsMenu()
        if (notePosition >= DataManager.notes.lastIndex){

            val menuItem = menu.findItem(R.id.action_next)
            if (menuItem != null){
                menuItem.icon = getDrawable(R.drawable.ic_block_white_24)
                menuItem.isEnabled = false

            }

            /*
             Below..change icon that is used for our menu item when last position is reached
             */
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {

        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        val note = DataManager.notes[notePosition]
        note.title = binding.textNoteTitle.text.toString()
        note.text = binding.textNoteText.text.toString()
        note.course = binding.spinner2.selectedItem as CourseInfo // ask gads mentor what this line means
    }
}