package com.example.irobot.webhoozz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainKalkulator extends AppCompatActivity{
    private Button button_tambah;
    private EditText edit_angka1, edit_angka2;
    private TextView text_hasil;
    Integer angka1, angka2, hasil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        button_tambah = (Button) findViewById(R.id.button_tambah);
        edit_angka1 = (EditText) findViewById(R.id.edit_angka1);
        edit_angka2 = (EditText) findViewById(R.id.edit_angka2);
        text_hasil = (TextView) findViewById(R.id.text_hasil);

        button_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasilTambah();
            }
        });
    }
    private void hasilTambah() {
        angka1 = Integer.parseInt(edit_angka1.getText().toString());
        angka2 = Integer.parseInt(edit_angka2.getText().toString());

        hasil = angka1+angka2;

        text_hasil.setText("Hasil : " + String.valueOf(hasil));

    }
}
