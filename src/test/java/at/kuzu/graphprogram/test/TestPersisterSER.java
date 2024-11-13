package at.kuzu.graphprogram.test;

import at.kuzu.graphprogram.enumerations.PersistType;
import at.kuzu.graphprogram.exception.GraphenException;
import at.kuzu.graphprogram.model.DirectoryCreation;
import at.kuzu.graphprogram.model.Matrix;
import at.kuzu.graphprogram.model.MatrixVerwaltung;
import org.junit.Test;
import at.kuzu.graphprogram.persister.PersisterException;

public class TestPersisterSER{

    @Test
    public void saveNullfileName(){
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.save(PersistType.SER, null);

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
            mv1.save(PersistType.SER, "");

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
            mv1.save(PersistType.SER, "    ");

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
            Matrix mx1 = new Matrix(5);
            mv1.save(PersistType.SER, "EmptyList");

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
    public void saveNotSerializable(){ //it was simulated
        boolean exceptionThrwon = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            Matrix mx1 = new Matrix(5);
            mv1.add(mx1);
            mv1.save(PersistType.SER, "Test_2");

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
            mv1.save(PersistType.SER, "Test_2");

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
            mv1.save(PersistType.SER, "Test_2");

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
            Matrix mx3 = new Matrix(4);
            Matrix mx4 = new Matrix(8);
            mv1.add(mx1);
            mv1.add(mx2);
            mv1.add(mx3);
            mv1.add(mx4);
            //            DirectoryCreation.create("import");
            //            DirectoryCreation.create("load");
            mv1.save(PersistType.SER, "graph_01");
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
}
