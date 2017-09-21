package com.ajbinky.lifecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnPlus;
    private Button btnMinus;
    private Button btnReset;
    private TextView lblLife;
    private ProgressBar pbLife;
    private int life = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnReset = (Button) findViewById(R.id.btnReset);
        lblLife = (TextView) findViewById(R.id.lblLife);
        pbLife = (ProgressBar) findViewById(R.id.pbLife);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                life++;
                pbLife.setSecondaryProgress(Math.min(life, 20));
                pbLife.setProgress(Math.max(0, life-20));
                lblLife.setText("" + life);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                life = Math.max(--life, 0);
                pbLife.setSecondaryProgress(life);
                pbLife.setProgress(Math.max(0, life-20));
                lblLife.setText("" + life);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                life = 20;
                pbLife.setSecondaryProgress(Math.max(life, 0));
                pbLife.setProgress(0);
                lblLife.setText("" + life);
                Toast.makeText(MainActivity.this, "Reset to 20", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
