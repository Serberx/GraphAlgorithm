package model;

import constants.Constants;
import exception.GraphenException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Matrix implements Serializable, MatrixOperationen{

    private String name;
    private int dimension;
    private int[][] matrixArray;

    public Matrix(int dimension) throws GraphenException{
        setName("-default-");
        setDimension(dimension);
        matrixArray = new int[this.dimension][this.dimension];

    }


    public Matrix(String name, int dimension) throws GraphenException{
        setName(name);
        setDimension(dimension);
        matrixArray = new int[this.dimension][this.dimension];
    }

    public Matrix(List<String> lineArray) throws GraphenException{
        try{
            if(lineArray != null){
                if(!Character.isDigit(lineArray.get(0).charAt(0))){
                    String stringName = lineArray.get(0);
                    String stringDimension = lineArray.get(1);
                    matrixArray = new int[Integer.parseInt(lineArray.get(1))][Integer.parseInt(lineArray.get(1))];
                    if(stringName != null && !stringName.isBlank()){
                        setName(stringName);
                    }else{
                        throw new GraphenException(stringName == null ? "Null-Ref." : "Blank" + " at stringName!");
                    }
                    if(stringDimension != null && !stringDimension.isBlank()){
                        setDimension(Integer.parseInt(stringDimension));
                    }else{
                        throw new GraphenException(stringDimension == null ? "Null-Ref." : "Blank" + " at " +
                                "stringDimension!");
                    }
                    stringElementeHinzufuegen(lineArray);
                }else{
                    setName("-default-");
                    String stringDimension = lineArray.get(0);
                    if(stringDimension != null && !stringDimension.isBlank()){
                        setDimension(Integer.parseInt(stringDimension));
                    }else{
                        throw new GraphenException(stringDimension == null ? "Null-Ref." : "Blank" + " at " +
                                "stringDimension!");
                    }
                    matrixArray = new int[Integer.parseInt(lineArray.get(0))][Integer.parseInt(lineArray.get(0))];
                    stringElementeHinzufuegen(lineArray);
                }
            }else{
                throw new GraphenException("Matrix Cunstructor | Null-Ref. in lineArray!");
            }
        }catch(NumberFormatException e){
            throw new GraphenException("Matrix Cunstructor | NF Exception at lineArray!" + e.getMessage(), e);
        }
    }

    public String getName(){
        return this.name;
    }

    public int getDimension(){
        return matrixArray.length;
    }

    public void setName(String name) throws GraphenException{
        if(name != null && !name.isBlank()){
            this.name = name;
        }else{
            throw new GraphenException("setName() |" + (name.isBlank() ? " Blank" : " Null-Ref.") + " at name!");
        }
    }

    public void setDimension(int dimension) throws GraphenException{
        if(dimension > Constants.MATRIX_BOUNDRY_LOW && dimension < Constants.MATRIX_BOUNDRY_HIGH){
            this.dimension = dimension;
        }else{
            throw new GraphenException("setDimension() | Matrix dimension must be between " + Constants.MATRIX_BOUNDRY_LOW + " and " + Constants.MATRIX_BOUNDRY_HIGH + "! Your input: " + dimension);
        }
    }

    @Override
    public boolean equals(Object o){

        if(this == o)
            return true;
        if(o == null || this.getClass() != o.getClass())
            return false;
        Matrix matrix = (Matrix) o;
        return dimension == matrix.dimension && Arrays.equals(matrixArray, matrix.matrixArray);
    }

    @Override
    public int hashCode(){
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(matrixArray);
        return result;
    }

    //weitereMethoden
    @Override
    public void stringElementeHinzufuegen(List<String> wert) throws GraphenException{
        int zaehler ;
        if(wert != null){
            try{
//                if((Math.floorMod((int) Math.sqrt(wert.size()), wert.size()) == wert.size())){
//                    System.out.println("fail");     //TODO
//                }
                if(!Character.isDigit(wert.get(0).charAt(0))){
                    zaehler = 4;
                }else{
                    zaehler = 1;
                }
                for(int i = 0; i < wert.size() - zaehler; i++){
                    for(int k = 0; k <= this.dimension - 1; k++){
                            matrixArray[i][k] = Integer.parseInt(wert.get(zaehler));
                            zaehler++;
                    }
                }
            }catch(IndexOutOfBoundsException e){
                throw new GraphenException("stringElementeHinzufuegen | IOOB Exception at hinzufuegen!");
            }
        }else{
            throw new GraphenException("stringElementeHinzufuegen | Null-Ref. at stringElementeHinzufuegen!");
        }
    }



    public int getElement(int i, int j) throws GraphenException{
        try{
            if(getDimension() > 0){
                if(i <= getDimension() && i >= 0 && j <= getDimension() && j >= 0){
                    return matrixArray[i][j];
                }else{
                    throw new GraphenException("getElement | i-j must be between 0 and " + (getDimension()-1));
                }
            }else{
                throw new GraphenException("getElement | Dimension not set!");
            }
        }catch(IndexOutOfBoundsException e){
            throw new GraphenException("getElement | IOOB Exception at getElement!"+e.getMessage(),e);
        }
    }

    public void setElement(int pos_i, int pos_j, int wert) throws GraphenException{
        if(getDimension() > 0){
            if(pos_i >= 0 && pos_i < getDimension() && pos_j >= 0 && pos_j < getDimension()){
                if(wert >= 0 && wert <= Constants.MATRIX_ELEMENT_WERT_HIGH){
                    matrixArray[pos_i][pos_j] = wert;
                }else{
                    throw new GraphenException("setElement | wert must be between 0 and "+Constants.MATRIX_ELEMENT_WERT_HIGH+"! Your input: "+wert);
                }
            }else{
                throw new GraphenException("setElement | i-j must be between 0 and " +  (getDimension()-1)+ " | Your input: i: "+pos_i+", j: "+pos_j);
            }
        }else{
            throw new GraphenException("setElement | Dimension must first be set!");
        }
    }
    public void setElementDistanzMatrix(int pos_i, int pos_j, int wert) throws GraphenException{
        if(getDimension() > 0){
            if(pos_i >= 0 && pos_i < getDimension() && pos_j >= 0 && pos_j < getDimension()){
                if(wert >= -1 && wert <= Constants.MATRIX_ELEMENT_WERT_HIGH){
                    matrixArray[pos_i][pos_j] = wert;
                }else{
                    throw new GraphenException("setElement | wert must be between 0 and "+Constants.MATRIX_ELEMENT_WERT_HIGH+"! Your input: "+wert);
                }
            }else{
                throw new GraphenException("setElement | i-j must be between 0 and " +  (getDimension()-1));
            }
        }else{
            throw new GraphenException("setElement | Dimension must first be set!");
        }
    }

    public String toStringCSVMatrix(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(";").append(this.dimension).append(";").append("x").append(";").append(this.dimension).append("\n");
        for(int i = 0; i < matrixArray.length; i++){
            for(int k = 0; k < matrixArray[i].length; k++){
                builder.append(matrixArray[i][k]).append(";");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override       //DONE
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName()).append(":").append(this.name).append(this.dimension).append("x").append(this.dimension).append("\n");
        for(int i = 0; i < matrixArray.length; i++){
            for(int k = 0; k < matrixArray[i].length; k++){
                builder.append(matrixArray[i][k]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
