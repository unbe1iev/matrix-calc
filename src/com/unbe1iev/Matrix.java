package com.unbe1iev;

public class Matrix {
    private int r;
    private int c;
    private int [][] data;

    public Matrix(int r, int c){
        this.r = r;
        this.c = c;
    }

    public void set(int [][] data){
        this.data = data;
    }

    public void set(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return this.r;
    }

    public int getC() {
        return this.c;
    }

    public int getElement(int r, int c) {
        return this.data[r][c];
    }
}
