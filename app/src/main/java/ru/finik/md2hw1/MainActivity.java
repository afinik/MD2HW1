package ru.finik.md2hw1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button secondActivityIntentButton = findViewById(R.id.second_activity_intent_button);
        final Button exitButton = findViewById(R.id.exit_button);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.second_activity_intent_button:
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                        break;
                    case R.id.exit_button:
                        finish();
                }
            }
        };
        secondActivityIntentButton.setOnClickListener(onClickListener);
        exitButton.setOnClickListener(onClickListener);

    }
}
