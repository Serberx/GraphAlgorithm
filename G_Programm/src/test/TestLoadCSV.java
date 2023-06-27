package test;

import enumerations.PersistType;
import exception.GraphenException;
import model.Matrix;
import model.MatrixVerwaltung;
import org.junit.Test;
import persister.PersisterException;

import java.util.Locale;

public class TestLoadCSV{


    @Test
    public void testLoadNullFilename(){
        String pathname = "src/save/graph22.csv";
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
        String pathname = "src/save/graph22.csv";
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
        String pathname = "src/save/graph22.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), "graph1");
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
    public void testLoad(){
        String pathname = "src/export/graph1.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            System.out.println(mv1.getMatrix(0));
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadFNFException(){
        String pathname = "src/export/graph4.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            System.out.println(mv1.getMatrix(0));
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadFailureWithReadingMatrix_NF_Exception(){
        String pathname = "src/export/graph1.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            System.out.println(mv1.getMatrix(0));
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadIOOBException(){
        String pathname = "src/export/graph2.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadDimensionNotMatch(){
        String pathname = "src/export/graph3.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadMatrixShorter(){
        String pathname = "src/export/graph4.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadFailParsing(){
        String pathname = "src/export/graph5.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadFailParsing2(){
        String pathname = "src/export/graph6.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrixList());
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

  /*  @Test
    public void testLoadPruefeMatrixNULL(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            System.out.println(mv1.getMatrix(0));
            System.out.println(mv1.pruefeMatrix(null));
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadPruefeMatrixNoDimension(){  //Zurzeit kein Exceptionwurf möglich, da dimension immer
        // automatisch gesetzt wird.
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            System.out.println(mv1.getMatrix(1));
            System.out.println(mv1.pruefeMatrix(mv1.getMatrix(0)));
            //            System.out.println(mv1.getMatrixList());
            exceptionThrwon = true;
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }*/

    @Test
    public void testLoadPruefeMatrixGetElementIOOBException(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrix(1));
            //            System.out.println(mv1.pruefeMatrix(mv1.getMatrix(0)));
            System.out.println(mx1.getElement(1, 5));
            //            System.out.println(mv1.getMatrixList());
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
    public void testLoadPruefeMatrixGetElementIOOBException2(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrix(1));
            //            System.out.println(mv1.pruefeMatrix(mv1.getMatrix(0)));
            System.out.println(mx1.getElement(5, 3));
            //            System.out.println(mv1.getMatrixList());
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

    /*@Test
    public void testLoadPruefeMatrixGetElement(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            Matrix mx1 = new Matrix(5);
            mv1.load(PersistType.valueOf("CSV"), pathname);
            //            System.out.println(mv1.getMatrix(1));
            System.out.println(mv1.pruefeMatrix(mv1.getMatrix(0)));
            //            System.out.println(mx1.getElement(5,3));
            //            System.out.println(mv1.getMatrixList());
            exceptionThrwon = true;
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
    }*/

    @Test
    public void testLoadPruefeMatrixSetElement(){   //Matrix Erzeugung auch durch setzen der einzelwerte mögllich!
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(0, 0, 1);
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 1);
            mx1.setElement(0, 4, 1);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 1);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 1);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 1);
            mx1.setElement(2, 3, 1);
            mx1.setElement(2, 4, 1);
            mx1.setElement(3, 0, 1);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 1);
            mx1.setElement(3, 3, 1);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 1);
            mx1.setElement(4, 1, 1);
            mx1.setElement(4, 2, 1);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 1);
            mx1.setElement(4, 5, 1);
            System.out.println(mx1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadPruefeMatrixSetElementWrongPos_i(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(-1, 0, 1);
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 1);
            mx1.setElement(0, 4, 1);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 1);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 1);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 1);
            mx1.setElement(2, 3, 1);
            mx1.setElement(2, 4, 1);
            mx1.setElement(3, 0, 1);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 1);
            mx1.setElement(3, 3, 1);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 1);
            mx1.setElement(4, 1, 1);
            mx1.setElement(4, 2, 1);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 1);

            System.out.println(mx1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadPruefeMatrixSetElementWrongPos_i2(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(5, 0, 1);  //<==
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 1);
            mx1.setElement(0, 4, 1);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 1);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 1);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 1);
            mx1.setElement(2, 3, 1);
            mx1.setElement(2, 4, 1);
            mx1.setElement(3, 0, 1);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 1);
            mx1.setElement(3, 3, 1);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 1);
            mx1.setElement(4, 1, 1);
            mx1.setElement(4, 2, 1);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 1);

            System.out.println(mx1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadPruefeMatrixSetElementWrongPos_j1(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(0, -1, 1);  //<==
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 1);
            mx1.setElement(0, 4, 1);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 1);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 1);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 1);
            mx1.setElement(2, 3, 1);
            mx1.setElement(2, 4, 1);
            mx1.setElement(3, 0, 1);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 1);
            mx1.setElement(3, 3, 1);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 1);
            mx1.setElement(4, 1, 1);
            mx1.setElement(4, 2, 1);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 1);

            System.out.println(mx1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadPruefeMatrixSetElementWrongPos_j2(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(0, 5, 1);  //<==
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 1);
            mx1.setElement(0, 4, 1);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 1);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 1);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 1);
            mx1.setElement(2, 3, 1);
            mx1.setElement(2, 4, 1);
            mx1.setElement(3, 0, 1);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 1);
            mx1.setElement(3, 3, 1);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 1);
            mx1.setElement(4, 1, 1);
            mx1.setElement(4, 2, 1);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 1);

            System.out.println(mx1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadPruefeMatrixSetElementWrongWert1(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(0, 0, -1);  //<==
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 1);
            mx1.setElement(0, 4, 1);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 1);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 1);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 1);
            mx1.setElement(2, 3, 1);
            mx1.setElement(2, 4, 1);
            mx1.setElement(3, 0, 1);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 1);
            mx1.setElement(3, 3, 1);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 1);
            mx1.setElement(4, 1, 1);
            mx1.setElement(4, 2, 1);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 1);

            System.out.println(mx1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadPruefeMatrixSetElementWrongWert2(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(0, 0, 2);  //<==
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 1);
            mx1.setElement(0, 4, 1);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 1);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 1);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 1);
            mx1.setElement(2, 3, 1);
            mx1.setElement(2, 4, 1);
            mx1.setElement(3, 0, 1);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 1);
            mx1.setElement(3, 3, 1);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 1);
            mx1.setElement(4, 1, 1);
            mx1.setElement(4, 2, 1);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 1);

            System.out.println(mx1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadPruefeMatrixSetElementWertOK(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);
            //            mv1.load(PersistType.CSV, pathname);
            mx1.setElement(0, 0, 0);
            mx1.setElement(0, 1, 1);
            mx1.setElement(0, 2, 1);
            mx1.setElement(0, 3, 0);
            mx1.setElement(0, 4, 0);
            mx1.setElement(1, 0, 1);
            mx1.setElement(1, 1, 0);
            mx1.setElement(1, 2, 1);
            mx1.setElement(1, 3, 1);
            mx1.setElement(1, 4, 0);
            mx1.setElement(2, 0, 1);
            mx1.setElement(2, 1, 1);
            mx1.setElement(2, 2, 0);
            mx1.setElement(2, 3, 0);
            mx1.setElement(2, 4, 0);
            mx1.setElement(3, 0, 0);
            mx1.setElement(3, 1, 1);
            mx1.setElement(3, 2, 0);
            mx1.setElement(3, 3, 0);
            mx1.setElement(3, 4, 1);
            mx1.setElement(4, 0, 0);
            mx1.setElement(4, 1, 0);
            mx1.setElement(4, 2, 0);
            mx1.setElement(4, 3, 1);
            mx1.setElement(4, 4, 0);

            //            System.out.println(mx1);
            System.out.println(mx1.toStringCSVMatrix());
            mv1.add(mx1);
            mv1.save(PersistType.CSV, "graph8");
            exceptionThrwon = true;
        }catch(GraphenException e){

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
    public void testLoadKnotenGradOK(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);

            mv1.load(PersistType.CSV, "src/export/graph8.csv");
            mv1.knotenGrad(true, mv1.getMatrix(0));
            //            System.out.println(mv1.toString());
            exceptionThrwon = true;
        }catch(GraphenException e){

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
    public void testLoadKnotenGradNull(){
        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            Matrix mx1 = new Matrix("Test", 5);

            mv1.load(PersistType.CSV, "src/export/graph8.csv");
            mv1.knotenGrad(true, null);
            //            System.out.println(mv1.toString());
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
    public void testLoadKnotenGradALLMatrixEmptyMatrix(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            //            mv1.load(PersistType.CSV, "src/export/graph9.csv");
            //            mv1.knotenGrad(mv1.getMatrix(0));
            mv1.knotenGradAllMatrix();
            //            int[] gradList = mv1.knotenGrad(mv1.getMatrix(0));
            //            System.out.println(gradList[2]);
            //            System.out.println(mv1.toString());
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadKnotenGradALLMatrix(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            mv1.load(PersistType.CSV, "src/export/graph9.csv");
            //            mv1.knotenGrad(mv1.getMatrix(0));
            mv1.knotenGradAllMatrix();
            //            int[] gradList = mv1.knotenGrad(mv1.getMatrix(0));
            //            System.out.println(gradList[2]);
            //            System.out.println(mv1.toString());
            exceptionThrwon = true;
        }catch(GraphenException e){

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
    public void testLoadKnotenGradExpectedMatrixEmpty(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            //            mv1.load(PersistType.CSV, "src/export/graph9.csv");
            mv1.knotenGradExpectedMatrix(1);
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadKnotenGradExpectedMatrixLowPos(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            mv1.load(PersistType.CSV, "src/export/graph10.csv");
            mv1.knotenGradExpectedMatrix(-1);
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
    public void testLoadKnotenGradExpectedMatrixHIGHPos(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            mv1.load(PersistType.CSV, "src/export/graph10.csv");
            mv1.knotenGradExpectedMatrix(4);
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
    public void testLoadKnotenGradExpectedMatrixPosNO_RightForm(){ //Exception wurf wegen Prüfung davor nicht
        // möglich! Wenn Fehlerfall, dann wird geworfen!
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            mv1.load(PersistType.CSV, "src/export/graph10.csv");
            mv1.knotenGradExpectedMatrix(1);
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
    public void testLoadKnotenGradExpectedMatrixOK(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            mv1.load(PersistType.CSV, "src/export/graph10.csv");
            //            mv1.knotenGradExpectedMatrix(1);
            mv1.knotenGradExpectedMatrix(0);
            exceptionThrwon = true;
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            //            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadKnotenGraLineSelected(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();


            mv1.load(PersistType.CSV, "src/export/graph11.csv");
            mv1.knotenGradLineSelect(true, 1);
            System.out.println(mv1.toString());
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
    public void testLoadAdjazentMatrixTEst(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");
            //            System.out.println(mv1.adjazenzmatrixBack(1,3));
            mv1.adjazenzmatrix(1, 3);

            mv1.knotenGradLineSelect(true, 2);
            //            mv1.save(PersistType.CSV, "Adjaz_graph12");
            System.out.println(mv1.toString());
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
    public void testLoadAdjazentMatrixLowPosition(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            System.out.println(mv1.adjazenzmatrix2(-1, 1));

            //            mv1.save(PersistType.CSV, "Adjaz_graph12");
            System.out.println(mv1.toString());
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
    public void testLoadAdjazentMatrixHighPosition(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            System.out.println(mv1.adjazenzmatrix2(100, 1));

            //            mv1.save(PersistType.CSV, "Adjaz_graph12");
            System.out.println(mv1.toString());
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
    public void testLoadAdjazentMatrixLowPower(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            System.out.println(mv1.adjazenzmatrix2(1, 0));

            //            mv1.save(PersistType.CSV, "Adjaz_graph12");
            System.out.println(mv1.toString());
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
    public void testLoadAdjazentMatrixHighPower(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            System.out.println(mv1.adjazenzmatrix2(1, 100));

            //            mv1.save(PersistType.CSV, "Adjaz_graph12");
            System.out.println(mv1.toString());
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
    public void testLoadAdjazentMatrixOKPowerAndPosition(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            //            System.out.println( mv1.adjazenzmatrix2(0,5));
            //            System.out.println( mv1.adjazenzmatrix2(1,5));

            System.out.println(mv1.adjazenzmatrix2(0, 5));
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
    public void testLoadAdjazentMatrixOKPowerAndPosition2(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            //            System.out.println( mv1.adjazenzmatrix2(0,5));
            //            System.out.println( mv1.adjazenzmatrix2(1,5));

            //            System.out.println( mv1.adjazenzmatrix2(0,2));
            //            mv1.adjazenzmatrix(2, 3);
            mv1.adjazenzmatrix(0, 3);
            mv1.adjazenzmatrix(1, 5);
            mv1.adjazenzmatrix(2, 3);
            //            aMatrix.add(mv1.adjazenzmatrix2(1,3));
            //            Map<Integer, Matrix> bMatrix = mv1.adjazenzmatrix2(0,3).get();

            //            System.out.println(mv1.toString());
            System.out.println(mv1.toString());
            mv1.persistadjazenzMatrixMap(mv1.getPotenzMapListe(), PersistType.CSV, "Test_Demo2"); //Nicht fetig ausgetestet

            //            mv1.persistadjazenzMatrixMap(mv1.getMapListe(), PersistType.CSV, "Test_Demeo_M"); //Nicht
            //            fetig ausgetestet
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
    public void testLoadAdjazentMatrixOKPowerAndPosition3(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            //            System.out.println( mv1.adjazenzmatrix2(0,5));
            //            System.out.println( mv1.adjazenzmatrix2(1,5));

            mv1.adjazenzmatrix2(0, 2);
            mv1.adjazenzmatrix2(2, 3);
            System.out.println(mv1.toString());


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
    public void testLoadAdjazentMatrixKantenfolge(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!

            //            System.out.println( mv1.adjazenzmatrix2(0,5));
            //            System.out.println( mv1.adjazenzmatrix2(1,5));

            //            mv1.adjazenzmatrix2(0, 3);
            System.out.println(mv1.toString());


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
    public void testLoadAdjazentMatrixLoadTest(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!

            //            System.out.println( mv1.adjazenzmatrix2(0,5));
            //            System.out.println( mv1.adjazenzmatrix2(1,5));

            //            mv1.adjazenzmatrix2(0, 3);
            System.out.println(mv1.toString());


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
    public void testLoadAdjazentMatrixKantenfolgeFunktionsTest(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            //            mv1.adjazenzmatrix2(0,3);
            mv1.knotenGradLineSelect(true, 1);
            mv1.adjazenzmatrix(0, 2);
            //            mv1.anzahlKantenfolgenVonKzuK(1,2,3);
            //            System.out.println(mv1.getMapListe());
            System.out.println(mv1.getPotenzMapListe().get(0));
            //            System.out.println(mv1.toString());

            //            System.out.println(mv1.toString());


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
    public void testLoadAdjazentMatrixKantenfolgeFunktionsTest2(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            //            System.out.println(mv1.knotenGradLineSelect(1));
            mv1.adjazenzmatrix2(0, 3);
            //            mv1.getMapListe().get(2);
            //           mv1.knotenGradExpectedMatrix(0);
            //            mv1.anzahlKantenfolgenVonKzuK();
            //            System.out.println(mv1.toString2());
            mv1.adjazenzmatrix(0, 3);
            //            System.out.println(mv1.getMapListe().get(0).get(2));
            //            System.out.println(mv1.getMapListe().get(0).get(3));
            //            System.out.println(mv1.getMapListe().get(0).get(4));
            System.out.println(mv1.getPotenzMapListe().get(0).get(3));
            System.out.println(mv1.toString());
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
    public void testLoadDistanzMatrix(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            //            mv1.anzahlKantenfolgen(2);
            //            mv1.adjazenzmatrix(0,6);
            //            mv1.anzahlKantenfolgenVonKzuK2();
            //            mv1.anzahlKantenfolgen(3);
            //            mv1.distanzMatrix3();
            mv1.distanzMatrix3();
            System.out.println(mv1.getDistanzListe());
            //            System.out.println(mv1.getDistanzListe().get(0).get(2));
            //            int a = 3; /*mv1.getDistanzListe().get(0).size();*/
            //            System.out.println(mv1.getDistanzListe().get(0).get(a).toStringCSVMatrix());
            //            System.out.println(mv1.getDistanzListe().get(0).get(mv1.getDistanzListenGroesse()));

            //            System.out.println(mv1.adjazenzmatrix2(0,3));
            //            System.out.println(mv1.toString2());
            //            mv1.anzahlKantenfolgenVonKzuK2();
            //            System.out.println(mv1.getMapListe().get(0).get(4));
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
    public void testLoadDistanzMatrixNull(){  //FunktionsTest: erfolgreich
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            //            mv1.anzahlKantenfolgen(2);
            mv1.adjazenzmatrix(0, 6);
            //            mv1.anzahlKantenfolgenVonKzuK2();
            //            mv1.anzahlKantenfolgen(3);
            mv1.distanzMatrix3();
            mv1.distanzMatrix3();
            //            System.out.println(mv1.getDistanzListe());
            System.out.println(mv1.toString());
            //            System.out.println(mv1.getDistanzListe().get(0).get(2));
            int a = 3; /*mv1.getDistanzListe().get(0).size();*/
            System.out.println(mv1.getDistanzListe().get(0).get(a).toStringCSVMatrix());
            //            System.out.println(mv1.getDistanzListe().get(0).get(mv1.getDistanzListenGroesse()));

            //            System.out.println(mv1.adjazenzmatrix2(0,3));
            //            System.out.println(mv1.toString2());
            //                        mv1.anzahlKantenfolgenVonKzuK2();
            //            System.out.println(mv1.getMapListe().get(0).get(4));
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
    public void testLoadDistanzMatrixVonKzuK(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von 1 zu 2: "+mv1.distanzVonKzuK(1, 2));
            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1, 3));
            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5, 3));
            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1, 4));
            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1, 5));
            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2, 1));
            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2, 3));
            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4, 3));
            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2, 4));
            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2, 5));

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
    public void testLoadDistanzMatrixVonKzuKEmptyList(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten
            //            Potenzmatrizen funktioniert!
            System.out.println("Distanz von 1 zu 2: "+mv1.distanzVonKzuK(1, 2));
            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1, 3));
            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5, 3));
            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1, 4));
            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1, 5));
            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2, 1));
            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2, 3));
            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4, 3));
            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2, 4));
            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2, 5));


        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixVonKnoten1RangeLow(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von 1 zu 2: "+mv1.distanzVonKzuK(0, 2));
            //            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1,3));
            //            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5,3));
            //            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1,4));
            //            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1,5));
            //            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2,1));
            //            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2,3));
            //            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4,3));
            //            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2,4));
            //            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2,5));


        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixVonKnoten2RangeLow(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von 1 zu 2: "+mv1.distanzVonKzuK(1, 0));
            //            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1,3));
            //            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5,3));
            //            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1,4));
            //            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1,5));
            //            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2,1));
            //            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2,3));
            //            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4,3));
            //            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2,4));
            //            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2,5));


        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixVonKnoten1RangeHigh(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von "+mv1.getMatrixList().get(0).getDimension()+" zu 3: "+mv1.distanzVonKzuK(mv1.getMatrixList().get(0).getDimension()+1, 3));
            //            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1,3));
            //            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5,3));
            //            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1,4));
            //            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1,5));
            //            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2,1));
            //            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2,3));
            //            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4,3));
            //            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2,4));
            //            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2,5));


        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixVonKnoten2RangeHigh(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von 3 zu "+mv1.getMatrixList().get(0).getDimension()+": "+mv1.distanzVonKzuK(3, mv1.getMatrixList().get(0).getDimension()+1));
            //            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1,3));
            //            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5,3));
            //            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1,4));
            //            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1,5));
            //            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2,1));
            //            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2,3));
            //            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4,3));
            //            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2,4));
            //            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2,5));


        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixVonKnoten1ANDKnoten2RangeSame(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von 3 zu 3: "+mv1.distanzVonKzuK(3, 3));
            //            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1,3));
            //            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5,3));
            //            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1,4));
            //            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1,5));
            //            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2,1));
            //            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2,3));
            //            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4,3));
            //            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2,4));
            //            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2,5));


        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixVonKnoten1ANDKnoten2OK(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5, 3));
            System.out.println(mv1.distanzVonKzuK(5, 3));


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
    public void testLoadDistanzMatrixEmpty(){  //Für den Test wurde distanzMatrix() Erzeugung in der zugehörigen
        // Klasse vorübergehend gelöscht!
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der Erzeugten Potenzmatrizen funktioniert!
            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5, 3));
            //            System.out.println("Distanz von 1 zu 3: "+mv1.distanzVonKzuK(1,3));
            //            System.out.println("Distanz von 5 zu 3: "+mv1.distanzVonKzuK(5,3));
            //            System.out.println("Distanz von 1 zu 4: "+mv1.distanzVonKzuK(1,4));
            //            System.out.println("Distanz von 1 zu 5: "+mv1.distanzVonKzuK(1,5));
            //            System.out.println("Distanz von 2 zu 1: "+mv1.distanzVonKzuK(2,1));
            //            System.out.println("Distanz von 2 zu 3: "+mv1.distanzVonKzuK(2,3));
            //            System.out.println("Distanz von 4 zu 3: "+mv1.distanzVonKzuK(4,3));
            //            System.out.println("Distanz von 2 zu 4: "+mv1.distanzVonKzuK(2,4));
            //            System.out.println("Distanz von 2 zu 5: "+mv1.distanzVonKzuK(2,5));

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
    public void testLoadDistanzMatrixVonKnoten1Und2RangeOK(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv"); //laden der erzeugten Potenzmatrizen funktioniert!
            //            System.out.println("Distanz von 3 zu 2: "+mv1.distanzVonKzuK(2,6));
            //            System.out.println(mv1.getDistanzListenGroesse());
            //            System.out.println(mv1.exzentritäten());
            System.out.println(mv1.getExzentritaetVomKnoten(true, 1));
            //            System.out.println(mv1.getExzentritätVomKnoten(2));
            //            System.out.println(mv1.getExzentritätVomKnoten(3));
            //            System.out.println(mv1.getExzentritätVomKnoten(4));
            //            System.out.println(mv1.getExzentritätVomKnoten(5));
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
    public void testLoadDistanzMatrixExzentritaetEmptyMatrixList(){  //FunktionsTest
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            mv1.exzentritaeten();
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
            //        }catch(PersisterException e){
            //
            //            System.out.println(e.getMessage());
            //            e.printStackTrace();
            //        }
            assert (exceptionThrwon);
        }
    }

    @Test
    public void testLoadDistanzMatrixExzentritaetEmptyDistanzList(){   //In der zugehörigen Methode wurde
        // distanzMatrix3() abgewählt und distanzListe neu erzeugt(hingeschrieben)!
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            System.out.println(mv1.exzentritaeten());
        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixExzentritaetOK(){   //In der zugehörigen Methode wurde
        // distanzMatrix3() abgewählt und distanzListe neu erzeugt(hingeschrieben)!
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            System.out.println(mv1.exzentritaeten());
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
    public void testLoadDistanzMatrixgetExzentritaetVomKnotenEmptyMatrixList(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            //            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            mv1.getExzentritaetVomKnoten(true, 2);

        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }/*catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixgetExzentritaetVomKnotenEmptyExzentritaetenList(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            mv1.getExzentritaetVomKnoten(true, 2);
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
    public void testLoadDistanzMatrixgetExzentritaetVomKnotenRangeLow(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            mv1.getExzentritaetVomKnoten(true, 0);

        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixgetExzentritaetVomKnotenRangeHigh(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            mv1.getExzentritaetVomKnoten(true, mv1.getMatrixList().get(0).getDimension()+1);


        }catch(GraphenException e){
            exceptionThrwon = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrwon);
    }

    @Test
    public void testLoadDistanzMatrixgetExzentritaetVomKnotenOK(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            mv1.getExzentritaetVomKnoten(true, 1);
            mv1.getExzentritaetVomKnoten(true, 2);
            mv1.getExzentritaetVomKnoten(true, 3);
            mv1.getExzentritaetVomKnoten(true, 4);
            mv1.getExzentritaetVomKnoten(true, 5);

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
    public void testLoadDistanzMatrixgetDurchmesser(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            //            System.out.println( mv1.durchmesser());
            //            System.out.println( mv1.radius());
            //            System.out.println(mv1.exzentritäten());
            //            System.out.println(mv1.getExzentritaetVomKnoten(1));
            //            System.out.println(mv1.durchmesser2());
            //            System.out.println(mv1.radius2());
            //            mv1.distanzMatrix2(2);
            mv1.exzentritaeten();
            System.out.println(mv1.getDistanzListe());
            System.out.println(mv1.toString2());

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
    public void testLoadDistanzvonKzuK(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            //
            //            mv1.exzentritäten();
            //            System.out.println(mv1.getDistanzListe());
            //            System.out.println(mv1.toString2());

            System.out.println(mv1.distanzVonKzuK(3, 5));
            System.out.println(mv1.radius2(true));

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
    public void testLoadDistanzvonKzuK2(){
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            //
            //            mv1.exzentritäten();
            //            System.out.println(mv1.getDistanzListe());
            //            System.out.println(mv1.toString2());

            System.out.println(mv1.distanzVonKzuK(3, 5));
            System.out.println(mv1.radius(true));

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
    public void testDistanz(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            System.out.println(String.format(Locale.US, "%3s, %8d %10.2f", "Rene", 19, 3.14));
            mv1.distanzMatrix3();
            System.out.println(mv1.distanzVonKzuK(2, 4));
            System.out.println(mv1.getDistanzListe());
            System.out.println(mv1.getExzentritaetVomKnoten(true, 3));

            //            System.out.println(mv1.toString());
            //            System.out.println(mv1.toString());
            System.out.println(mv1.getDistanzListe().get(0).get(mv1.getDistanzListenGroesse()).toStringCSVMatrix());

        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTes001(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            mv1.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            mv1.getZentrum();

        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
        }
    }


}

