package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import edu.gatech.hackgt.budslist.models.Binding;
import edu.gatech.hackgt.budslist.models.Department;

public class CreateListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing);

        Spinner department = (Spinner)findViewById(R.id.spinner_department_id);
        department.setAdapter(new ArrayAdapter<Department>(this, android.R.layout.simple_spinner_item, Department.values()));
        Spinner binding = (Spinner)findViewById(R.id.spinner_binding_id);
        binding.setAdapter(new ArrayAdapter<Binding>(this, android.R.layout.simple_spinner_item, Binding.values()));
    }

    public void onClickMakeListing(View view) {
        EditText isbn_box = (EditText)findViewById(R.id.editText_isbn_id);
        String isbn = isbn_box.getText().toString();
        EditText price_box = (EditText)findViewById(R.id.editText_price_id);
        String price = price_box.getText().toString();

        Spinner binding = (Spinner)findViewById(R.id.spinner_binding_id);
        String selected_binding = binding.getSelectedItem().toString();
        Spinner department = (Spinner)findViewById(R.id.spinner_department_id);
        String selected_department = department.getSelectedItem().toString();

        EditText num_box = (EditText)findViewById(R.id.editText_courseNum_id);
        String course_num = num_box.getText().toString();

        Intent intent = new Intent(this, MyListingsActivity.class);
        startActivity(intent);
    }
}
