package com.example.limayeneha.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.icu.lang.UCharacter.JoiningGroup.E;

public class EditItemActivity extends AppCompatActivity {

    EditText etEditItem;
    int positionOfItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String itemName = getIntent().getStringExtra("itemName");
        positionOfItem = getIntent().getIntExtra("positionOfItem", 0);
        setContentView(R.layout.activity_edit_item);

        etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(itemName);
        etEditItem.setSelection(etEditItem.getText().length());
        etEditItem.isFocusable();
        etEditItem.requestFocus();
    }

    public void onSaveItem(View view) {
        Intent data = new Intent();
        data.putExtra("editedItem", etEditItem.getText().toString());
        data.putExtra("positionOfItem", positionOfItem);
        setResult(RESULT_OK, data);
        finish();

    }
}
