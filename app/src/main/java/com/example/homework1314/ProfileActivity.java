package com.example.homework1314;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homework1314.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonImage.setOnClickListener(this);
        Intent intent = getIntent();
        binding.text.setText("Добро пожаловать, "+intent.getStringExtra("LoginText"));
    }
    public static final int OPEN_DOCUMENT_REQUEST_CODE = 2;
    public static final int MAKE_PHOTO_REQUEST=3;
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.button_image:
                Log.v("IMAGE FINDER","Find Image");
                intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,MAKE_PHOTO_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MAKE_PHOTO_REQUEST && resultCode==RESULT_OK){
            Log.v("GET PHOTO","I GOT PHOTO");
            Bundle extra = data.getExtras();
            Bitmap photo=(Bitmap) extra.get("data");
            binding.image.setImageBitmap(photo);
        }
        else{
            Log.wtf("WTF","NO NULL HERE");
        }
    }
}
