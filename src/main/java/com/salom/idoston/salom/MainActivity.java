package com.salom.idoston.salom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.salom.ShowUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText name, surname, email, password;
    private Button signup;
    private RadioGroup radio_g;
    private RadioButton gender;
    private CheckBox subscribe;
    private TextView readTerms;
    private String sname, slastname, spassword, semail, sgender;
    private String checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        name = (EditText)findViewById(R.id.edit_name);
        surname = (EditText)findViewById(R.id.edit_surname);
        email = (EditText)findViewById(R.id.edit_email);
        password = (EditText)findViewById(R.id.edit_password);
        signup = (Button)findViewById(R.id.signup);
        readTerms = (TextView)findViewById(R.id.readPrivecy);
        subscribe = (CheckBox)findViewById(R.id.subscribe);
        radio_g = (RadioGroup)findViewById(R.id.radio_g);

        readTerms.setClickable(true);
        SignupNewUser();


    }

    private void SignupNewUser(){
        signup.setOnClickListener(
            new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    sname = name.getText().toString();
                    slastname = surname.getText().toString();
                    semail = email.getText().toString();
                    spassword = password.getText().toString();

                    int selected_gender_id = radio_g.getCheckedRadioButtonId();
                    gender = (RadioButton)findViewById(selected_gender_id);
                    sgender = gender.getText().toString();

                    if (subscribe.isChecked() == true){
                        checked = "True";
                    } else {
                        checked = "False";
                    }

                    Intent intent = new Intent(MainActivity.this, ShowUser.class);

                    intent.putExtra("name", sname);
                    intent.putExtra("surname", slastname);
                    intent.putExtra("gender", sgender);
                    intent.putExtra("password", spassword);
                    intent.putExtra("email", semail);
                    intent.putExtra("subscribe", checked);

                    startActivity(intent);
                }
            }
        );

        readTerms.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Privacy and terms of android from google", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this, Privacy.class);

                        startActivity(intent2);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
