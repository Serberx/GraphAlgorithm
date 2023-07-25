package test;

import enumerations.PersistType;
import exception.GraphenException;
import model.BreitensucheTiegensuche;
import model.MatrixVerwaltung;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;
import persister.PersisterException;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
            System.out.println("---------------------Durchmesser---------------------");
            mv.durchmesser(true);
            System.out.println("---------------------Exzentritaeten---------------------");
            System.out.println(mv.exzentritaeten().get(0).toStringCSVMatrix2());
            System.out.println("---------------------Zentrum---------------------");
            mv.getZentrum();
            System.out.println("---------------------Bruecken---------------------");

            mv.getBruecken();
            //            mv.getArtikulation();

            //            System.out.println("---------------------toString---------------------");
            //            System.out.println(mv.toString());
            //            System.out.println("---------------------toString2---------------------");
            //            System.out.println(mv.toString2());
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testBaum01(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung01");
            mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            System.out.println(mv.getBrueckenAnzahl(true));
        }catch(GraphenException e){

        }catch(PersisterException e){
            exceptionThrown = true;
            throw new RuntimeException(e);
        }
        assert (!exceptionThrown);
    }

    @Test
    public void testBaum02(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung01");
            mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            System.out.println(mv.getBrueckenAnzahl(false));
            if(mv.getBaum()){
                System.out.println(mv.getBaum());
                exceptionThrown = true;
            }
        }catch(GraphenException e){

        }catch(PersisterException e){
            exceptionThrown = true;
            throw new RuntimeException(e);
        }
        assert (exceptionThrown);
    }

    @Test
    public void testBaum03(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung01");
            mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            System.out.println(mv.getBrueckenAnzahl(false));
            System.out.println(mv.getBaum());

        }catch(GraphenException e){

        }catch(PersisterException e){
            exceptionThrown = true;
            throw new RuntimeException(e);
        }
        assert (!exceptionThrown);
    }

    @Test
    public void dfsTest(){
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung01");
            mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");

            mv.dfsRecursive(4);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test001(){
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung01");
            mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");
            System.out.println(mv.getWegmatrix());
            mv.distanzMatrix3();
            System.out.println(mv.getDistanzListe().get(0).get(mv.getDistanzListenGroesse()).toStringCSVMatrix2());
        }catch(GraphenException e){
            throw new RuntimeException(e);
        }catch(PersisterException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checksumTest(){
        boolean testTrue = false;
        String sha1 = "9168ff53d789537db4f5233e7dfa5e860519c44b68132b70805218f842b00041";
        String sha2 = "9168ff53d789537db4f5233e7dfa5e860519c44b68132b70805218f842b00041";

        if(sha1.equals(sha2)){
            testTrue = true;
            System.out.println("Test completed!");
        }
        assert (testTrue);

    }

    @Test
    public void testHas(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\kuzus\\OneDrive\\Spengergasse\\5ABIF\\NVS1\\NVS_2\\software\\Neuer Ordner\\openSUSE-Leap-15.5-DVD-x86_64-Build491.1-Media.iso"));){
            byte[] bt = ois.readAllBytes();
            //            Object ob = ois.readObject();
            System.out.println(bt.hashCode());
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void randomZahlFinden(){
        int zaehler = 0;
        int a = 0;
        int port = (int) (Math.random()*10000);
        int alter = 0;

        Set<Integer> zaehlen = new HashSet<Integer>();
        Map<Integer, Integer> wievielmal = new HashMap<>();

        while(alter < 39){

            while(zaehler<11){

                if(port<1000000 && port>1024){


                    if(port<65535){
                        zaehler++;
                        if(zaehler == 1983 || zaehler == 10){
                            System.out.println("Nummer: "+(a++)+ " | Zahl: "+ port);
                        }
                    }

                }
                port = (int) (Math.random()*100000);
            }
            zaehler = 0;

            alter++;
        }
        System.out.println("maximus ereichtus!"+zaehler);

    }

}
