package test;

import exception.GraphenException;
import model.Matrix;
import model.MatrixVerwaltung;
import org.junit.Test;

public class TestMatrixVerwaltung{

    @Test
    public void VerwaltungNameNull(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung(null);
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void VerwaltungNameBlank(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("");
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
    @Test
    public void VerwaltungNameLow(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("a");
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void VerwaltungNameOK(){
        boolean exceptionThrown = false;
        try{
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            exceptionThrown = true;
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void VerwaltungMatrixList(){
        boolean exceptionThrown = false;
        try{
            Matrix mr = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.add(mr);
            mv.add(mr2);
            mv.add(mr3);        //DONE TODO
//            System.out.println(mv.getMatrixList());
//            System.out.println(mv.toString());
            exceptionThrown = true;
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void VerwaltungMatrixAddNull(){
        boolean exceptionThrown = false;
        try{
            Matrix mr1 = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.add(null);

        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void VerwaltungMatrixExists(){
        boolean exceptionThrown = false;
        try{
            Matrix mr1 = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.add(mr1);
            mv.add(mr1);

        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void VerwaltungMatrixOK(){
        boolean exceptionThrown = false;
        try{
            Matrix mr1 = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.add(mr1);
            mv.add(mr2);
            exceptionThrown = true;
            System.out.println(mv.getMatrixList());
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void VerwaltungMatrixDeleteNull(){
        boolean exceptionThrown = false;
        try{
            Matrix mr1 = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.delete(null);

            System.out.println(mv.getMatrixList());
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
    @Test
    public void VerwaltungMatrixDeleteIsEmpty(){
        boolean exceptionThrown = false;
        try{
            Matrix mr1 = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.delete(mr1);

            System.out.println(mv.getMatrixList());
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
    @Test
    public void VerwaltungMatrixDeleteDontExist(){
        boolean exceptionThrown = false;
        try{
            Matrix mr1 = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.add(mr1);
            mv.add(mr2);
            mv.delete(mr3);

            System.out.println(mv.getMatrixList());
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
    @Test
    public void VerwaltungMatrixDeleteOK(){
        boolean exceptionThrown = false;
        try{
            Matrix mr1 = new Matrix(5);
            Matrix mr2 = new Matrix(5);
            Matrix mr3 = new Matrix(5);
            MatrixVerwaltung mv = new MatrixVerwaltung("Verwaltung 1");
            mv.add(mr1);
            mv.add(mr2);
            mv.add(mr3);
            System.out.println(mv.getMatrixList());
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println(mv.delete(mr3));
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println(mv.getMatrixList());

            exceptionThrown = true;
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

}
