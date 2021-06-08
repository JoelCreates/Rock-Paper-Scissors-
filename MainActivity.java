//Main Activity
package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    MediaPlayer mainmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        mainmusic = new MediaPlayer( );
        mainmusic = MediaPlayer.create(this, R.raw.start_music);
        mainmusic.start();
        mainmusic.setLooping(true);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mainmusic.stop();
                startActivity(new Intent(MainActivity.this, MainMenu.class));
            }
        });
    }
}
