package model;

import exception.GraphenException;

public class MatrixTwo{

    private int[][] matrixArray;
    private int dim;
    public MatrixTwo(int dim) throws GraphenException{
        matrixArray = new int[this.dim][this.dim];
        setDim(dim);
    }

    public int getDim(){
        return this.dim;
    }

    public void setDim(int dim) throws GraphenException{
        if(dim > 0){
            this.dim = dim;
        }else{
            throw new GraphenException("Dim must be bigger than 0");
        }
    }

    public int multiply(int wert){
        int zaehler = 0;

        for(int i = 0; i < this.dim; i++){
            for(int k = 0;k < this.dim; k++){
                matrixArray[i][k] = wert;
            }
        }

        return 0;
    }
}
