package com.example.mgp1_test;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.net.Uri;

//Reference for this
//https://www.youtube.com/watch?v=_1t6Ilan7SY&t=1s&ab_channel=RangingInfinity
public class QrScan extends AppCompatActivity {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan);

        button = (ImageButton) findViewById(R.id.ScanB);
        final Activity activity = this;
        button.setOnClickListener((view) -> {
            IntentIntegrator in = new IntentIntegrator(activity);
            in.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            in.setPrompt("Place the qr inside the camera");
            in.setCameraId(0);
            in.setOrientationLocked(true);
            in.setBeepEnabled(true);
            in.setBarcodeImageEnabled(false);
            in.initiateScan();

        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning",

                        Toast.LENGTH_LONG).show();
            }
            else {
                //should redirect to website on the qr code
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse

                        (result.getContents()));
                startActivity(browserIntent);
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }}}
