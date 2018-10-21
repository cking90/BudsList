package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import edu.gatech.hackgt.budslist.models.Binding;
import edu.gatech.hackgt.budslist.models.Course;
import edu.gatech.hackgt.budslist.models.Department;
import edu.gatech.hackgt.budslist.models.Model;
import edu.gatech.hackgt.budslist.models.User;

public class HomeScreenActivity extends AppCompatActivity {

    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        model = Model.getInstance();
        initDefaultData();
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
        String[] names = {"Matt", "Saira", "Neha", "Charlie"};
        int number = 1234561234;
        for (String name : names) {
            String email = String.format("%s@gmail.com", name.toLowerCase());
            String password = name.toLowerCase();
            String phoneNumber = Integer.toString(number);
            model.addUser(email, password, name, phoneNumber);
            number += 23432;
        }

        Course[] courses = {new Course(Department.AE, Integer.toString(1000)),
                            new Course(Department.CS, Integer.toString(1301)),
                            new Course(Department.CS, Integer.toString(1332))};
        Map<String,User> userList = model.getUsers();
        model.addBook(courses[0], userList.get("neha@gmail.com"), "Planes are fun",
                "13.00", "ASBN3", "Billy Planesworth", Binding.HARD_COVER);
        model.addBook(courses[1], userList.get("neha@gmail.com"), "Intro to Computing",
                "65.00", "ASE23F", "Dr. McDaniel", Binding.HARD_COVER);
        model.addBook(courses[2], userList.get("neha@gmail.com"), "Intro to Data Structures",
                "80.00", "FGF3N3", "HB", Binding.PAPER_BACK);
    }
}
