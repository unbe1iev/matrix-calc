package com.unbe1iev;

public class MatrixController {
    private Matrix matrixA, matrixB, matrixC;
    private Matrix selection;
    private final MatrixView view;

    public MatrixController() {
        this.view = new MatrixView();
    }

    public void setInputMatrices(Matrix matrixA, Matrix matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    public void transposeMatrix(char whichMatrix) {
        selection = selectMatrix(whichMatrix);

        int[][] transpose = new int[selection.getC()][selection.getR()];

        for (int i = 0; i < selection.getR(); ++i)
            for (int j = 0; j < selection.getC(); ++j) {
                transpose[j][i] = selection.getElement(i, j);
            }
        selection.set(transpose);
        selection.set(selection.getC(), selection.getR());
    }

    public Matrix selectMatrix(char whichMatrix) {
        switch (whichMatrix) {
            case 'A' -> selection = matrixA;
            case 'B' -> selection = matrixB;
            case 'C' -> selection = matrixC;
            default -> System.out.println("There is no matrix!");
        }
        return selection;
    }

    public void multiplayInputMatrices() {
            int[][] data = new int[matrixA.getR()][matrixB.getC()];

            for (int i = 0; i < matrixA.getR(); i++) {
                for (int j = 0; j < matrixB.getC(); j++) {
                    for (int k = 0; k < matrixB.getR(); k++)
                        data[i][j] += matrixA.getElement(i, k) * matrixB.getElement(k, j);
                }
            }
            matrixC = new Matrix(matrixA.getR(), matrixB.getC());
            matrixC.set(data);
    }

    public void displayMatrix(char whichMatrix) {
        selection = selectMatrix(whichMatrix);
        view.display(selection);
    }
}
