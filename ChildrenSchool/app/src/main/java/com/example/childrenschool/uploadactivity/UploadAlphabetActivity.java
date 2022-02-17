package com.example.childrenschool.uploadactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.childrenschool.R;
import com.example.childrenschool.model.Upload;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class UploadAlphabetActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQ = 1;

    private Button selectBtn, uploadBtn;
    private EditText fileName;
    private ImageView imgView;
    private TextView show;
    private Uri imageUri;
    private ProgressBar progressBar;

    private StorageReference firebaseStorage;
    private DatabaseReference firebaseDatabase;
    private StorageTask uploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_alphabet);


        initialize();

        firebaseDatabase = FirebaseDatabase.getInstance().getReference("uploads");
        firebaseStorage = FirebaseStorage.getInstance().getReference("uploads");

//        file selection button
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

//        upload file button
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                cheack already any fileuploading or not
                if (uploadTask != null && uploadTask.isInProgress()){
                    Toast.makeText(UploadAlphabetActivity.this, "Upload In Progress", Toast.LENGTH_SHORT).show();
                } else {
                    uploadFile();;
                }
            }
        });

//        image show button

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageActivity ();
            }
        });
    }

    //    all element initialization
    private void initialize() {
        selectBtn = findViewById(R.id.select_file);
        uploadBtn = findViewById(R.id.upload_btn);
        fileName = findViewById(R.id.file_name);
        imgView = findViewById(R.id.image_view);
        show = findViewById(R.id.show);
        progressBar = findViewById(R.id.progress_bar);
    }

    //    file open in local device
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQ && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();
            imgView.setImageURI(imageUri);
        }
    }

    //    get file extention
    private String getExtention (Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    //    upload file function
    private void uploadFile() {
        if (imageUri != null){
            StorageReference fileReference = firebaseStorage.child(System.currentTimeMillis() + "." + getExtention(imageUri));
            uploadTask = fileReference.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0);
                                }
                            }, 500);

                            Toast.makeText(UploadAlphabetActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            Upload upload = new Upload(fileName.getText().toString().trim(), taskSnapshot.getUploadSessionUri().toString());

                            String uploadId = firebaseDatabase.push().getKey();
                            firebaseDatabase.child(uploadId).setValue(upload);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(UploadAlphabetActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress = (100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            progressBar.setProgress((int) progress);
                        }
                    });
        } else {
            Toast.makeText(UploadAlphabetActivity.this, "No File Selected", Toast.LENGTH_SHORT).show();
        }
    }


    private void openImageActivity() {
        Intent intent = new Intent(UploadAlphabetActivity.this, ImageActivity.class);
        startActivity(intent);
    }
}

