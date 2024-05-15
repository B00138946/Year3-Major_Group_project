package com.example.mgp1_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class UserProfile extends AppCompatActivity {
    TextView email;
    TextView firstname;

    TextView ageText;
    TextView weightText;
    TextView goalsText;

    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseFirestore fStore;

    DatabaseReference mDatabase;

    private Button buttonLogOut;
    private Button editProfileB;
    Button changeProfile;
    ImageView ProfilePic;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);




        mDatabase = FirebaseDatabase.getInstance().getReference();

        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);
        editProfileB = (Button) findViewById(R.id.editProfileB);
        ProfilePic = (ImageView) findViewById(R.id.ProfilePic);
        changeProfile = (Button) findViewById(R.id.changeProfile);

        email = findViewById(R.id.email);
        firstname = findViewById(R.id.firstname);



        //edit profile detail for age, weight and goals
        //https://www.youtube.com/watch?v=Yi8mxXsroJ4
        ageText = (TextView) findViewById(R.id.ageText);
        weightText = (TextView) findViewById(R.id.weightText);
        goalsText = (TextView) findViewById(R.id.goalsText);




        String EditAge = getIntent().getStringExtra("ageId");
        String EditWeight = getIntent().getStringExtra("weightId");
        String EditGoals = getIntent().getStringExtra("goalsId");

        ageText.setText(EditAge);
        weightText.setText(EditWeight);
        goalsText.setText(EditGoals);





        auth = FirebaseAuth.getInstance();
        fStore =FirebaseFirestore.getInstance();
        user = auth.getCurrentUser();

        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileRef = storageReference.child("users/"+auth.getCurrentUser().getUid()+"profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(ProfilePic);
            }
        });


        //https://www.youtube.com/watch?v=QAKq8UBv4GI&t=1740s&ab_channel=CodesEasy
        //https://firebase.google.com/docs/auth/android/manage-users
        //This shows email address and the name of user on profile
        if (user == null) {

            Intent intent = new Intent(UserProfile.this, Register.class);
            startActivity(intent);
            finish();
        } else {
            email.setText(user.getEmail());
            firstname.setText(user.getDisplayName());

        }



        //when log out button  is clicked it redirects to loginpage
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(UserProfile.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        //when edit profile button is clicked it redirects to edituserprofile
        editProfileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, EditUserProfile.class);

                startActivity(intent);
                finish();
            }
        });


        //References of setting ProfilePic
        //https://www.youtube.com/watch?v=nNYLQcmB7AU&ab_channel=SmallAcademy
        //https://www.youtube.com/watch?v=qANyvTysn04&ab_channel=SmallAcademy
        //https://www.youtube.com/watch?v=uATQAsFFC0o&ab_channel=SmallAcademy
        //when the change profile button is clicked
        //the gallery will open to chose an image
        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(openGalleryIntent, 1000);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                //ProfilePic.setImageURI(imageUri);

                uploadPicToFirebase(imageUri);
            }
        }
    }
    //this will upload picture to firebase
    private void uploadPicToFirebase(Uri imageUri){
    final StorageReference fileRef = storageReference.child("users/"+auth.getCurrentUser().getUid()+"profile.jpg");
    fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
       //The image will upload successfully to the database or fail
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
       fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
           @Override
           public void onSuccess(Uri uri) {
               Picasso.get().load(uri).into(ProfilePic);
           }
       });
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Toast.makeText(UserProfile.this, "Failed to upload", Toast.LENGTH_SHORT).show();
        }
    });



    }
}
