package com.example.homework02_program01;

public class ColorInfo
{
    private int red;
    private int green;
    private int blue;
    private String hex;

    public ColorInfo(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
        setHex();
    }
    public int getRed() {
        return red;
    }

    public void setRed(int r) {
        this.red = r;
        setHex();
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int g) {
        this.green = g;
        setHex();
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int b) {
        this.blue = b;
        setHex();
    }

    public String getHex() {
        return hex;
    }

    //Hex is updated automatically rather than being update outside of this class
    private void setHex()
    {
        //Instead of letting the user set the hex, it sets automatically based on the rgb values
        String curHex = "";
        char firstS, secondS;
        int first, second;

        //Separate the color into two integers
        first = red/16;
        second = red - (first*16);
        //Turn both into a hex symbol
        firstS = convert(first);
        secondS = convert(second);
        //Put it into the curHex string
        curHex = curHex + firstS + secondS;

        //Separate the color into two integers
        first = green/16;
        second = green - (first*16);
        //Turn both into a hex symbol
        firstS = convert(first);
        secondS = convert(second);
        //Put it into the curHex string
        curHex = curHex + firstS + secondS;

        //Separate the color into two integers
        first = blue/16;
        second = blue - (first*16);
        //Turn both into a hex symbol
        firstS = convert(first);
        secondS = convert(second);
        //Put it into the curHex string
        curHex = curHex + firstS + secondS;

        //Set hex to be the newly created curHex string
        hex = curHex;
    }

    //Converts numbers into their proper hex form
    private char convert(int n)
    {
        if (n >= 10)
        {
            return (char) ('A' + n - 10);
        }

        return (char)(n+'0');
    }

}
