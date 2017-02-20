package com.example.hppc.textinjectiondemo;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.btnAdd);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                if (edit.getText().toString().contains("Android")) {
                    list.add(edit.getText().toString().replace("Android", "Hacked :)"));
                    //
                } else if (edit.getText().toString().contains("android")) {
                    list.add(edit.getText().toString().replace("android", "hacked :)"));
                    //list.add(edit.getText().toString());
                } else
                    list.add(edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
            }
        };
        addBtn.setOnClickListener(listener);
        setListAdapter(adapter);
    }
}
