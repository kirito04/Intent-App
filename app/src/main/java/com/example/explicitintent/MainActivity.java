package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnact2, btnact3;
    TextView result;
    final int Activity3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnact2 = findViewById(R.id.btnact2);
        btnact3 = findViewById(R.id.btnact3);
        result = findViewById(R.id.result);

        btnact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else {
                    String name = etName.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,
                            com.example.explicitintent.Activity2.class);
                    intent.putExtra("fname", name);
                    startActivity(intent);
                }
            }
        });

        btnact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.explicitintent.Activity3.class);
                startActivityForResult(intent, Activity3);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        etName = findViewById(R.id.etName);

        if(requestCode == Activity3) {
            if(resultCode == RESULT_OK) {
                result.setText(etName.getText().toString().trim() + " " + data.getStringExtra("sname"));
            }
            if(resultCode == RESULT_CANCELED) {
                result.setText("No data received");
            }
        }

    }
}