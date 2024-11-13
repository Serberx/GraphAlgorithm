package at.kuzu.graphprogram.test;

import at.kuzu.graphprogram.enumerations.PersistType;
import at.kuzu.graphprogram.exception.GraphenException;
import at.kuzu.graphprogram.model.Matrix;
import at.kuzu.graphprogram.model.MatrixVerwaltung;
import org.junit.Test;
import at.kuzu.graphprogram.exception.PersisterException;

public class TestLoadSER{

    @Test
    public void testLoadNullFilename(){
        String pathname = "src/save/graph22.ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Name1");
            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("SER"), null);
            System.out.println(mv1.getMatrixList());
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadNullType(){
        String pathname = "src/save/graph22.ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Name1");
            Matrix mx1 = new Matrix(5);
            mv1.load(null, "graph1");
            System.out.println(mv1.getMatrixList());
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadGetPersisterNull(){
        String pathname = "src/save/graph22.ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Name1");
            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("SER"), "graph1");
            System.out.println(mv1.getMatrixList());
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadNotSerializable(){ //It has been simulated
        String pathname = "src/save/graph1.ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("SER"), pathname);
            System.out.println(mv1.getMatrixList());
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadFNF_Exception(){
        String pathname = "UI/src/save/graph1.ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("SER"), pathname);
            System.out.println(mv1.getMatrixList());
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadNullReturned(){  //tested as set null return data in concrete class null. For testing, set retrun data for return value null in concrete class.
        String pathname = "src/save/graph_01.ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("SER"), pathname);
            System.out.println(mv1.getMatrixList());
            exceptionThrwon = true;
        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }
    @Test
    public void testLoadOK(){
        String pathname = "src/save/graph_01.ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("SER"), pathname);
            System.out.println(mv1.getMatrixList());
            exceptionThrwon = true;
        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }
}
