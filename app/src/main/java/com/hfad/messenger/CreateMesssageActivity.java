package com.hfad.messenger;

import android.content.ActivityNotFoundException;
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

        try {
            //Intent for inner activity ReceiveMessageActivity
            //Intent intent = new Intent(this, ReceiveMessageActivity.class);
            //intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messagetext);

            //Intent for others app which has action send
            Intent intent = new Intent(Intent.ACTION_SEND);

            //type data MIME text/plain
            intent.setType("text/plain");

            //output message
            intent.putExtra(Intent.EXTRA_TEXT, messagetext);

            //set string name chooser title
            String chooserTitle = getString(R.string.chooser);

            //output intent and title
            Intent chosenIntent = Intent.createChooser(intent, chooserTitle);

            //startActivity(intent);

            //run activity chosen user
            startActivity(chosenIntent);

        } catch (ActivityNotFoundException e) {}
    }
}
