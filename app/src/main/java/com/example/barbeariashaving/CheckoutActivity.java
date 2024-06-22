package com.example.barbeariashaving;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
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

                if(position == 0) {
                    final Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
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
        spinnerScreens.setSelection(1);
    }

    public void backButtonClick(View view) {
        finish();
    }

    public void homeButtonClick(View view) {
        goHomeActivity();
        finish();
    }

    public void fazerPedidoButtonCLick(View view) {
        ProgressDialog progress = new ProgressDialog(this);

        progress.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Pedido realizado com sucesso!", Toast.LENGTH_SHORT).show();
                progress.dismiss();
                goHomeActivity();
                finish();
            }
        },1000*3);

    }

    private void goHomeActivity() {
        final Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
        startActivity(intent);
    }
}