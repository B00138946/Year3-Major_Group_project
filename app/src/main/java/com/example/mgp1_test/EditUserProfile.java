package com.example.mgp1_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditUserProfile extends AppCompatActivity {
//https://www.youtube.com/watch?v=Yi8mxXsroJ4



    EditText editAge;
    EditText editWeight;
    EditText editGoals;
    Button SaveProfile;

    DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);








        mDatabase = FirebaseDatabase.getInstance().getReference();


        SaveProfile = (Button) findViewById(R.id.SaveProfile);
        editAge = (EditText) findViewById(R.id.editAge);
        editWeight = (EditText) findViewById(R.id.editWeight);
        editGoals = (EditText) findViewById(R.id.editGoals);


// save button is clicked redirects to userprofile
//With data shown
SaveProfile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String EditAge = editAge.getText().toString();
            String EditWeight = editWeight.getText().toString();
            String EditGoals = editGoals.getText().toString();


            Intent intent = new Intent(EditUserProfile.this, UserProfile.class);


            intent.putExtra("ageId",EditAge);
            intent.putExtra("weightId",EditWeight);
            intent.putExtra("goalsId",EditGoals);
            startActivity(intent);
            finish();

            }

    });

    }
}