package com.hfad.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.annotation.Target;

public class CreateMesssageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_messsage);
    }

    //onClick method send message
    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messagetext = messageView.getText().toString();

        //Intent for inner activity ReceiveMessageActivity
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messagetext);

        startActivity(intent);
    }
}
