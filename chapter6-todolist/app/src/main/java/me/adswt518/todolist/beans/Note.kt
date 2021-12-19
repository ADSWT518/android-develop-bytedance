package me.adswt518.todolist.beans

import java.util.Date

class Note(val id: Long) {
    var date: Date? = null
    var state: State? = null
    var content: String? = null
    var priority: Priority? = null
}
