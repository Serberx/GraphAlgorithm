package at.kuzu.graphprogram.test;

import org.junit.Test;

public class DifferentMethodTests{


    @Test
    public void IsAlphaNumeric(){
        if(Character.isDigit('8')){
            System.out.println("ja");
        }else{
            System.out.println("nein");
        }
    }
}
