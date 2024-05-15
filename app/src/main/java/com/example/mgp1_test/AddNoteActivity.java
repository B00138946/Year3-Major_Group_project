package com.example.mgp1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//References:
//https://stackoverflow.com/questions/67219782/how-to-make-notes-section-in-an-app-already-created-in-android-studio
//https://www.youtube.com/watch?v=or_pH92l-IQ
public class AddNoteActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText contentEditText;
    private Button saveButton;
    private List<Note> mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        saveButton = findViewById(R.id.saveButton);

        // Initialize the mNotes list
        mNotes = new ArrayList<>();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();

                // Create a new Note object and add it to the mNotes list
                Note newNote = new Note(title, content);
                mNotes.add(newNote);

                // note saved
                Toast.makeText(AddNoteActivity.this, "Note saved!", Toast.LENGTH_SHORT).show();

                // Redirect to NoteViewerActivity with the updated mNotes list
                Intent intent = new Intent(AddNoteActivity.this, NoteViewerActivity.class);
                intent.putExtra("notes", (Serializable) mNotes);
                startActivity(intent);
            }
        });

    }
}