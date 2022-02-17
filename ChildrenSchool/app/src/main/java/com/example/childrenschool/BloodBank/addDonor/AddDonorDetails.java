package com.example.childrenschool.BloodBank.addDonor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.childrenschool.BloodBank.addDonor.donorModel.DonorData;
import com.example.childrenschool.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDonorDetails extends AppCompatActivity {

    private TextInputLayout dName, dBatch, dContact, dBg, dWeight;
    private Button addDonorBtn;
    String name, batch, contact, bg, weight;



    //------->>>> Firebase Variable <<<<---------
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor_details);

        initilize();

        addDonorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData();

                DonorData donorData = new DonorData(name, batch, contact, bg, weight);

                database = FirebaseDatabase.getInstance();
                reference = database.getReference().child(batch);
                reference.child(bg).setValue(donorData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Inserted Data", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Not Inserted Data", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    private void initilize() {
        dName = findViewById(R.id.donorName);
        dBatch = findViewById(R.id.donorBatch);
        dContact = findViewById(R.id.donorContact);
        dBg = findViewById(R.id.donorBloodGroup);
        dWeight = findViewById(R.id.donorWeight);
        addDonorBtn = findViewById(R.id.addDonorBtn);
    }

    private void getData() {
        name = dName.getEditText().getText().toString();
        batch = dBatch.getEditText().getText().toString().trim();
        contact = dContact.getEditText().getText().toString().trim();
        bg = dBg.getEditText().getText().toString().trim();
        weight = dWeight.getEditText().getText().toString().trim();
    }
}