package me.adswt518.todolist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import me.adswt518.todolist.NoteOperator
import me.adswt518.todolist.R
import me.adswt518.todolist.beans.Note

class NoteListAdapter(operator: NoteOperator) :
    RecyclerView.Adapter<NoteViewHolder?>() {
    private val operator: NoteOperator = operator
    private val notes: MutableList<Note> = ArrayList<Note>()
    fun refresh(newNotes: List<Note>?) {
        notes.clear()
        if (newNotes != null) {
            notes.addAll(newNotes)
        }
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, pos: Int): NoteViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView, operator)
    }

    override fun onBindViewHolder(@NonNull holder: NoteViewHolder, pos: Int) {
        holder.bind(notes[pos])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}
