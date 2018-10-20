package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.gatech.hackgt.budslist.models.Model;

public class RegistrationActivity extends AppCompatActivity {

    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        model = Model.getInstance();

    }
    public void onClickRegister(View view) {

        EditText name_box = (EditText)findViewById(R.id.editText_name_id);
        String name = name_box.getText().toString();
        EditText email_box = (EditText)findViewById(R.id.editText_email_id);
        String email = email_box.getText().toString();
        EditText pwd_box = (EditText) findViewById(R.id.editText_password_id);
        String password = pwd_box.getText().toString();
        EditText phn_box = (EditText)findViewById(R.id.editText_phone_id);
        String phoneNum = phn_box.getText().toString();

        model.addUser(email, password, name, phoneNum);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
