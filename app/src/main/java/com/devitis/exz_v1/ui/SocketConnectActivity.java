package com.devitis.exz_v1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.devitis.exz_v1.R;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SocketConnectActivity extends AppCompatActivity {

    private static final String HOST = "";

    @BindView(R.id.message_text)
    TextView messageTextView;

    private WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        connectWebSocket();
    }

    private void connectWebSocket() {
        try {
            URI uri = new URI(HOST);
            webSocketClient = new WebSocketClient(uri) {

                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    webSocketClient.send("" + " " + "");

                }


                @Override
                public void onMessage(String s) {
                    final String message = s;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            messageTextView.setText(message);
                        }
                    });
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    Log.i("Websocket", "Connection Closed " + s);
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            };
            webSocketClient.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
    }

    @OnClick(R.id.connect)
    public void onConnectClick() {

        if (webSocketClient.getConnection().isOpen()) {
            messageTextView.setText("connect");
        } else connectWebSocket();
    }


    @OnClick(R.id.disconnect)
    public void onCloseClick() {

        if (webSocketClient.getConnection().isOpen()) {
            webSocketClient.close();
            messageTextView.setText("closing");
        } else messageTextView.setText("closed");
    }
}
