package test;

import exception.GraphenException;
import model.Matrix;
import org.junit.Test;

public class VersuchsMatrix {


    public static Matrix mehrDimMatrix(){
        Matrix mx1 = null;
        try {
            mx1 = new Matrix("Mehrdimensionales Matrix", 9);
            mx1.setElement(0,0, 0);
            mx1.setElement(0,1, 1);
            mx1.setElement(0,2, 1);
            mx1.setElement(0,3, 0);
            mx1.setElement(0,4, 0);
            mx1.setElement(0,5, 0);
            mx1.setElement(0,6, 0);
            mx1.setElement(0,7, 0);
            mx1.setElement(0,8, 0);

            mx1.setElement(1,0, 1);
            mx1.setElement(1,1, 0);
            mx1.setElement(1,2, 1);
            mx1.setElement(1,3, 1);
            mx1.setElement(1,4, 0);
            mx1.setElement(1,5, 0);
            mx1.setElement(1,6, 0);
            mx1.setElement(1,7, 0);
            mx1.setElement(1,8, 0);

            mx1.setElement(2,0, 1);
            mx1.setElement(2,1, 1);
            mx1.setElement(2,2, 0);
            mx1.setElement(2,3, 1);
            mx1.setElement(2,4, 1);
            mx1.setElement(2,5, 1);
            mx1.setElement(2,6, 0);
            mx1.setElement(2,7, 0);
            mx1.setElement(2,8, 0);

            mx1.setElement(3,0, 0);
            mx1.setElement(3,1, 1);
            mx1.setElement(3,2, 1);
            mx1.setElement(3,3, 0);
            mx1.setElement(3,4, 0);
            mx1.setElement(3,5, 0);
            mx1.setElement(3,6, 0);
            mx1.setElement(3,7, 0);
            mx1.setElement(3,8, 0);

            mx1.setElement(4,0, 0);
            mx1.setElement(4,1, 0);
            mx1.setElement(4,2, 1);
            mx1.setElement(4,3, 0);
            mx1.setElement(4,4, 0);
            mx1.setElement(4,5, 1);
            mx1.setElement(4,6, 0);
            mx1.setElement(4,7, 0);
            mx1.setElement(4,8, 0);
/////
            mx1.setElement(5,0, 0);
            mx1.setElement(5,1, 0);
            mx1.setElement(5,2, 1);
            mx1.setElement(5,3, 0);
            mx1.setElement(5,4, 1);
            mx1.setElement(5,5, 0);
            mx1.setElement(5,6, 1);
            mx1.setElement(5,7, 0);
            mx1.setElement(5,8, 0);

            mx1.setElement(6,0, 0);
            mx1.setElement(6,1, 0);
            mx1.setElement(6,2, 0);
            mx1.setElement(6,3, 0);
            mx1.setElement(6,4, 0);
            mx1.setElement(6,5, 1);
            mx1.setElement(6,6, 0);
            mx1.setElement(6,7, 1);
            mx1.setElement(6,8, 0);

            mx1.setElement(7,0, 0);
            mx1.setElement(7,1, 0);
            mx1.setElement(7,2, 0);
            mx1.setElement(7,3, 0);
            mx1.setElement(7,4, 0);
            mx1.setElement(7,5, 0);
            mx1.setElement(7,6, 1);
            mx1.setElement(7,7, 0);
            mx1.setElement(7,8, 0);

            mx1.setElement(8,0, 0);
            mx1.setElement(8,1, 0);
            mx1.setElement(8,2, 0);
            mx1.setElement(8,3, 0);
            mx1.setElement(8,4, 0);
            mx1.setElement(8,5, 0);
            mx1.setElement(8,6, 1);
            mx1.setElement(8,7, 0);
            mx1.setElement(8,8, 0);

            System.out.println(mx1.toStringCSVMatrix());

        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return mx1;
    }

    public static void main(String[] args) {
        VersuchsMatrix.mehrDimMatrix();
    }
}
