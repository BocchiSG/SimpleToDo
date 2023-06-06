package sg.edu.rp.c346.id22019575.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnClear, btnDelete;
    ListView lv;
    EditText etElement;
    ArrayAdapter aaTasks;
    Spinner spnAddRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextInput);
        btnAdd = findViewById(R.id.buttonAddItem);
        lv = findViewById(R.id.listView);
        btnClear = findViewById(R.id.btnClear);
        spnAddRemove = findViewById(R.id.spinner);
        btnDelete = findViewById(R.id.btnDelete);


        ArrayList<String> alTasks;
        alTasks = new ArrayList<String>();



        aaTasks = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTasks);
        lv.setAdapter(aaTasks);




        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTasks.clear();
                aaTasks.notifyDataSetChanged();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAddRemove.setAdapter(adapter);

        spnAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

                switch(position) {
                    case 0:
                        // Your code for item 1 selected
                        etElement.setHint("Type in a new task here");
                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View V) {
                                String inputElement = etElement.getText().toString();
                                alTasks.add(inputElement);

                                aaTasks.notifyDataSetChanged();
                            }
                        });

                        break;
                    case 1:
                        etElement.setHint("Type in the index of the task to be removed");
                        btnDelete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View V) {
                                String inputColor = etElement.getText().toString();
                                //alColours.add(inputColor);
                                int inputElement = Integer.parseInt(etElement.getText().toString());
                                alTasks.remove(inputElement);
                                aaTasks.notifyDataSetChanged();
                            }
                        });
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }


        });
    }
}