package com.unbe1iev;

import static java.lang.System.out;

public class MatrixView {
    public void display(Matrix matrix){
        for (int i=0; i< matrix.getR(); i++){
            out.print("|\t");
            for(int j=0; j< matrix.getC(); j++){
                out.print(matrix.getElement(i, j)+"\t");
            }
            out.println("|");
        }
        out.println();
    }
}
