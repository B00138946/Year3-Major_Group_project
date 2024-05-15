package com.example.mgp1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//References:
//https://stackoverflow.com/questions/67219782/how-to-make-notes-section-in-an-app-already-created-in-android-studio
//https://www.youtube.com/watch?v=or_pH92l-IQ
public class NotesActivity extends AppCompatActivity {

    private Button addNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        addNoteButton = findViewById(R.id.addnewnotebtn);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }
}