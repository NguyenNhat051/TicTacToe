package com.example.tictactoe;

import static com.example.tictactoe.PlayerSetup.PLAYERS_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private Button btnPlayAgain, btnHome;
    private BoardGame boardGame;
    private TextView playerTurn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);

        initView();

        String[] playerNames = getIntent().getStringArrayExtra(PLAYERS_NAME);
        boardGame.setUpGame(btnPlayAgain, btnHome, playerTurn, playerNames);

        btnPlayAgain.setVisibility(View.GONE);
        btnHome.setVisibility(View.GONE);

        playerTurn.setText(playerNames[0] + "'s Turn");

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameDisplay.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boardGame.resetGame();
                boardGame.invalidate();
            }
        });
    }

    private void initView() {
        btnHome = findViewById(R.id.homeButton);
        btnPlayAgain = findViewById(R.id.playAgainButton);
        playerTurn = findViewById(R.id.displayTurn);
        boardGame = findViewById(R.id.TicTacToeGameBoard);
    }
}