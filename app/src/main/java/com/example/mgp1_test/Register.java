package com.example.mgp1_test;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;


public class Register extends AppCompatActivity{

    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    private EditText username1, email1, password1, firstname1, lastname1;
    private Button createAccBt;

    //checks if the user is already logged, code from firebase website
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //Will check if user is already logged in
        //and it go to the menu if users logged in
        if(currentUser != null){
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

    //https://www.youtube.com/watch?v=Z-RE1QuUWPg&t=1086s&ab_channel=CodeWithMazn
        username1 = (EditText) findViewById(R.id.username);
        email1 = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password);
        firstname1 = (EditText) findViewById(R.id.firstname);
        lastname1 = (EditText) findViewById(R.id.lastname);
        createAccBt = findViewById(R.id.button1);

        //when the fields are left blank and register button is clicked then youll get erros
        createAccBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, email, password, firstname, lastname;
                username = String.valueOf(username1.getText());
                email = String.valueOf(email1.getText());
                password = String.valueOf(password1.getText());
                firstname = String.valueOf(firstname1.getText());
                lastname = String.valueOf(lastname1.getText());

                //if the fields are left blank you'll get error codes
                //validation for fields
                if (username.isEmpty()) {
                    username1.setError("Please Enter Username");
                    username1.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    email1.setError("Please Enter Email Address");
                    email1.requestFocus();
                    return;
                }
                //validation if email does not match pattern it will give an error
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email1.setError("Email must be a valid email");
                    email1.requestFocus();
                    return;

                }
                if (password.isEmpty()) {
                    password1.setError("Please Enter Password");
                    password1.requestFocus();
                    return;
                }
                if (firstname.isEmpty()) {
                    firstname1.setError("Please Enter First Name");
                    firstname1.requestFocus();
                    return;

                }
                if (lastname.isEmpty()) {
                    lastname1.setError("Please Enter Last Name");
                    lastname1.requestFocus();
                    return;

                }

                //validation if fields are less than 8 character it will give an error
                if (username.length() < 5) {
                    username1.setError("Username must be minimum 5 characters");
                    username1.requestFocus();
                   return;
                }



                if (password.length() < 8) {
                password1.setError("Password must be minimum 8 characters");
                password1.requestFocus();
                return;
            }
                //https://firebase.google.com/docs/auth/android/password-auth
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {


                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Register.this, "You have created an account.",
                                            Toast.LENGTH_SHORT).show();



                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register.this, "failed to Create account.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });



            }
            });

    }
}