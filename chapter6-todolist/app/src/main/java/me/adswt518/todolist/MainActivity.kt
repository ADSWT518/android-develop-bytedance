package me.adswt518.todolist

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.provider.BaseColumns
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.adswt518.todolist.beans.Note
import me.adswt518.todolist.beans.Priority
import me.adswt518.todolist.beans.State
import me.adswt518.todolist.db.TodoContract.TodoNote
import me.adswt518.todolist.db.TodoDbHelper
import me.adswt518.todolist.debug.DebugActivity
import me.adswt518.todolist.ui.NoteListAdapter
import java.util.*


class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_ADD = 1002

    private var recyclerView: RecyclerView? = null
    private var notesAdapter: NoteListAdapter? = null

    private var dbHelper: TodoDbHelper? = null
    private var database: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            startActivityForResult(
                Intent(this@MainActivity, NoteActivity::class.java),
                REQUEST_CODE_ADD
            )
        }

        dbHelper = TodoDbHelper(this)
        database = dbHelper!!.writableDatabase
        recyclerView = findViewById(R.id.list_todo)
        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView?.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        notesAdapter = NoteListAdapter(object : NoteOperator {
            override fun deleteNote(note: Note?) {
                this@MainActivity.deleteNote(note!!)
            }

            override fun updateNote(note: Note?) {
                updateNode(note!!)
            }
        })
        recyclerView?.adapter = notesAdapter
        notesAdapter?.refresh(loadNotesFromDatabase())
    }


    override fun onDestroy() {
        super.onDestroy()
        database!!.close()
        database = null
        dbHelper!!.close()
        dbHelper = null
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_settings -> return true
            R.id.action_debug -> {
                startActivity(Intent(this, DebugActivity::class.java))
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD
            && resultCode == RESULT_OK
        ) {
            notesAdapter!!.refresh(loadNotesFromDatabase())
        }
    }


    @SuppressLint("Range")
    private fun loadNotesFromDatabase(): List<Note>? {
        if (database == null) {
            return emptyList<Note>()
        }
        val result: MutableList<Note> = LinkedList<Note>()
        var cursor: Cursor? = null
        try {
            cursor = database!!.query(
                TodoNote.TABLE_NAME, null,
                null, null,
                null, null, TodoNote.COLUMN_PRIORITY.toString() + " DESC"
            )
            while (cursor.moveToNext()) {
                val id = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID))
                val content = cursor.getString(cursor.getColumnIndex(TodoNote.COLUMN_CONTENT))
                val dateMs = cursor.getLong(cursor.getColumnIndex(TodoNote.COLUMN_DATE))
                val intState = cursor.getInt(cursor.getColumnIndex(TodoNote.COLUMN_STATE))
                val intPriority = cursor.getInt(cursor.getColumnIndex(TodoNote.COLUMN_PRIORITY))
                val note = Note(id)
                note.content = (content)
                note.date = (Date(dateMs))
                note.state = (State.from(intState))
                note.priority = (Priority.from(intPriority))
                result.add(note)
            }
        } finally {
            cursor?.close()
        }
        return result
    }

    private fun deleteNote(note: Note) {
        if (database == null) {
            return
        }
        val rows: Int = database!!.delete(
            TodoNote.TABLE_NAME,
            BaseColumns._ID.toString() + "=?",
            arrayOf<String>(java.lang.String.valueOf(note.id))
        )
        if (rows > 0) {
            notesAdapter?.refresh(loadNotesFromDatabase())
        }
    }

    private fun updateNode(note: Note) {
        if (database == null) {
            return
        }
        val values = ContentValues()
        values.put(TodoNote.COLUMN_STATE, note.state?.intValue)
        val rows: Int = database!!.update(
            TodoNote.TABLE_NAME,
            values,
            BaseColumns._ID.toString() + "=?",
            arrayOf<String>(java.lang.String.valueOf(note.id))
        )
        if (rows > 0) {
            notesAdapter?.refresh(loadNotesFromDatabase())
        }
    }

}