package test;

import enumerations.PersistType;
import exception.GraphenException;
import model.Matrix;
import model.MatrixVerwaltung;
import org.junit.Assert;
import org.junit.Test;
import persister.PersisterException;

import java.io.File;

public class FinalTests {



    @Test
    public void testAddMatrixVonVersuchsMatrix(){
        try {
            Matrix vm = VersuchsMatrix.mehrDimMatrix();
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung Matrix 1");
            mv1.add(vm);
            mv1.save(PersistType.CSV, "SU_Graph001");
//            mv1.load(PersistType.CSV, );
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMatrixVonPos(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("MV001");
            mv1.load(PersistType.CSV, "src"+File.separator+"export"+File.separator+"Su_Graph001.csv");
//            mv1.adjazenzmatrix2(1, mv1.getMatrix(0).getDimension());
            System.out.println(mv1.distanzVonKzuK(1,9));
            mv1.distanzMatrix3();
            System.out.println(mv1.getDistanzListe().get(0).get(4).toStringCSVMatrix());
            System.out.println(mv1.getDistanzListenGroesse());
//            System.out.println(mv1.toString());
//            mv1.distanzMatrix3();
//            System.out.println(  mv1.getDistanzListe().get(0).get(mv1.getDistanzListenGroesse()));
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }


    @Test
    public void testExzentritaet(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("MV001");
            mv1.load(PersistType.CSV, "src"+File.separator+"export"+File.separator+"Su_Graph001.csv");
//            System.out.println(mv1.exzentritaeten().get(0));
            mv1.getExzentritaetVomKnoten(true,3);
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    @Test
    public void testDurchmesser(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("MV001");
            mv1.load(PersistType.CSV, "src"+File.separator+"export"+File.separator+"Su_Graph001.csv");
            System.out.println(mv1.durchmesser2(true));
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    @Test
    public void testRadius(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("MV001");
            mv1.load(PersistType.CSV, "src"+File.separator+"export"+File.separator+"Su_Graph001.csv");
            System.out.println(mv1.radius(true));
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    @Test
    public void testExzentritaet2(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("MV001");
            mv1.load(PersistType.CSV, "src"+File.separator+"export"+File.separator+"Su_Graph001.csv");
            System.out.println(mv1.exzentritaeten());
            System.out.println("-------------------------");
            System.out.println(mv1.getExzentritaetenList());
            System.out.println("-------------------------");
            System.out.println(mv1.getExzentritaetVomKnoten(true,1));
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testZentrum(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("MV001");
            mv1.load(PersistType.CSV, "src"+File.separator+"export"+File.separator+"Su_Graph001.csv");
//            System.out.println(mv1.radius());
//            System.out.println(mv1.durchmesser());
//            System.out.println(mv1.getExzentritaetenList());
            mv1.getZentrum();
//            mv1.radius2(true);
          mv1.radius2(true);
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
