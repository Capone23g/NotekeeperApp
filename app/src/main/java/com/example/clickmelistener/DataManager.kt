package com.example.clickmelistener
  /* Data  manager will need properties to hold collection of courses and
    collection of notes
     */


object DataManager {

    /*
    -creates a new instance of our hashmap and the hashmap maps String values to
    instances of our CourseInfo class
   - then a reference of that HashMap is assigned to our courses property
      /*
    ArrayList is a generic type and the type we want to store is NoteInfo
    */

     */
    val courses = HashMap<String,CourseInfo>()
    val notes = ArrayList<NoteInfo>()


    init {
        initializeCourses() // populates our courses collection
        initialiseNotes() // populates our Notes collection
    }
    private fun initializeCourses()  {


        /*Once we create the course instance ,we can add it to the course collection
        * With a hashmap we can do that by using its set method
        *
        * */
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)



    }


    private fun initialiseNotes(){
        //class NoteInfo(var course: CourseInfo,var title: String,var text: String)
        var course = courses["android_intents"]!!
        var note = NoteInfo(course, "Dynamic intent resolution",
            "Wow, intents allow components to be resolved at runtime")
        notes.add(note)
        note = NoteInfo(course, "Delegating intents",
            "PendingIntents are powerful; they delegate much more than just a component invocation")
        notes.add(note)

        course = courses["android_async"]!!
        note = NoteInfo(course, "Service default threads",
            "Did you know that by default an Android Service will tie up the UI thread?")
        notes.add(note)
        note = NoteInfo(course, "Long running operations",
            "Foreground Services can be tied to a notification icon")
        notes.add(note)

        course = courses["java_lang"]!!
        note = NoteInfo(course, "Parameters",
            "Leverage variable-length parameter lists")
        notes.add(note)
        note = NoteInfo(course, "Anonymous classes",
            "Anonymous classes simplify implementing one-use types")
        notes.add(note)

        course = courses["java_core"]!!
        note = NoteInfo(course, "Compiler options",
            "The -jar option isn't compatible with with the -cp option")
        notes.add(note)
        note = NoteInfo(course, "Serialization",
            "Remember to include SerialVersionUID to assure version compatibility")
        notes.add(note)
    }
}

