package com.example.mgp1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//References:
//https://stackoverflow.com/questions/67219782/how-to-make-notes-section-in-an-app-already-created-in-android-studio
//https://www.youtube.com/watch?v=or_pH92l-IQ
public class NoteViewerActivity extends AppCompatActivity {

    private ListView mNoteList;
    private List<Note> mNotes;
    private NoteViewerAdapter mAdapter;
    private Button returnToNotes;
    private Button returnToMainMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_viewer);

        mNoteList = findViewById(R.id.noteList);

        // Load notes from storage mNotes list
        mNotes = new ArrayList<>();

        // some sample notes
        mNotes.add(new Note("Note 1", "note 1"));
        mNotes.add(new Note("Note 2", "note 2"));
        mNotes.add(new Note("Note 3", "note 3"));

        // Get the updated mNotes list from Intent
        mNotes = (List<Note>) getIntent().getSerializableExtra("notes");
        if (mNotes == null) {
            mNotes = new ArrayList<>();
        }

        // Set the adapter with the updated mNotes list
        mAdapter = new NoteViewerAdapter(this, R.layout.note_item, mNotes);
        mNoteList.setAdapter(mAdapter);


        returnToNotes = (Button) findViewById(R.id.returnToNotes);
        returnToNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteViewerActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });

        returnToMainMenuButton = (Button) findViewById(R.id.returnToMainMenuButton);
        returnToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteViewerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}