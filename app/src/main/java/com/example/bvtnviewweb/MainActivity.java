package com.example.bvtnviewweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtA ;
    Button btnSave;

    public  static  final  String SHARED_PREFS = "sharedPrefs";
    private static final  String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ View
        edtA = (EditText) findViewById(R.id.url);
        btnSave = (Button) findViewById(R.id.btn_save);
        edtA.setText(getSharedPreferences(SHARED_PREFS,MODE_PRIVATE).getString(TEXT,""));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String data =  edtA.getText().toString();

                 SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                 SharedPreferences.Editor editor = sharedPreferences.edit();

                 editor.putString(TEXT,data);

                 editor.apply();

                 Toast.makeText(MainActivity.this,"Done ",Toast.LENGTH_SHORT);

//                 UrlModel.murl = data;

                 Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                 startActivity(intent);
            }
        });
    }
}