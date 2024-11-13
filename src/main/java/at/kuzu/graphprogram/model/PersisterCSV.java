package at.kuzu.graphprogram.model;

import at.kuzu.graphprogram.exception.GraphenException;
import at.kuzu.graphprogram.persister.Persistable;
import at.kuzu.graphprogram.exception.PersisterException;
import at.kuzu.graphprogram.constants.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 Concrete class
 */
public class PersisterCSV /*PersisterCSV<S extends Iterable<?>>*/ implements Persistable<List<Matrix>>{


    @Override
    public void persist(List<Matrix> data, String filename) throws PersisterException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Matrix mx: data){
                bw.write(mx.toStringCSVMatrix() + Constants.LINE_BREAK);
            }
        }catch(FileNotFoundException e){
            throw new PersisterException("PersisterCSV | FNF Exception at persist! " + e.getMessage(), e);
        }catch(IOException e){
            throw new PersisterException("PersisterCSV | IO Exception at persist! " + e.getMessage(), e);
        }

    }
    @Override
    public void persist2(Map<Integer, Matrix> adjaMatrix, String filename) throws PersisterException{   //Nicht vollstaendig ausgetestet
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(int i = 1; i<=adjaMatrix.size(); i++){
                bw.write(adjaMatrix.get(i).toStringCSVMatrix() + Constants.LINE_BREAK);
            }
        }catch(FileNotFoundException e){
            throw new PersisterException("PersisterCSV | FNF Exception at persist! " + e.getMessage(), e);
        }catch(IOException e){
            throw new PersisterException("PersisterCSV | IO Exception at persist! " + e.getMessage(), e);
        }
    }

    @Override
    public void persist3(List<Map<Integer, Matrix>> adjaMatrix, String filename) throws PersisterException{   //Nicht vollstaendig ausgetestet
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){

                for(int k = 0; k<adjaMatrix.size(); k++){
                    for(int j = 1; j<=adjaMatrix.get(k).size(); j++){
                       bw.write(adjaMatrix.get(k).get(j).toStringCSVMatrix());
                    }
                }
//                bw.write(adjaMatrix.get(i).toStringCSVMatrix() + Constants.LINE_BREAK);
        }catch(FileNotFoundException e){
            throw new PersisterException("PersisterCSV | FNF Exception at persist! " + e.getMessage(), e);
        }catch(IOException e){
            throw new PersisterException("PersisterCSV | IO Exception at persist! " + e.getMessage(), e);
        }

    }

    @Override
    public List<Matrix> load(String path) throws PersisterException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Matrix> tempList = new ArrayList<>();
            List<String> datenArray = new ArrayList<>();
            String line = br.readLine();
            int gesamtZeile = 1;
            int matrixZeile = 1;
            int matrix = 1;
            int tempZaehler = -1;
            int tempDimenson = 0;
            boolean firstRead = false;
            while(line != null){
                try{
                    String[] lineArray = line.split(Constants.COMMA);
                    if(!lineArray[0].isBlank()){
                        if(!Character.isDigit(lineArray[0].charAt(0)) && lineArray.length == 1 || !Character.isDigit(lineArray[0].charAt(0)) && Character.isDigit(lineArray[1].charAt(0))){
                            if(!firstRead){
                                tempDimenson = Integer.parseInt(lineArray[1]);
                                firstRead = true;
                            }
                                for(int i = 0; i < lineArray.length; i++){
                                    datenArray.add(lineArray[i]);
                                    if(tempZaehler <= 0){
                                        tempZaehler = Integer.parseInt(lineArray[1]) + 1;
                                    }
                                }
                                matrixZeile++;


                        }else{
                            if(Character.isDigit(lineArray[0].charAt(0)) && lineArray.length == 1 || Character.isDigit(lineArray[0].charAt(0)) && Character.isDigit(lineArray[1].charAt(0))){
                                if(tempZaehler <= -1){
                                    if(datenArray.size() == 0){
                                        tempZaehler = lineArray.length;
                                        datenArray.add(String.valueOf(lineArray.length));
                                        tempDimenson = lineArray.length;
                                    }
                                }
                                if(lineArray.length == tempDimenson){
                                    for(int i = 0; i < lineArray.length; i++){
                                        if(Character.isDigit(lineArray[i].charAt(0))){
                                            datenArray.add(lineArray[i]);
                                        }else{
                                            throw new PersisterException("Matrix-element is not a number! Matrix: "+matrix+ ", line: "+ gesamtZeile +", Matrix-line: " +matrixZeile +" Your input: "+ lineArray[i]);
                                        }
                                    }
                                }else{
                                    throw new PersisterException("Dimension does not match with current line! At matrix: "+ matrix+", line: "+gesamtZeile);
                                }
                            }else{
                                throw new PersisterException("Matrix-element is not a number! Matrix: "+matrix+ ", line: "+ gesamtZeile +", Matrix-line:" +(matrixZeile-1));
                            }
                            if(firstRead && matrixZeile == 2 || firstRead && matrixZeile > lineArray.length){
                                if(tempDimenson != lineArray.length){
                                    throw new GraphenException("Matrix headline dimension matches not real dimension! Headline-dimenson: "+ tempDimenson+ " compared with Real-dimension: "+lineArray.length);
                                }
                            }

                            matrixZeile++;
                        }
                    }

                    if(line.isBlank() && tempZaehler > 0){
                        throw new GraphenException("Matrix lines are shorter than dimension! At Matrix: " + matrix+ " line: " +gesamtZeile);
                    }
                    if(tempZaehler == 0 && !line.isBlank()){
                        throw new GraphenException("Matrix lines are bigger than dimension! At Matrix: " + matrix+ " line: " +gesamtZeile);
                    }

                    line = br.readLine();
                    gesamtZeile++;
                    tempZaehler--;

//                    if(line != null ){
                        if(tempZaehler == 0){
                            if((matrixZeile - 2 == lineArray.length) || matrixZeile - 1 == lineArray.length){
                                tempList.add(new Matrix(datenArray));
                                datenArray = new ArrayList<>();
                                matrix++;
                                matrixZeile = 1;
                                firstRead = false;
                            }
                        }
//                        if(tempZaehler != 0 && line.isBlank() && (Math.floorMod((int) Math.sqrt(datenArray.size()), datenArray.size()) == datenArray.size())){
//                            System.out.println("fail");     //TODO
//                        }
//                    }
                }catch(IndexOutOfBoundsException e){
                    throw new PersisterException("IOOB Exception, " + e.getMessage(), e);
                }catch(GraphenException e){
                    throw new PersisterException("Failure with reading Matrix: " + matrix + " in fullline: " + gesamtZeile + ", Matrix-line: "+ matrixZeile +" | "+e.getMessage(), e);
                }
            }
            return tempList;
        }catch(FileNotFoundException e){
            throw new PersisterException("PersisterCSV | FNF Exception at persist! " + e.getMessage(), e);
        }catch(IOException e){
            throw new PersisterException("PersisterCSV | IO Exception at persist! " + e.getMessage(), e);
        }
    }
}