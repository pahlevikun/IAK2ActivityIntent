package com.waperr.linearlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPanjang, etLebar;
    private Button btHitung, btPindah;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPanjang = (EditText) findViewById(R.id.editTextPanjang);
        etLebar = (EditText) findViewById(R.id.editTextLebar);
        btHitung = (Button) findViewById(R.id.buttonHitung);
        btPindah = (Button) findViewById(R.id.buttonPindah);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        btHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String sPanjang = etPanjang.getText().toString().trim();
                String sLebar = etLebar.getText().toString().trim();

                if(sPanjang.isEmpty()||sLebar.isEmpty()){
                    Toast.makeText(MainActivity.this, "Isi dengan benar!", Toast.LENGTH_SHORT).show();
                }else {
                    double dPanjang = Double.parseDouble(sPanjang);
                    double dLebar = Double.parseDouble(sLebar);

                    double Hasil = dPanjang * dLebar;

                    tvHasil.setText("Hasilnya : " + new DecimalFormat("####.##").format(Hasil));
                    tvHasil.setVisibility(View.VISIBLE);
                }

            }
        });

        btPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PindahActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
