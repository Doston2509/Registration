package com.salom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.salom.idoston.salom.R;

import org.w3c.dom.Text;

public class ShowUser extends AppCompatActivity {

    private TextView name, surname, gender, email, password, subscribe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        name = (TextView)findViewById(R.id.show_name);
        surname = (TextView)findViewById(R.id.show_surname);
        gender = (TextView)findViewById(R.id.show_gender);
        email = (TextView)findViewById(R.id.show_email);
        password = (TextView)findViewById(R.id.show_password);
        subscribe = (TextView)findViewById(R.id.show_subscribe);

        Intent intent = getIntent();

        String _name = intent.getStringExtra("name");
        String _surname = intent.getStringExtra("surname");
        String _gender = intent.getStringExtra("gender");
        String _subscribe = intent.getStringExtra("subscribe");
        String _email = intent.getStringExtra("email");
        String _password = intent.getStringExtra("password");

        name.setText("User`s name: " + _name);
        surname.setText("User`s surname : " + _surname);
        gender.setText("Gender: " + _gender);
        subscribe.setText("Subscribed: " + _subscribe);
        email.setText("Email: " + _email);
        password.setText("Password: " + _password);


    }

    private void showDate(){

    }
}
