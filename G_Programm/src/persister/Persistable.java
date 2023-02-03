package persister;

import model.Matrix;

import java.util.List;
import java.util.Map;

/*
Strategy class
 */
public interface Persistable<S>{

    public void persist(S data, String filename) throws PersisterException;
    public S load(String filename) throws PersisterException;

    void persist2(Map<Integer, Matrix> adjaMatrix, String path) throws PersisterException;
    void persist3(List<Map<Integer, Matrix>> adjaMatrix, String path) throws PersisterException;
}
