package com.example.clickmelistener

//Create two classes that we will use to represent the data within our app
//Represent Courses and Notes within our app

data class CourseInfo(val courseId: String,val title: String) {
    override fun toString(): String {
        return title

        /*
        When the courseInfo instances are displayed within our spinner,we need to determine which value
        from the instance we want displayed
        =-- We do this by overriding the toString() method
         */
    }
}

data class NoteInfo(var course: CourseInfo? = null,var title : String? = null,var text: String? = null)

// null means there are is no value associated with it




/*Add  class to manage data within our application,and use initializer blocks
 and some functions

 = Create a class that will serve as a central point of management for instances of
 the above classes(NoteInfo and CourseInfo)


 */

