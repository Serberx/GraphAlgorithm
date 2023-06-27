package test;

import enumerations.PersistType;
import exception.GraphenException;
import model.Matrix;
import model.MatrixVerwaltung;
import org.junit.Test;
import persister.PersisterException;

public class TestMatrixErzeugen{
  @Test
  public void dimTestLow(){
    boolean exceptionThrown = false;
    try{
      Matrix t1 = new Matrix(1);
      System.out.println(t1.getDimension());
    }catch(GraphenException e){
      exceptionThrown = true;
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    assert (exceptionThrown);
  }
  @Test
  public void dimTestHigh(){
    boolean exceptionThrown = false;
    try{
      Matrix t1 = new Matrix(11);
      System.out.println(t1.getDimension());
    }catch(GraphenException e){
      exceptionThrown = true;
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    assert (exceptionThrown);
  }
  @Test
  public void dimTestOK(){
    boolean exceptionThrown = false;
    try{
      Matrix t1 = new Matrix(5);
      System.out.println(t1.getDimension());
      System.out.println(t1.toStringCSVMatrix());
      exceptionThrown = true;
    }catch(GraphenException e){

      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    assert (exceptionThrown);
  }

  @Test
  public void testSchulGraf001(){
    try{
      MatrixVerwaltung mv = new MatrixVerwaltung();
      mv.load(PersistType.CSV, "src/export/Test_Demo2.csv");
//      mv.getZentrum();
//      mv.exzentritaeten();
      mv.radius(true);
//      mv.distanzMatrix3();
    }catch(GraphenException e){
      System.out.println(e.getMessage());
      e.getStackTrace();
    }catch(PersisterException e){
      System.out.println(e.getMessage());
      e.getStackTrace();
    }
  }
}
