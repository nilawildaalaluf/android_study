package com.example.irobot.webhoozz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private TextView btn_register;
    private EditText edit_email, edit_password;
    String email, password;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.login_button);
        btn_register =(TextView) findViewById(R.id.register_button);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_password = (EditText)  findViewById(R.id.edit_password);


        preferences = getSharedPreferences("data", Context.MODE_PRIVATE);

        if (preferences.getString("email", null) != null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
         clickLogin();




        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register);
            }
        });
    }

    private void clickLogin() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edit_email.getText().toString();
                password = edit_password.getText().toString();

                if (email.equals("") && password.equals("")){
                    Toast.makeText(LoginActivity.this, "Please insert Email and Password", Toast.LENGTH_LONG).show();
                }else {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email", email);
                    editor.commit();

                    Intent main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(main);

                    finish();
                }


            }
        });
    }
}
