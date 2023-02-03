package test;

import enumerations.PersistType;
import exception.GraphenException;
import model.Matrix;
import model.MatrixVerwaltung;
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
//            System.out.println(mv1.toString());
//            mv1.distanzMatrix3();
//            System.out.println(  mv1.getDistanzListe().get(0).get(mv1.getDistanzListenGroesse()));
        }catch(GraphenException|PersisterException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }


}
