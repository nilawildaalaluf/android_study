package com.example.irobot.webhoozz;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout1, layout2, layout3, layout4;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = (LinearLayout) findViewById(R.id.layoutKalkulator);
        layout2 = (LinearLayout) findViewById(R.id.layoutCall);
        layout3 = (LinearLayout) findViewById(R.id.layoutCamera);
        layout4 = (LinearLayout) findViewById(R.id.layoutDialog);

        actionClick();




    }

    private void actionClick() {
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainKalkulator.class);
                startActivity(i);
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:085231849842"));
            startActivity(call);
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (camera.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(camera,REQUEST_IMAGE_CAPTURE);
                }
            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Are you sure,You wanted to make decision");
                    alert.setPositiveButton("yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Toast.makeText(MainActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                                }
                            });

                alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.show();
//                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(login);
            }
        });
    }


}
