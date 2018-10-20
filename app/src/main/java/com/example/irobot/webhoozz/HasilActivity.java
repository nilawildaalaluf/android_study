package com.example.irobot.webhoozz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    private TextView hasil_penambahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        hasil_penambahan = (TextView) findViewById(R.id.hasil_activity);

        Bundle hasil = getIntent().getExtras();
        String stringVariableName = hasil.getString("dataHasil");
        int intVariableName = Integer.parseInt(stringVariableName);

        hasil_penambahan.setText("" + intVariableName);
    }
}
