package com.example.camerashooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int port = 5555;
    EditText ipEditText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        ipEditText = findViewById(R.id.get_ip);
        sendButton = findViewById(R.id.send);
        sendButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String ip = ipEditText.getText().toString();
        if (isLegalIp(ip)) {
            try {
                Socket socket = new Socket(ip, port);
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("hello");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isLegalIp(String ip){

        return true;
    }
}
