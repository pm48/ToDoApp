package com.example.android.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by prernamanaktala on 8/10/17.
 */

public class EditItemActivity extends AppCompatActivity {

    EditText etText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etText2 = (EditText) findViewById(R.id.editText2);
        etText2.setText(getIntent().getStringExtra("text"));
        etText2.setSelection(etText2.getText().length());
    }

    public void onSubmit(View view) {
        Intent data = new Intent();
        data.putExtra("name", etText2.getText().toString());
        data.putExtra("position", getIntent().getIntExtra("position",0));
        setResult(RESULT_OK,data);
        finish();
    }
}