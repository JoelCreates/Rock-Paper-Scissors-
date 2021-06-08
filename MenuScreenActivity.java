//Menu Screen
package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.rockpaperscissors.R.id.inputNumber;
import static com.example.rockpaperscissors.R.id.tutorialButton;

public class MainMenu extends AppCompatActivity {

    Button tutorialButton, playGameButton, beginButton;
    TextView textView2;
    Dialog tutorial_popup, input_score;
    MediaPlayer menu_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tutorial_popup = new Dialog(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_menu);
        //Instantiation
        playGameButton = findViewById(R.id.playGameButton);
        tutorialButton = findViewById(R.id.tutorialButton);
        tutorial_popup = new Dialog(this);
        input_score = new Dialog(this);
        menu_music = new MediaPlayer( );
        menu_music = MediaPlayer.create(this, R.raw.menu_music);
        menu_music.start();
        menu_music.setLooping(true);
        playGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorial_popup.setContentView(R.layout.tutorial_popup);
                tutorial_popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                tutorial_popup.show();

            }
        });

    }

    private void openDialog() {
        input_score = new Dialog(this);
        input_score.setContentView(R.layout.input_score);
        input_score.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        textView2 = input_score.findViewById(R.id.textView2);
        input_score.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                final EditText inputNumber = input_score.findViewById(R.id.inputNumber);
                beginButton = input_score.findViewById(R.id.beginButton);
                beginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (inputNumber.getText().toString().trim().isEmpty() || Integer.parseInt(inputNumber.getText().toString().trim()) <= 0 || Integer.parseInt(inputNumber.getText().toString().trim()) > 900) {
                            textView2.setText("Please do not leave the field empty, input a value between 1 and 900");
                        } else {
                            Intent intent = new Intent(getBaseContext(), MainGame.class);
                            intent.putExtra("Score", inputNumber.getText().toString().trim());
                            startActivity(intent);
                            menu_music.stop();
                            //startActivity(new Intent(MainMenu.this, MainGame.class));
                        }

                    }

                });

            }

        });
        input_score.show();


    }
}
