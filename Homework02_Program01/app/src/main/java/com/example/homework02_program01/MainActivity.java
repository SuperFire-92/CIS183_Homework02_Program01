package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar sb_j_redBar;
    SeekBar sb_j_greenBar;
    SeekBar sb_j_blueBar;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hex;
    ListView lv_j_colorList;
    String hexValue;
    ColorInfo curColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connecting variables in main to the activity
        sb_j_redBar    = findViewById(R.id.sb_v_redBar);
        sb_j_greenBar  = findViewById(R.id.sb_v_greenBar);
        sb_j_blueBar   = findViewById(R.id.sb_v_blueBar);
        tv_j_red       = findViewById(R.id.tv_v_red);
        tv_j_green     = findViewById(R.id.tv_v_green);
        tv_j_blue      = findViewById(R.id.tv_v_blue);
        tv_j_hex       = findViewById(R.id.tv_v_hex);
        lv_j_colorList = findViewById(R.id.lv_v_colorList);

        tv_j_red.setText(sb_j_redBar.getProgress() + "");
        tv_j_green.setText(sb_j_greenBar.getProgress() + "");
        tv_j_blue.setText(sb_j_blueBar.getProgress() + "");

        redBarEventHandler();
        greenBarEventHandler();
        blueBarEventHandler();
        convertToHex();
        tv_j_hex.setText(hexValue);
        curColor = new ColorInfo(255, 255, 255, hexValue);
    }

    public void redBarEventHandler()
    {
        sb_j_redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Set the red text to match the current value of the slider
                tv_j_red.setText(seekBar.getProgress() + "");
                convertToHex();
                tv_j_hex.setText(hexValue);
                buildColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void greenBarEventHandler()
    {
        sb_j_greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Set the green text to match the current value of the slider
                tv_j_green.setText(seekBar.getProgress() + "");
                convertToHex();
                tv_j_hex.setText(hexValue);
                buildColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void blueBarEventHandler()
    {
        sb_j_blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Set the blue text to match the current value of the slider
                tv_j_blue.setText(seekBar.getProgress() + "");
                convertToHex();
                tv_j_hex.setText(hexValue);
                buildColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void changeBackground()
    {
        
    }
    public void buildColor()
    {
        curColor.setRed(Integer.parseInt(tv_j_red.getText().toString()));
        curColor.setBlue(Integer.parseInt(tv_j_blue.getText().toString()));
        curColor.setGreen(Integer.parseInt(tv_j_green.getText().toString()));
        curColor.setHex(hexValue);
    }

    public void convertToHex()
    {
        String curHex = "";
        char firstS, secondS;
        int col, first, second;
        //Taking each color, and converting it into hex
        col = Integer.parseInt(tv_j_red.getText().toString());
        //Separate col into two integers
        first = col/16;
        second = col - (first*16);
        //Turn both into a hex symbol
        firstS = convert(first);
        secondS = convert(second);
        curHex = curHex + firstS + secondS;

        //Repeat for green
        col = Integer.parseInt(tv_j_green.getText().toString());
        first = col/16;
        second = col - (first*16);
        firstS = convert(first);
        secondS = convert(second);
        curHex = curHex + firstS + secondS;

        //repeat for blue
        col = Integer.parseInt(tv_j_blue.getText().toString());
        first = col/16;
        second = col - (first*16);
        firstS = convert(first);
        secondS = convert(second);
        curHex = curHex + firstS + secondS;

        hexValue = curHex;
    }
    public char convert(int n)
    {
        if (n == 10)
        {
            return 'A';
        }
        else if (n == 11)
        {
            return 'B';
        }
        else if (n == 12)
        {
            return 'C';
        }
        else if (n == 13)
        {
            return 'D';
        }
        else if (n == 14)
        {
            return 'E';
        }
        else if (n == 15)
        {
            return 'F';
        }
        return (char)(n+'0');
    }
}