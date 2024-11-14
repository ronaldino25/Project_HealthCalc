package com.dino.kalkes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Hasil_penghitungan extends AppCompatActivity {
    private TextView textHasil,textket,deskBobot;
    private ImageView imageHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hasil_penghitungan);

        textket = findViewById(R.id.ketbobot);
        textHasil = findViewById(R.id.bobot);
        deskBobot = findViewById(R.id.dekripsibobot);
        imageHasil = findViewById(R.id.gambarBadan);

        String tinggi = getIntent().getStringExtra("tinggi");
        String berat = getIntent().getStringExtra("berat");
        String gender = getIntent().getStringExtra("gender");
        double tinggiMeter = Double.parseDouble(tinggi) / 100;
        double beratKg = Double.parseDouble(berat);
        double bmi = beratKg / (tinggiMeter * tinggiMeter);

        if (bmi < 18.5) {
            textket.setText("Kurus");
            textHasil.setText(String.format("%.1f", bmi));
            deskBobot.setText("Anda kekurangan berat badan");
            if(gender.equals("Pria")){
                imageHasil.setImageResource(R.drawable.thinmen);
            }else{
                imageHasil.setImageResource(R.drawable.thingirl);
            }
        } else if (bmi < 25) {
            textket.setText("Normal");
            textHasil.setText(String.format("%.1f", bmi));
            deskBobot.setText("Anda memiliki berat badan ideal.\n" + "Good job!!");
            if(gender.equals("Pria")){
                imageHasil.setImageResource(R.drawable.fitmen);
            }else{
                imageHasil.setImageResource(R.drawable.fitgirl);
            }
        } else if (bmi < 30) {
            textket.setText("Gemuk");
            textHasil.setText(String.format("%.1f", bmi));
            deskBobot.setText("Anda berada dalam kategori obesitas");

            if(gender.equals("Pria")){
                imageHasil.setImageResource(R.drawable.fatman);
            }else{
                imageHasil.setImageResource(R.drawable.fatgirl);
            }
        }

    }
}