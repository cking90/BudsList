package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.time.LocalDate;

import edu.gatech.hackgt.budslist.models.Model;

public class HomeScreenActivity extends AppCompatActivity {

    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        model = Model.getInstance();
    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void initDefaultData() {
        String[] names = {"Matt", "Saira", "Neha", "Neha"};
        for (String name : names) {
            String email = String.format("%s@gmail.com", name);
            String password = name.toLowerCase();
//            model.addUser("");
        }
    }
}
