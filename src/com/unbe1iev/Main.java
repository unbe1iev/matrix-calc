package com.unbe1iev;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        int m, k;
        int operation1, operation2;
        Matrix A, B;

        MatrixController controller = new MatrixController();

        Scanner scanner = new Scanner(System.in);

        do {
            out.println(":Menu:");
            out.println(" - - - - - - - - - - - - - - - -");
            out.println("(1) Enter the input matrices");
            out.println("(2) Arithmetic operations");
            out.println("(3) Display matrices");
            out.println("(4) Exit the program");
            out.println(" - - - - - - - - - - - - - - - -\n");

            out.print("Operation: ");
            operation1 = scanner.nextInt();

            switch (operation1) {
                case 1:
                    out.print("m: ");
                    m = scanner.nextInt();
                    out.print("k: ");
                    k = scanner.nextInt();

                    out.println("Input values to matrix A: ");
                    A = fillMatrix(m, k, scanner);

                    out.println("Input values to matrix B: ");
                    B = fillMatrix(k, m, scanner);

                    controller.setInputMatrices(A, B);
                    break;
                case 2:
                    out.println("(1) Transpose input matrices");
                    out.println("(2) Multiplay input matrices");
                    out.println("(3) Transpose output matrix");
                    out.println("(4) Back\n");

                    out.print("Operation: ");
                    operation2 = scanner.nextInt();

                    switch (operation2) {
                        case 1:
                            try { controller.transposeMatrix('A');
                            } catch (NullPointerException e) { System.err.println("You haven't entered input A matrix yet!"); }

                            try { controller.transposeMatrix('B');
                            } catch (NullPointerException e) { System.err.println("You haven't entered input B matrix yet!"); }
                            break;
                        case 2:
                            try { controller.multiplayInputMatrices();
                            } catch (NullPointerException e) { System.err.println("You haven't entered input matrices yet!"); }
                            break;
                        case 3:
                            try { controller.transposeMatrix('C');
                            } catch (NullPointerException e) { System.err.println("You haven't entered input matrices yet!"); }
                            break;
                        case 4:
                            break;
                        default:
                            out.println("There is no such operation!");
                    }
                    break;
                case 3:
                    out.println("(1) Display input matrices");
                    out.println("(2) Display output matrix");
                    out.println("(3) Back\n");

                    out.print("Operation: ");
                    operation2 = scanner.nextInt();

                    switch (operation2) {
                        case 1:
                            try {
                                out.println("Matrix A: ");
                                controller.displayMatrix('A');
                            } catch (NullPointerException e) { System.err.println("You haven't entered input A matrix yet!"); }
                            try {
                                out.println("Matrix B: ");
                                controller.displayMatrix('B');
                            } catch (NullPointerException e) { System.err.println("You haven't entered input B matrix yet!"); }
                            break;
                        case 2:
                            try {
                                out.println("Matrix C: ");
                                controller.displayMatrix('C');
                            } catch (NullPointerException e) { System.err.println("You haven't entered input matrices yet!"); }
                            break;
                        case 3:
                            break;
                        default:
                            out.println("There is no such operation!");
                    }
                    break;
                case 4:
                    break;
                default:
                    out.println("There is no such operation!");
            }
        } while (operation1 != 4);

        scanner.close();
    }

    private static Matrix fillMatrix(int r, int c, Scanner scanner){
        int [][] data = new int[r][c];
        Matrix matrix = new Matrix(r, c);

        for(int i = 0; i < r; i++) {
            out.println("Filling row number " + i + ":");
            for(int j = 0; j < c; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        matrix.set(data);
        return matrix;
    }
}