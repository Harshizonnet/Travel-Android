package com.example.admin2;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class datauplod extends AppCompatActivity {
    Button btnUpload;
    EditText txtHotelName, txtPrice, txtAbout,txtLocation;




    private ImageView mImageView;

    private Uri mImageUri;
    private DatabaseReference mDatabaseRef;
    private StorageReference mStorageRef;

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datauplod);


        btnUpload = findViewById(R.id.button3);
        txtHotelName = findViewById(R.id.editTextText);
        txtPrice = findViewById(R.id.editTextText2);
        txtAbout = findViewById(R.id.editTextText3);
        txtLocation=findViewById(R.id.editTextText5);
        mImageView=findViewById(R.id.imageView2);




        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker = new Intent(Intent.ACTION_GET_CONTENT);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });



        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageUri != null) {
//                    String fileName = mEditTextFileName.getText().toString().trim();

//                    if (fileName.isEmpty()) {
//                        Toast.makeText(this, "Please enter a file name", Toast.LENGTH_SHORT).show();
//                        return;
//                    }


                    StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));
                    fileReference.putFile(mImageUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Dataclass upload = new Dataclass();
                                            String uploadId = mDatabaseRef.push().getKey();
                                            upload.setName(txtHotelName.getText().toString());
                                            upload.setPrice(txtPrice.getText().toString());
                                            upload.setAbout(txtAbout.getText().toString());
                                            upload.setLocation(txtLocation.getText().toString());
                                            upload.setImageUrl(uri.toString());
                                            mDatabaseRef.child(uploadId).setValue(upload);
                                            Toast.makeText(getApplicationContext(), "Upload successful", Toast.LENGTH_SHORT).show();

                                        }
                                    });
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            })
                            .addOnProgressListener(new com.google.firebase.storage.OnProgressListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                                    double progress = (100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());

                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "No file selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        mImageUri = ((Intent) data).getData();
                        mImageView.setImageURI(mImageUri);
                    } else {
                        Toast.makeText(getApplicationContext(), "No image selected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
}