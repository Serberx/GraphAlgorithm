package test;

import enumerations.PersistType;
import exception.GraphenException;
import model.MatrixVerwaltung;
import org.junit.Test;
import persister.PersisterException;

import javax.swing.*;

public class TestFürLehrer{

    @Test
    public void test01_Knotengrad(){
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Matix01");

            mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");
//            mv.radius(true);
//            mv.getZentrum();
//            mv.distanzMatrix3();
//            mv.getArtikulation();
//            mv.exzentritaeten();
//            mv.durchmesser(true);
            mv.radius(true);
//            mv.radius2(true);
            mv.durchmesser(true);
            mv.getZentrum();
//            mv.getComponents(true);
            //            mv.delete()

            //            System.out.println(mv.toString());
            //            mv.getZentrum();
            //            mv.getWegmatrix().toStringCSVMatrix2();
            mv.getArtikulation();
//            mv.getComponentsLastMatrix(true);


        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testBruecken(){
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Matix01");
            mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");

            System.out.println("---------------------Radius---------------------");
            mv.radius(true);
            System.out.println("---------------------durchmesser---------------------");
            mv.durchmesser(true);
            System.out.println("---------------------exzentritaeten---------------------");
            System.out.println(mv.exzentritaeten().get(0).toStringCSVMatrix2());
            System.out.println("---------------------getZentrum---------------------");
            mv.getZentrum();

            mv.getBruecken();
//            mv.getArtikulation();
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
