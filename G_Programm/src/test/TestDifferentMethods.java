package test;

import org.junit.Test;

public class TestDifferentMethods{


    @Test
    public void IsAlphaNumeric(){
        if(Character.isDigit('8')){
            System.out.println("ja");
        }else{
            System.out.println("nein");
        }
    }
}
