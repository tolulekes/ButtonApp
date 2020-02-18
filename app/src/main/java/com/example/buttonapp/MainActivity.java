package com.example.buttonapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENT = "TextContents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        userInput.setText("");

        textView.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString();
                result += "\n";
                textView.append(result);
                userInput.setText("");
            }
        };
        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        textView.setText(TEXT_CONTENT);
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        //String savedString = savedInstanceState.getString(TEXT_CONTENT);
        textView.setText(savedInstanceState.getString(TEXT_CONTENT));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        textView.setText(TEXT_CONTENT);
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENT, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        textView.setText(TEXT_CONTENT);
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        textView.setText(TEXT_CONTENT);
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        textView.setText(TEXT_CONTENT);
        Log.d(TAG, "onStop: out");
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState, persistentState);
        textView.setText(TEXT_CONTENT);
        Log.d(TAG, "onCreate: out");
    }
}
