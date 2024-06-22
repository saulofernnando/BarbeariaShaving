package com.example.barbeariashaving;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinnerScreens = findViewById(R.id.spinnerSelectScreen);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.screensOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerScreens.setAdapter(adapter);

        spinnerScreens.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("SELECT", position+" "+id);

                if(position == 1) {
                    final Intent intent = new Intent(MainActivity.this, CheckoutActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Spinner spinnerScreens = findViewById(R.id.spinnerSelectScreen);
        spinnerScreens.setSelection(0);
    }

    public void buttonLoginCLick(View view) {
        Toast.makeText(getApplicationContext(), "Realizar Login", Toast.LENGTH_SHORT).show();
    }

    public void buttoncriarContaCLick(View view) {
        Toast.makeText(getApplicationContext(), "Criar Conta", Toast.LENGTH_SHORT).show();
    }
}