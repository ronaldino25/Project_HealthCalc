package com.dino.kalkes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editUmur, editTinggi, editBerat;
    private RadioGroup radioGenderGroup;
    private Button btnHitung;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editUmur = findViewById(R.id.inputAge);
        editTinggi = findViewById(R.id.inputHeight);
        editBerat = findViewById(R.id.inputWeight);
        radioGenderGroup = findViewById(R.id.genderGroup);
        btnHitung = findViewById(R.id.calculateButton);

        btnHitung.setOnClickListener(v -> {
            int selectedGenderId = radioGenderGroup.getCheckedRadioButtonId();

            if (selectedGenderId == -1) {
                // Jika tidak ada pilihan, tampilkan pesan
                Toast.makeText(MainActivity.this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show();
                return;
            }

            // Menggunakan ID untuk mendapatkan teks dari RadioButton yang dipilih
            RadioButton selectedGender = findViewById(selectedGenderId);
            String gender = selectedGender.getText().toString();

            String umur = editUmur.getText().toString();
            String tinggi = editTinggi.getText().toString();
            String berat = editBerat.getText().toString();

            Intent intent = new Intent(MainActivity.this, Hasil_penghitungan.class);
            intent.putExtra("umur", umur);
            intent.putExtra("tinggi", tinggi);
            intent.putExtra("berat", berat);
            intent.putExtra("gender", gender);
            startActivity(intent);
        });
    }

}