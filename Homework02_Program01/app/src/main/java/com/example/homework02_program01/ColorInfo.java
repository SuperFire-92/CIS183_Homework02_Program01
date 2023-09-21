package com.example.homework02_program01;

public class ColorInfo
{
    private int red;
    private int green;
    private int blue;
    private String hex;

    public ColorInfo(int r, int g, int b, String h)
    {
        red = r;
        green = g;
        blue = b;
        hex = h;
    }
    public int getRed() {
        return red;
    }

    public void setRed(int r) {
        this.red = r;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int g) {
        this.green = g;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int b) {
        this.blue = b;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String h) {
        this.hex = h;
    }



}
