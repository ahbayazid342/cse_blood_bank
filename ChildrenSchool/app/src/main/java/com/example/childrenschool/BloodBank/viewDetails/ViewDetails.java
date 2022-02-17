package com.example.childrenschool.BloodBank.viewDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.childrenschool.BloodBank.viewDetails.adapter.Adapter;
import com.example.childrenschool.BloodBank.viewDetails.donorShowModel.ShowDonor;
import com.example.childrenschool.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewDetails extends AppCompatActivity {

    DatabaseReference reference;

    RecyclerView bgRecyclerView;
    ArrayList <ShowDonor> bgList;
    Adapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        progressBar = findViewById(R.id.showBgProgreassBar);

       bgRecyclerView = findViewById(R.id.showBgRecyclerView);
       bgRecyclerView.setHasFixedSize(true);
       bgRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions <ShowDonor> options = new FirebaseRecyclerOptions.Builder<ShowDonor>()
                .setQuery(FirebaseDatabase.getInstance().getReference("47").getParent(), ShowDonor.class).build();

        adapter = new Adapter(options);
        bgRecyclerView.setAdapter(adapter) ;

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
        progressBar.setVisibility(View.INVISIBLE);
    }
}