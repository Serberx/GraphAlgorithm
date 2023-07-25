package model;

import enumerations.PersistType;
import exception.GraphenException;
import persister.PersisterException;

public class BreitensucheTiegensuche{

    Matrix adjaMatrix;
    boolean[] visited;
    public BreitensucheTiegensuche() throws GraphenException, PersisterException{
        boolean[] visited = new boolean[adjaMatrix.getDimension()];
        MatrixVerwaltung mv = new MatrixVerwaltung("ML1");

        adjaMatrix = mv.getMatrixList().get(0);
    }


    // pass in visited, so the caller knows about the visited nodes

    // -> imagine a graph with several components
    public void dfsRecursive( int node) throws GraphenException{
       Matrix adja = adjaMatrix;
       boolean[] visit = visited;
        System.out.println("Visited "+node);
        visit[node] = true;

        for(int i = 0; i<adja.getDimension(); i++){
            if(adja.getElement(node,i) == 1 && !visit[i]){
                dfsRecursive(i);
            }

        }
    }
}
