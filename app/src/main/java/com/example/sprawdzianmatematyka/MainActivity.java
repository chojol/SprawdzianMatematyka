package com.example.sprawdzianmatematyka;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        Button button = findViewById(R.id.buttonOblicz);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(findViewById(R.id.editTextA).toString());
                int B = Integer.parseInt(findViewById(R.id.editTextB).toString());
                int C = Integer.parseInt(findViewById(R.id.editTextC).toString());

                EditText wynik = findViewById(R.id.editTextWynik);
                double delta = 1;
                delta = (double) (B*B) - 4 * A * C;
                double x1 = B + Math.sqrt(delta) / 2*A;

                wynik.setText(String.format("%d", x1));

                if (delta >0){
                    double x = (-B -Math.sqrt(delta)) / (2*A);
                } else if (delta == 0 ) {
                    Toast.makeText(getBaseContext(), "brak rozwiązań",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}