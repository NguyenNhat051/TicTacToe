package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerSetup extends AppCompatActivity {

    public static final String PLAYERS_NAME = "PLAYERS_NAME";
    private EditText player1Name, player2Name;
    private Button btnSubmitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        initView();

        btnSubmitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(player1Name.getText().toString().isEmpty() || player2Name.getText().toString().isEmpty())) {
                    Intent intent = new Intent(PlayerSetup.this, GameDisplay.class);
                    intent.putExtra(PLAYERS_NAME, new String[]{player1Name.getText().toString(), player2Name.getText().toString()});
                    startActivity(intent);
                } else {
                    Toast.makeText(PlayerSetup.this, "Name can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        player1Name = findViewById(R.id.player1Name);
        player2Name = findViewById(R.id.player2Name);
        btnSubmitName = findViewById(R.id.submitBTN);
    }
}