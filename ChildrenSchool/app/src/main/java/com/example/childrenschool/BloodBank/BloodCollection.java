package com.example.childrenschool.BloodBank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.childrenschool.BloodBank.addDonor.AddDonorDetails;
import com.example.childrenschool.BloodBank.viewDetails.ViewDetails;
import com.example.childrenschool.R;
import com.example.childrenschool.uploadactivity.ImageActivity;
import com.example.childrenschool.uploadactivity.UploadAlphabetActivity;
import com.google.android.material.card.MaterialCardView;

public class BloodCollection extends AppCompatActivity {

    private MaterialCardView addDonorDetails;
    private MaterialCardView viewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_collection);

        addDonorDetails = findViewById(R.id.addDonorDetails);
        viewDetails = findViewById(R.id.viewDetails);

        addDonorDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodCollection.this, AddDonorDetails.class);
                startActivity(intent);
            }
        });


        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodCollection.this, ViewDetails.class);
                startActivity(intent);
            }
        });
    }
}