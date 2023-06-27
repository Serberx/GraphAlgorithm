package model;

import persister.Persistable;
import persister.PersisterException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Concrete class
 */
public class PersisterSER<S> implements Persistable<S>{

    @Override
    public void persist(S data, String filename) throws PersisterException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(data);
        }catch(FileNotFoundException e){
            throw new PersisterException("PersisterSER | FNF Exception at persist()", e);
        }catch(IOException e){
            throw new RuntimeException("PersisterSER | IO Exception at persist", e);
        }
    }

    @Override
    public S load(String filename) throws PersisterException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            S data;
            data = (S) ois.readObject();

            return data;
            //            return (S) ois.readObject();
        }catch(FileNotFoundException e){
            throw new PersisterException("PersisterSER | FNF Exception at load! " + e.getMessage(), e);
        }catch(IOException e){
            throw new PersisterException("PersisterSER |  IO Exception at load! " + e.getMessage(), e);
        }catch(ClassNotFoundException e){
            throw new PersisterException("PersisterSER |  CNF Exception at load! " + e.getMessage(), e);
        }
    }

    @Override
    public void persist2(Map<Integer, Matrix> adjaMatrix, String path) throws PersisterException{

    }

    @Override
    public void persist3(List<Map<Integer, Matrix>> adjaMatrix, String path) throws PersisterException{

    }
}
