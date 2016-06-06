package com.example.pawel.myapplication;

        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SendMsg extends AppCompatActivity {

    Button sendBtn;
    EditText msgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        msgText = (EditText) findViewById(R.id.msgTxt);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sending: " + msgText.getText(), Toast.LENGTH_SHORT).show();

                JSONObject post_dict = new JSONObject();

                try {
                    post_dict.put("message" , msgText.getText().toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (post_dict.length() > 0) {
                    new SendJsonDataToServer().execute(msgText.getText().toString());
                }

            }
        });
    }
}
