package com.example.camerashooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int port = 55555;
    EditText ipEditText;
    Button sendButton;
    Socket socket;
    DataOutputStream dos;

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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (socket == null) {
                            socket = new Socket("10.0.2.2", port);
                            dos = new DataOutputStream(socket.getOutputStream());
                        }
                        Log.v("AVI","after");
                        dos.writeUTF(ipEditText.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.v("AVI",e.getMessage());
                    }
                }
            }).start();

        }
    }

    public boolean isLegalIp(String ip) {

        return true;
    }
}
