package com.example.tabucuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class login extends AppCompatActivity {

    public EditText edittxt,edittxt2;
    public Button oynabtn;
    public static final String EXTRA_TEXT = "abc";
    public static final String EXTRA_TEXT2 = "abcd";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edittxt = findViewById(R.id.edittxt);
        edittxt2 = findViewById(R.id.edittxt2);
        oynabtn = findViewById(R.id.oynabtn);


        textView = findViewById(R.id.textview);

        edittxt.addTextChangedListener(loginTextWatcher);
        edittxt2.addTextChangedListener(loginTextWatcher);


        oynabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,MainActivity.class);


                String text = edittxt.getText().toString();
                String text2 = edittxt2.getText().toString();
                intent.putExtra(EXTRA_TEXT,text);
                intent.putExtra(EXTRA_TEXT2,text2);

                startActivity(intent);


            }
        });


    }

    //Disable Button

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


            String userNameInput = edittxt.getText().toString().trim();
            String userName2Input = edittxt2.getText().toString().trim();

            oynabtn.setEnabled(!userNameInput.isEmpty() && !userName2Input.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };






}
