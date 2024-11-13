package at.kuzu.graphprogram.test;

import at.kuzu.graphprogram.exception.GraphenException;
import at.kuzu.graphprogram.model.DirectoryCreation;
import org.junit.Test;

import java.io.File;

public class TestDirectoryCreation{

    @Test
    public void testDirectoryNull(){
        boolean exceptionThrown = false;
        try{
            DirectoryCreation.create(null);
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void testDirectoryBlank(){
        boolean exceptionThrown = false;
        try{
            DirectoryCreation.create("");
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void testDirectoryHigh(){
        boolean exceptionThrown = false;
        try{
            DirectoryCreation.create("aaaaaaaaaabbbbbbbbbbccccccccccZ");
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void testDirectoryOK(){
        boolean exceptionThrown = false;
        try{
            exceptionThrown = true;
            DirectoryCreation.create("import");
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void deleteNull(){
        boolean exceptionThrown = false;
        try{
            DirectoryCreation.delet(null);
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
    @Test
    public void deleteBlank(){
        boolean exceptionThrown = false;
        try{
            DirectoryCreation.delet("");
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
    @Test
    public void deleteHigh(){
        boolean exceptionThrown = false;
        try{
            DirectoryCreation.delet("aaaaaaaaaabbbbbbbbbbccccccccccZ");
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
    @Test
    public void deletePathDontExists(){
        boolean exceptionThrown = false;
        try{
            DirectoryCreation.delet("import2");
        }catch(GraphenException e){
            exceptionThrown = true;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }

    @Test
    public void deleteOK(){
        boolean exceptionThrown = false;
        try{
            exceptionThrown = true;
            DirectoryCreation.delet("import");
        }catch(GraphenException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert (exceptionThrown);
    }
}

