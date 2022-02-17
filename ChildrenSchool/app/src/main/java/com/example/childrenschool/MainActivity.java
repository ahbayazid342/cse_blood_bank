package com.example.childrenschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.childrenschool.BloodBank.BloodCollection;
import com.example.childrenschool.uploadactivity.UploadAlphabetActivity;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView bloodCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

          /*----------->>>>>>>>>>>>>>> Add Alphabet Features <<<<<<<<<<<<<<<<<<<<<<<<<-----------------------------
        ----------------------------------------------------------------------------------------------------------*/

        bloodCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BloodCollection.class);
                startActivity(intent);
            }
        });

    }

    private void initialize() {
        bloodCollection = findViewById(R.id.bloodCollection);
    }
}