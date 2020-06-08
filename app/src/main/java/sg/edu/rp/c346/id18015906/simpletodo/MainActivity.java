package sg.edu.rp.c346.id18015906.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonAdd;
    Button buttonClear;
    ListView listView;

    ArrayList<String> ALTasks;
    ArrayAdapter<String> AATasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        listView = findViewById(R.id.ListViewTasks);

        ALTasks = new ArrayList<>();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editText.getText().toString();
                ALTasks.add(newTask);
                AATasks.notifyDataSetChanged();
            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ALTasks.clear();
                AATasks.notifyDataSetChanged();
            }
        });

        AATasks = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ALTasks );
        listView.setAdapter(AATasks);

    }
}
