package ru.finik.md2hw1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,43545);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 43545){
            ImageView imageView = findViewById(R.id.iv_image);
            if(resultCode == RESULT_OK){
                Uri uri = data.getData();
                Bitmap bitmap = null;


                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                    bitmap = Bitmap.createBitmap(bitmap,0,0,256,256);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(bitmap!=null){
                        imageView.setImageBitmap(bitmap);
                    }   else {
                        imageView.setImageURI(uri);
                    }
                }
                imageView.setImageURI(uri);
            }else {
                if (Locale.getDefault().getLanguage()== "ru"){
                    imageView.setImageResource(R.drawable.ru);
                }
                else {
                    imageView.setImageResource(R.drawable.en);
                }
                Toast.makeText(this,"image not choosed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
