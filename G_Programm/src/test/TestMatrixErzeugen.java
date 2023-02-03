package test;

import exception.GraphenException;
import model.Matrix;
import org.junit.Test;

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
}
