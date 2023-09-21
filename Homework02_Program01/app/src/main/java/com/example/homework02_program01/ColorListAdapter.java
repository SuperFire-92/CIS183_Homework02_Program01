package com.example.homework02_program01;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

//Adapter to manage the lv_v_colorList object in activity_main.xml

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }

    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
        {
            //Find the cell
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell,null);
        }
        //Get the references in the custom_cell.xml
        TextView tv_j_customCell_redText = view.findViewById(R.id.tv_v_customCell_redText);
        TextView tv_j_customCell_greenText = view.findViewById(R.id.tv_v_customCell_greenText);
        TextView tv_j_customCell_blueText = view.findViewById(R.id.tv_v_customCell_blueText);
        TextView tv_j_customCell_hexText = view.findViewById(R.id.tv_v_customCell_hexText);
        TextView tv_j_customCell_red = view.findViewById(R.id.tv_v_customCell_red);
        TextView tv_j_customCell_green = view.findViewById(R.id.tv_v_customCell_green);
        TextView tv_j_customCell_blue = view.findViewById(R.id.tv_v_customCell_blue);
        TextView tv_j_customCell_hex = view.findViewById(R.id.tv_v_customCell_hex);

        //Get the newest color
        ColorInfo color = listOfColors.get(i);

        //create the layout for the new cell
        //First, decide the color of the text based on the color of the background
        boolean BoW;
        if (color.getRed() > 150 || color.getGreen() > 150 || color.getBlue() > 150)
        {
            BoW = true;
        }
        else
        {
            BoW = false;
        }
        //Next, scroll through each TextView and set it's color to black or white
        tv_j_customCell_redText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_customCell_greenText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_customCell_blueText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_customCell_hexText.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_customCell_red.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_customCell_green.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_customCell_blue.setTextColor(BoW ? Color.BLACK : Color.WHITE);
        tv_j_customCell_hex.setTextColor(BoW ? Color.BLACK : Color.WHITE);

        //Now we set the RGB numbers to match what's in the given color
        tv_j_customCell_red.setText(String.valueOf(color.getRed()));
        tv_j_customCell_green.setText(String.valueOf(color.getGreen()));
        tv_j_customCell_blue.setText(String.valueOf(color.getBlue()));
        tv_j_customCell_hex.setText(color.getHex());

        //Now we set the background to the custom color
        view.setBackgroundColor(Color.parseColor("#" + color.getHex()));

        //Finally, we return the view
        return view;
    }
}
