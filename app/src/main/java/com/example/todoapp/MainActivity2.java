package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layoutList;
    Button buttonAdd;
    Button buttonSubmitList;
    ArrayList<String> todo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonSubmitList = findViewById(R.id.b2);
        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);

        buttonAdd.setOnClickListener(this);
        buttonSubmitList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_add:

                addView();

                break;

            case R.id.b2:
                if(checkIfValidAndRead()){
                    Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                    intent.putExtra("todo",todo);
                    startActivity(intent);
                }
        }
    }

    private boolean checkIfValidAndRead(){
        boolean result = true;
        for (int i=0;i<layoutList.getChildCount();i++)
        {
            View view = layoutList.getChildAt(i);
            EditText e = (EditText)view.findViewById(R.id.edit_name);

            if(e.getText().toString().isEmpty())
            {
                result = false;
                break;
            }

            todo.add(e.getText().toString());

        }
        if(!result) {
            Toast.makeText(this, "Enter All Details Correctly!", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    private void addView() {

        final View view = getLayoutInflater().inflate(R.layout.row,null,false);

        EditText editText = (EditText)view.findViewById(R.id.edit_name);
        ImageView imageClose = (ImageView)view.findViewById(R.id.image_remove);


        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(view);
            }
        });

        layoutList.addView(view);

    }

    private void removeView(View view){

        layoutList.removeView(view);

    }
}
