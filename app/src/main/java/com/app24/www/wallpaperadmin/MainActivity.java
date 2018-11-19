package com.app24.www.wallpaperadmin;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int SELECT_IMAGE = 99;
    private Spinner categorySpinner;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categorySpinner=findViewById(R.id.category);
        getSpinner();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE){

        } else if (resultCode == Activity.RESULT_CANCELED)  {
            Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();
        }
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE);
    }
    private void getSpinner() {
        arrayAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,getResources().getTextArray(R.array.category));
        categorySpinner.setAdapter(arrayAdapter);
    }
    public void selectImg(View view) {
        openGallery();
    }
}
