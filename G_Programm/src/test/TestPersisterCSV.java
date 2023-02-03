package test;

import enumerations.PersistType;
import exception.GraphenException;
import model.MatrixVerwaltung;
import model.PersisterCSV;
import model.Matrix;
import org.junit.Test;
import persister.PersisterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestPersisterCSV{

//    @Test
//    public void testPersist(){
//        try{
//            Matrix m1 = new Matrix(5);
//            PersisterCSV persisterCSV = new PersisterCSV();
////            persisterCSV.persist(m1, "src/model/matrix.csv" );
//            MatrixVerwaltung mv1 = new MatrixVerwaltung("hrölo");
//            mv1.save(PersistType.CSV, "matriöx.csv");
//        }catch(GraphenException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }catch(PersisterException e){
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    public void saveNullfileName(){
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.save(PersistType.CSV, null);

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
    public void saveNullTypeName(){
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.save(null, "Name 1");

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
    public void saveFilenameBlank(){
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.save(PersistType.CSV, "");

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
    public void saveFilenameBlank2AndMoreCharacters(){
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.save(PersistType.CSV, "    ");

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
    public void saveEmptyList(){
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(4);
//            mv1.add(mx1);
            mv1.save(PersistType.CSV, "Test_2");

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
    public void saveFNF_Exception(){  //simulated with path which no exists: path = "Ö"+File.separator +"src" + File
        // .separator + "save" + File.separator + filename + ".ser";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.add(mx1);
            mv1.save(PersistType.CSV, "Test_2");

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
    public void saveGetPersisterNull(){ //simulated with set persisterMap.put(PersistType.SER, null);
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.add(mx1);
            mv1.save(PersistType.CSV, "Test_2");

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
    public void saveSEROK(){
        boolean exceptionThrwon = false;
        try{
            exceptionThrwon = true;
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Name1");
            Matrix mx1 = new Matrix(5);
            Matrix mx2 = new Matrix(6);
//            Matrix mx3 = new Matrix(4);
//            Matrix mx4 = new Matrix(8);
            mv1.add(mx1);
            mv1.add(mx2);
//            mv1.add(mx3);
//            mv1.add(mx4);
            //            DirectoryCreation.create("import");
            //            DirectoryCreation.create("load");
            mv1.save(PersistType.CSV, "graph11");
            //            mv1.save(null, "graph");

            //            System.out.println(mv1.getMatrixList());

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
    public void testLoadAdjazentMatrixOKPowerPersistNoTestingImp(){  //FunktionsTest des Adjazenz Matrix Persister nicht getestet!
        //        String pathname = "src/export/graph7.csv";
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung();
            mv1.load(PersistType.CSV, "src/export/Adjaz_graph12.csv");

            //            System.out.println( mv1.adjazenzmatrix2(0,5));
            //            System.out.println( mv1.adjazenzmatrix2(1,5));

            //            mv1.save(PersistType.CSV, "Adjaz_graph12");
            //            System.out.println( mv1.adjazenzmatrix2(0,5));
            List<Map<Integer, Matrix>> adjMat = new ArrayList<>();
            mv1.adjazenzmatrix2(0,2);
            adjMat = (mv1.getMapListe());
            //persistAdjazenzMatrix wurde nur auf die schnelle Programmiert! Noch nicht ausgetestet!!
            mv1.persistadjazenzMatrixMap(adjMat, PersistType.CSV, "10_er_Potenz_Matrix_1");
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
}
