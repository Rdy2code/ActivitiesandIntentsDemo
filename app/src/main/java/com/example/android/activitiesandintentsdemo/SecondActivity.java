package com.example.android.activitiesandintentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.activitiesandintentsdemo.extra.REPLY";

    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_second);

        Intent intentThatLaunchedThisActivity = getIntent();
        String messageSent = intentThatLaunchedThisActivity.getStringExtra(
                MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.received_message);
        textView.setText(messageSent);
    }

    public void returnReply(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, mReply.getText().toString());
        setResult(RESULT_OK, replyIntent); //result code and intent to return to originating activity
        finish();   //transmits ActivityResult back to originating activity via onActivityResult()
    }
}
