package at.kuzu.graphprogram.test;

import at.kuzu.graphprogram.constants.Constants;
import at.kuzu.graphprogram.enumerations.PersistType;
import at.kuzu.graphprogram.exception.GraphenException;
import at.kuzu.graphprogram.model.Matrix;
import at.kuzu.graphprogram.model.MatrixVerwaltung;
import org.junit.jupiter.api.Test;
import at.kuzu.graphprogram.exception.PersisterException;
import java.io.File;

public class FinalTests{


    @Test
    public void testAddMatrixVonVersuchsMatrix(){
        try{
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
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
            //            mv1.adjazenzmatrix2(1, mv1.getMatrix(0).getDimension());
            System.out.println(mv1.distanzVonKzuK(1, 9));
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
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
            //            System.out.println(mv1.exzentritaeten().get(0));
            mv1.getExzentritaetVomKnoten(true, 3);
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
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
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
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
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
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
            System.out.println(mv1.exzentritaeten());
            System.out.println("-------------------------");
            System.out.println(mv1.getExzentritaetenList());
            System.out.println("-------------------------");
            System.out.println(mv1.getExzentritaetVomKnoten(true, 1));
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testZentrum(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("MV001");
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
            //            System.out.println(mv1.radius());
            //            System.out.println(mv1.durchmesser());
            //            System.out.println(mv1.getExzentritaetenList());
            //            mv1.getZentrum();
            //            mv1.radius(true);
            //            mv1.radius2(true);
            //          mv1.radius2(true);
            //          mv1.getZentrum();
            System.out.println(mv1.adjazenzmatrix2(0, 2));
            //            System.out.println(mv1.getExzentritaetVomKnoten(false, 2));
            //            System.out.println(mv1.knotenGrad(mv1.getMatrix(0)).toString());
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testZentrumEmptyList(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mx1 = new MatrixVerwaltung("Verwaltung 1");
            //            mx1.load(PersistType.CSV,  "src"+File.separator+"export"+File.separator+"Su_Graph001.csv");
            mx1.getZentrum();
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        } /*catch(PersisterException e) {
            throw new RuntimeException(e);
        }*/
        assert (exceptionThrown);
    }

    @Test
    public void testZentrumOk(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mx1 = new MatrixVerwaltung("Verwaltung 1");
            mx1.load(PersistType.CSV,
                     Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
            mx1.getZentrum();
            exceptionThrown = true;
        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            throw new RuntimeException(e);
        }
        assert (exceptionThrown);
    }

    @Test
    public void testDistanzTestFunkt(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"graph10.csv");
            mv1.distanzMatrix3();
            System.out.println(mv1.getPotenzMapListe().get(0).get(mv1.getDistanzListenGroesse()).toStringCSVMatrix());
            System.out.println(mv1.getExzentritaetVomKnoten(false, 4));
            //            System.out.println(mv1.distanzVonKzuK(1,5));
            exceptionThrown = true;
        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            throw new RuntimeException(e);
        }
        assert (exceptionThrown);
    }

    @Test
    public void testgetWegmatrix(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung001");
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"graph10.csv");
            //            mv1.getWegmatrix();
            //            mv1.adjazenzmatrix2(0, mv1.getMatrixList().get(0).getDimension());

            System.out.println(mv1.getWegmatrix().toStringCSVMatrix());
            System.out.println();
            System.out.println(mv1.getWegmatrix());

        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testgetComponents(){
        try{
            MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
            mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
//            System.out.println(mv1.getWegmatrix());
//            System.out.println(mv1.getComponents(true));
//            mv1.getZentrum();
            System.out.println(mv1.getWegmatrix());
//            mv1.getWegmatrix();
//            System.out.println(mv1.getComponents(true));
//            mv1.getComponents(false);
            mv1.getComponents(true);
            System.out.println(mv1.getComponentNumber());
//            System.out.println(mv1.getComponents(false));

        }catch(GraphenException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(PersisterException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMethode(){
     try{
         MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
         mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"graph10.csv");
//         System.out.println(mv1.getWegmatrix());
//         System.out.println(mv1.getComponents(false));
//         mv1.getComponents(true);
//         mv1.deleteNode(2);
//         System.out.println(mv1.getMatrixList().get(mv1.getMatrixList().size()-1));

         mv1.deleteNode(11);
         System.out.println(mv1.getWegmatrixLastMatrix());
         System.out.println(mv1.getComponentsLastMatrix(true));
//         mv1.getComponentsLastMatrix(true);
     }catch(GraphenException e){
         System.out.println(e.getMessage());
         e.printStackTrace();
     }catch(PersisterException e){
         throw new RuntimeException(e);
     }
    }

    @Test
    public void TestWegKomponents(){
     try{
         MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
         mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"graph10.csv");
         
         System.out.println(mv1.getWegmatrix());
         mv1.deleteNode(5);
         System.out.println(mv1.toString());
         mv1.getComponents(true);
         
         mv1.getComponentsLastMatrix(true);
         System.out.println(mv1.getMatrixList().get(0));
         mv1.getComponents(true);
         System.out.println(mv1.getMatrixList().get(mv1.getMatrixList().size()-1));
     }catch(GraphenException e){
         System.out.println(e.getMessage());
         e.printStackTrace();
     }catch(PersisterException e){
         throw new RuntimeException(e);
     }
    }

    @Test
    public void TestWegKomponents2(){
     try{
         MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
         mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
//         FileChooserUI fid = new BasicFileChooserUI();

//         System.out.println(mv1.getWegmatrix());                //(muss nicht aufgerufen werden, getComponents() ruft automatisch auf) Wegmatrix berechnen | 1. Element aus der matrixList
//         System.out.println(mv1.getComponents(true));     //Komponenten aus matrixList, ohne Knoten löschen.


//         mv1.deleteNode(3);                                     //Knoten Löschen, um Artikulation v Komponentenanzahl zu erhöhen. Funktioniert nur in Verbindung mit getComponentsLastMatrix und der abhängigen Methode getWegmatrixLastMatrix.
                                                                //Wenn ein Knoten gelöscht wird, dann nur mit den Methoden die "last" im Namen haben berechnen. Weil die neuberechnete Matrix in der matrixList hinten angestellt wird.
//         System.out.println(mv1.getWegmatrixLastMatrix());      //(muss nicht aufgerufen werden, getComponentsLastMatrix() ruft automatisch auf)
//         System.out.println(mv1.getComponentsLastMatrix(true));

//         mv1.radius(true);
//         mv1.durchmesser(true);
//        mv1.getZentrum();
        mv1.getArtikulation();
//         mv1.getArtikulation();


     }catch(GraphenException e){
         System.out.println(e.getMessage());
         e.printStackTrace();
     }catch(PersisterException e){
         throw new RuntimeException(e);
     }
    }


 @Test
    public void testArtik(){
     try{
         MatrixVerwaltung mv1 = new MatrixVerwaltung("Verwaltung 1");
         mv1.load(PersistType.CSV, Constants.PATH_EXPORT+File.separator+"SU_Graph001.csv");
         System.out.println(mv1.toString());
//         mv1.getWegmatrixLastMatrix();

         mv1.getArtikulation();
         System.out.println("========================================================");
         System.out.println(mv1.toString());

     }catch(GraphenException e){
         System.out.println(e.getMessage());
         e.printStackTrace();
     }catch(PersisterException e){
         throw new RuntimeException(e);
     }
    }




}
