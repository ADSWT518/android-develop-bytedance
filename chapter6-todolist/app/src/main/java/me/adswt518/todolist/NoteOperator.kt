package me.adswt518.todolist

import me.adswt518.todolist.beans.Note

interface NoteOperator {
    fun deleteNote(note: Note?)
    fun updateNote(note: Note?)
}
