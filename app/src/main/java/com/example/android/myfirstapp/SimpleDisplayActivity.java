package com.example.android.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleDisplayActivity extends AppCompatActivity {
    ArrayList<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView lvItems;
    EditText etText;
    private final int REQUEST_CODE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_display);

        populateArrayItems();
        lvItems = (ListView)findViewById(R.id.lvItems);
        lvItems.setAdapter(arrayAdapter);
        etText = (EditText) findViewById(R.id.etNewItem);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toDoList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SimpleDisplayActivity.this,EditItemActivity.class);
                intent.putExtra("text",toDoList.get(position));
                intent.putExtra("position",position);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    private void readItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir,"todo.txt");
        try {
            toDoList = new ArrayList<>(FileUtils.readLines(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir,"todo.txt");
        try {
           FileUtils.writeLines(file,toDoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateArrayItems() {
        toDoList = new ArrayList<>();
        readItems();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,toDoList);
    }


    public void onAddedItem(View view) {
        arrayAdapter.add(etText.getText().toString());
        etText.setText("");
        writeItems();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String name = data.getExtras().getString("name");
            int position = data.getExtras().getInt("position", 0);
            toDoList.set(position,name);
            arrayAdapter.notifyDataSetChanged();
            writeItems();
        }
    }
}
