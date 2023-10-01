//=============================
//Name: Nicolaas Dyk
//Date: 09/21/23
//Desc: RGB Sliders using
//      seekbars and listviews
//=============================

package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.telephony.TelephonyCallback;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar sb_j_redBar;
    SeekBar sb_j_greenBar;
    SeekBar sb_j_blueBar;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hex;
    TextView tv_j_redText;
    TextView tv_j_greenText;
    TextView tv_j_blueText;
    TextView tv_j_hexText;
    TextView tv_j_title;
    Button btn_j_saveColor;
    ListView lv_j_colorList;
    //Stores the hex value as a string (no # symbol)
    String hexValue;
    //Stores the current color being held by the sliders
    ColorInfo curColor;
    ArrayList<ColorInfo> listOfColors;
    ColorListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connecting variables in main to the activity
        sb_j_redBar     = findViewById(R.id.sb_v_redBar);
        sb_j_greenBar   = findViewById(R.id.sb_v_greenBar);
        sb_j_blueBar    = findViewById(R.id.sb_v_blueBar);
        tv_j_red        = findViewById(R.id.tv_v_red);
        tv_j_green      = findViewById(R.id.tv_v_green);
        tv_j_blue       = findViewById(R.id.tv_v_blue);
        tv_j_hex        = findViewById(R.id.tv_v_hex);
        tv_j_redText    = findViewById(R.id.tv_v_redText);
        tv_j_greenText  = findViewById(R.id.tv_v_greenText);
        tv_j_blueText   = findViewById(R.id.tv_v_blueText);
        tv_j_hexText    = findViewById(R.id.tv_v_hexText);
        tv_j_title      = findViewById(R.id.tv_v_title);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_colorList  = findViewById(R.id.lv_v_colorList);

        tv_j_red.setText(sb_j_redBar.getProgress() + "");
        tv_j_green.setText(sb_j_greenBar.getProgress() + "");
        tv_j_blue.setText(sb_j_blueBar.getProgress() + "");

        //Creates an array to store all colors
        listOfColors = new ArrayList<ColorInfo>();

        //Creates the ListView as an empty ListView
        fillListView();

        //Create a curColor to keep track of future changes to the color
        curColor = new ColorInfo(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress());

        tv_j_hex.setText(curColor.getHex());

        //Set up all buttons and sliders
        addColorButtonEventHandler();
        setListViewEventHandler();
        redBarEventHandler();
        greenBarEventHandler();
        blueBarEventHandler();

    }

    public void redBarEventHandler()
    {
        sb_j_redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Set the red text to match the current value of the slider
                tv_j_red.setText(seekBar.getProgress() + "");
                updateColors();
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
                updateColors();
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
                updateColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //To be run after any number has changed, updates all current information
    public void updateColors()
    {
        buildColor();
        changeBackground();
        updateTextColors();
        tv_j_hex.setText(curColor.getHex());
    }

    //Creates the curColor based on the sliders
    public void buildColor()
    {
        curColor.setRed(Integer.parseInt(tv_j_red.getText().toString()));
        curColor.setBlue(Integer.parseInt(tv_j_blue.getText().toString()));
        curColor.setGreen(Integer.parseInt(tv_j_green.getText().toString()));
    }

    //Changes the color of the background to match the currently selected color
    public void changeBackground()
    {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor("#" + curColor.getHex()));
    }

    //Checks to see whether black or white should be used for onscreen text
    public void updateTextColors()
    {
        if (curColor.getRed() > 150 || curColor.getGreen() > 150 || curColor.getBlue() > 150)
        {
            setTextColor(true);
        }
        else
        {
            setTextColor(false);
        }
    }

    //Sets text colors to black or white based on input
    public void setTextColor(boolean BoW)
    {
        tv_j_title.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_redText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_greenText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_blueText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_red.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_green.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_blue.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_hexText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_hex.setTextColor(BoW ? Color.BLACK : Color.WHITE);
    }



    //Button Listener for adding new colors
    public void addColorButtonEventHandler()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Button Press","Save Color");

                addColor();
                adapter.notifyDataSetChanged();
            }
        });
    }

    //Adds a color to the list, creates a new color in curColor, and resets all sliders
    public void addColor()
    {
        listOfColors.add(curColor);

        curColor = new ColorInfo(255,255,255);

        setSliders(255,255,255);
    }

    //Sets sliders to the given values and alerts updateColors()
    public void setSliders(int r, int g, int b)
    {
        sb_j_redBar.setProgress(r);
        sb_j_greenBar.setProgress(g);
        sb_j_blueBar.setProgress(b);
        updateColors();
    }

    //Create the listview
    public void fillListView()
    {
        adapter = new ColorListAdapter(this,listOfColors);

        lv_j_colorList.setAdapter(adapter);
    }

    //Handles the user clicking cells on the ListView
    public void setListViewEventHandler()
    {
        lv_j_colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ColorInfo color = listOfColors.get(i);
                setSliders(color.getRed(),color.getGreen(),color.getBlue());
            }
        });
    }
}