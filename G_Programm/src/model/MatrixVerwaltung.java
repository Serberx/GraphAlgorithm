package model;

import constants.Constants;
import enumerations.PersistType;
import exception.GraphenException;
import persister.Persistable;
import persister.PersisterException;

import java.io.File;
import java.util.*;

/*
            IN DIESER KLASSE WERDEN DIE MATRIZEN GELADEN UND VERWALTET.
            NACH DEM LADEN, WERDEN DIE DATEN WEITER IN DIE MATRIX KLASSE GELEITET.
 */

public class  MatrixVerwaltung{
    private String name;
    private List<Matrix> matrixList;
    private Map<Integer, Matrix> adjaMatrix;
    private Map<PersistType, Persistable<List<Matrix>>> persisterMap;       ////////// 1    Context class
    //    private Persistable<List<Matrix>> matrixPersister;
    private List<Map<Integer, Matrix>> potenzListe;
    private List<Map<Integer, Matrix>> distanzListe;
    private int distanzListenGroesse;
    private List<Matrix> exzentritaetenList;

    public MatrixVerwaltung(String name) throws GraphenException{
        setName(name);
        matrixList = new ArrayList<>();
        initPersister();                                                    ////////// 3
        adjaMatrix = new HashMap<>();
        potenzListe = new ArrayList<>();
        distanzListe = new ArrayList<>();
    }

    public MatrixVerwaltung() throws GraphenException{
        setName("-default-");
        matrixList = new ArrayList<>();
        initPersister();                                                    ////////// 3
        adjaMatrix = new HashMap<>();
        potenzListe = new ArrayList<>();
        distanzListe = new ArrayList<>();
    }

    private void initPersister(){                                            ////////// 2
        persisterMap = new HashMap<>();
        persisterMap.put(PersistType.SER, new PersisterSER<>());
        persisterMap.put(PersistType.CSV, new PersisterCSV());
    }

    //getter
    public String getName(){
        return name;
    }

    public List<Matrix> getMatrixList(){        //Bei get getListe() Methode braucht es unbedingt eine toString der
        // Model-Klasse, sonst gibt die Verwaltungsklasse keine Liste aus. Ausgabe like adklfj@12312
        return matrixList;
    }

    //setter
    public void setName(String name) throws GraphenException{
        if(name != null){
            if(!name.isBlank()){
                if(name.length() > 1){
                    this.name = name;
                }else{
                    throw new GraphenException("setName() | Character length must be bigger than 1! Your input: " + name.length());
                }
            }else{
                throw new GraphenException("setName() | Name is blank!");
            }
        }else{
            throw new GraphenException("setName() | Null-Ref at name!");
        }
    }

    public void add(Matrix matrix) throws GraphenException{
        if(matrix != null){
            if(!matrixList.contains(matrix)){
                matrixList.add(matrix);
            }else{
                throw new GraphenException("add() | Matrix exists!");
            }
        }else{
            throw new GraphenException("add() | Null-Ref at add!");
        }
    }

    public Matrix getMatrix(int pos) throws GraphenException{ //todo
        if(pos >= 0 && pos <= matrixList.size()){
            if(!matrixList.isEmpty()){
                return matrixList.get(pos);
            }else{
                throw new GraphenException("Empty matrix-list!");
            }
        }else{
            throw new GraphenException("Position is out of ranger! You have only " + matrixList.size() + " items in " + "your list! Therefore position from 0 to " + (matrixList.size() - 1));
        }
    }

    private boolean pruefeMatrix(Matrix matrix) throws GraphenException{
        int tempZaehler = 0;
        if(matrix != null){
            if(matrix.getDimension() > 0){
                for(int i = 0; i < matrix.getDimension(); i++){
                    for(int k = 0; k < matrix.getDimension(); k++){
                        if(matrix.getElement(i, k) >= 0 && matrix.getElement(i, k) <= 2){
                            tempZaehler++;
                        }else{
                            throw new GraphenException("pruefeMatirx | Adjazenzmatrix is just set by 0 and 1! Your " + "Matrix has numbers bigger than 1 in line: " + (i + 1) + " and row: " + (k + 1));
                        }
                    }
                }
                if(tempZaehler == matrix.getDimension() * matrix.getDimension()){
                    return true;
                }
            }else{
                throw new GraphenException("pruefeMatrix | No dimension set!");
            }
        }else{
            throw new GraphenException("pruefeMatrix | Null-Ref. at matrix!");
        }
        return false;
    }

    public int[] knotenGrad(Matrix matrix) throws GraphenException{
        int[] tempGrad;
        //        StringBuilder builder = new StringBuilder();
        if(matrix != null){
            tempGrad = new int[matrix.getDimension()];
            int tempZeilenWert = 0;
            if(pruefeMatrix(matrix)){
                for(int i = 0; i < matrix.getDimension(); i++){
                    for(int k = 0; k < matrix.getDimension(); k++){
                        tempZeilenWert += matrix.getElement(i, k);
                    }
                    tempGrad[i] = tempZeilenWert;
                    tempZeilenWert = 0;
                    //                    System.out.println("Zeile " + (i + 1) + ": d(v)= " + tempGrad[i]); //in use
                    //                    builder.append("Zeile: ").append(i+1).append(": d(v)= ").append
                    //                    (tempGrad[i]).toString();
                }
                return tempGrad;
            }else{
                throw new GraphenException("knotenGrad | Matrix is not in right form! pruefeMatrix goes wrong!");
            }
        }else{
            throw new GraphenException("knotenGrad | Null-Ref. at matrix!");
        }
    }

    public void knotenGradAllMatrix() throws GraphenException{
        int[] tempGrad;
        int matrix = 1;
        StringBuilder builder = new StringBuilder();
        if(!matrixList.isEmpty()){
            for(Matrix mx: matrixList){
                tempGrad = new int[mx.getDimension()];
                int tempZeilenWert = 0;
                if(pruefeMatrix(mx)){
                    int[] oneMatrix = knotenGrad(mx);
                    //                    builder.append("Matrix: ").append(matrix).toString();
                    System.out.println("Matrix: " + matrix++);
                    for(int i = 0; i < oneMatrix.length; i++){
                        //                        builder.append(oneMatrix[i]).toString();
                        System.out.println("Line: " + (i + 1) + " d(v)=" + oneMatrix[i]);
                    }
                    //                    for(int i = 0; i <  mx.getDimension(); i++){
                    //                        for(int k = 0; k < mx.getDimension(); k++){
                    //
                    //                            tempZeilenWert += mx.getElement(i, k);
                    //                        }
                    //                        tempGrad[i] = tempZeilenWert;
                    //                        tempZeilenWert = 0;
                    //                        System.out.println("Zeile " + (i + 1) + ": d(v)= " + tempGrad[i]);
                    //                    }

                }else{
                    throw new GraphenException("knotenGradAllMatrix | Matrix is not in right form! pruefeMatrix goes "
                            + "wrong!");
                }
            }
        }else{
            throw new GraphenException("knotenGradAllMatrix | Empty matrix-List!");
        }
    }

    public void knotenGradExpectedMatrix(int pos) throws GraphenException{
        int[] tempGrad;
        int matrix = 1;
        StringBuilder builder = new StringBuilder();
        if(!matrixList.isEmpty()){
            if(pos >= 0 && pos < matrixList.size()){
                //                for(Matrix mx: matrixList){
                Matrix mx = getMatrix(pos);
                tempGrad = new int[mx.getDimension()];
                int tempZeilenWert = 0;
                if(pruefeMatrix(mx)){
                    int[] oneMatrix = knotenGrad(mx);
                    //                    builder.append("Matrix: ").append(matrix).toString();
                    System.out.println("Matrix at position: " + pos);
                    for(int i = 0; i < oneMatrix.length; i++){
                        //                        builder.append(oneMatrix[i]).toString();
                        System.out.println("Line: " + (i + 1) + " d(v)=" + oneMatrix[i]);
                    }
                    //                    for(int i = 0; i <  mx.getDimension(); i++){
                    //                        for(int k = 0; k < mx.getDimension(); k++){
                    //
                    //                            tempZeilenWert += mx.getElement(i, k);
                    //                        }
                    //                        tempGrad[i] = tempZeilenWert;
                    //                        tempZeilenWert = 0;
                    //                        System.out.println("Zeile " + (i + 1) + ": d(v)= " + tempGrad[i]);
                    //                    }

                }else{
                    throw new GraphenException("knotenGradExpectedMatrix | Matrix is not in right form! pruefeMatrix "
                            + "goes wrong!");
                }
                //                }
            }else{
                throw new GraphenException("knotenGradExpectedMatrix | Position is out of range! It must be between " + "0" + " and " + (matrixList.size() - 1) + ", your input: " + pos);
            }
        }else{
            throw new GraphenException("knotenGradExpectedMatrix | Empty matrix-List!");
        }
    }


    public int[] knotenGradLineSelect(int line) throws GraphenException{  //TODO Schlingen in die Berechnung
        // einbeziehen!
        int[] tempDegreeList = new int[0];
        if(line >= 1){
            int zaehler = 0;
            if(!matrixList.isEmpty()){
                for(Matrix mx: matrixList){
                    tempDegreeList = new int[matrixList.size()];
                    int[] oneMatrixDegree = knotenGrad(mx);
                    if(line <= mx.getDimension()){
                        System.out.println("Matrix: " + (zaehler + 1) + ", Line: " + line + " d(v)=" + oneMatrixDegree[line - 1]);
                        tempDegreeList[zaehler] = oneMatrixDegree[line - 1];
                    }
                    zaehler++;
                }
                return tempDegreeList;
            }else{
                throw new GraphenException("knotenGradLineSelect | Empty matrix-List!");
            }
        }else{
            throw new GraphenException("Line must be bigger than 0! Your input: " + line);
        }

    }

    public void adjazenzmatrix(int pos, int pot) throws GraphenException{
        if(!matrixList.isEmpty()){
            if(pos >= 0 && pos < matrixList.size()){
                if(pot >= 1 && pot < 100){
                    int laufVariable = 1;

                    adjaMatrix = new HashMap<>();
                    Matrix mx;
                    int sum = 0;
                    adjaMatrix.put(1, matrixList.get(pos));
                    //                int[] tempArray = new int[matrixList.get(0).getDimension()];

                    //                if(pot == 2){
                    for(int p = 1; p < pot; p++){
                        mx = new Matrix("# " + (p + 1) + " Weg Matrix", matrixList.get(pos).getDimension());
                        for(int i = 0; i < matrixList.get(pos).getDimension(); i++){
                            for(int j = 0; j < matrixList.get(pos).getDimension(); j++){
                                for(int k = 0; k < matrixList.get(pos).getDimension(); k++){
                                    //         sum += matrixList.get(zaehler).getElement(i, k) * matrixList.get
                                    //         (zaehler).getElement(k, j);
                                    sum += adjaMatrix.get(laufVariable).getElement(i, k) * adjaMatrix.get(1).getElement(k, j);

                                }
                                mx.setElement(i, j, sum);
                                sum = 0;
                            }
                        }
                        //                    add(mx);
                        adjaMatrix.put(laufVariable + 1, mx);
                        laufVariable++;
                    }
                    //                    }

                }else{
                    throw new GraphenException("Power of Potenzmatrix must be between 0 and 100! Your input: " + pot);
                }
            }else{
                throw new GraphenException("You have " + matrixList.size() + " Matrixes in your List! Position of " + "Potenzmatrix must be Bigger or same as 0 and smaller than " + (matrixList.size() - 1) + "! " + "Your input: " + pos);
            }
        }else{
            throw new GraphenException("adjazenzmatrix | Empty matrix list!");
        }
        potenzListe.add(adjaMatrix);


    }

    public List<Map<Integer, Matrix>> adjazenzmatrix2(int pos, int pot) throws GraphenException{
        if(!matrixList.isEmpty()){
            if(pos >= 0 && pos < matrixList.size()){
                if(pot >= 1 && pot < 100){
                    int laufVariable = 1;
                    adjaMatrix = new HashMap<>();
                    Matrix mx;
                    int sum = 0;


                    adjaMatrix.put(1, matrixList.get(pos));
                    //                int[] tempArray = new int[matrixList.get(0).getDimension()];

                    //                if(pot == 2){
                    for(int p = 1; p < pot; p++){
                        mx = new Matrix("# " + (p + 1) + " Weg Matrix", matrixList.get(pos).getDimension());
                        for(int i = 0; i < matrixList.get(pos).getDimension(); i++){
                            for(int j = 0; j < matrixList.get(pos).getDimension(); j++){
                                for(int k = 0; k < matrixList.get(pos).getDimension(); k++){
                                    //         sum += matrixList.get(zaehler).getElement(i, k) * matrixList.get
                                    //         (zaehler).getElement(k, j);
                                    sum += adjaMatrix.get(laufVariable).getElement(i, k) * adjaMatrix.get(1).getElement(k, j);

                                }
                                mx.setElement(i, j, sum);
                                sum = 0;
                            }
                        }
                        //                    add(mx);
                        adjaMatrix.put(laufVariable + 1, mx);
                        laufVariable++;
                    }
                    potenzListe.add(adjaMatrix);
                    //                    }
                }else{
                    throw new GraphenException("Power of Potenzmatrix must be between 0 and 100! Your input: " + pot);
                }
            }else{
                throw new GraphenException("You have " + matrixList.size() + " Matrixes in your List! Position of " + "Potenzmatrix must be Bigger or same as 0 and smaller than " + (matrixList.size() - 1) + "! " + "Your input: " + pos);
            }
        }else{
            throw new GraphenException("adjazenzmatrix | Empty matrix list!");
        }

        return potenzListe;

    }

    public void anzahlKantenfolgenVonKzuK() throws GraphenException{
        int zaehler = 0;
        if(!matrixList.isEmpty()){
            int[] grad = new int[matrixList.size()];
            //            if(!adjaMatrix.isEmpty()){
            for(Matrix mx: matrixList){
                int a = matrixList.indexOf(mx);
                for(int i = 1; i < mx.getDimension(); i++){
                    adjazenzmatrix(a, i);
                    for(int k = 0; k < mx.getDimension(); k++)
                        for(int j = 0; j < mx.getDimension(); j++){
                            if(potenzListe.get(i - 1).get(i).getElement(k, j) == i){
                                System.out.println("Kantenfolge " + i + " existiert von Kante " + (k + 1) + " bis " + (j + 1));

                            }
                        }
                }
                zaehler++;
            }
            //            }else{
            //                throw new GraphenException("anzahlKantenfolgenVonKzuK | Empty adjaMatrix list!");
            //            }

        }else{
            throw new GraphenException("anzahlKantenfolgenVonKzuK | Empty matrix list!");
        }

    }

    public void anzahlKantenfolgenVonKzuK2() throws GraphenException{
        int zaehler = 0;
        if(!matrixList.isEmpty()){
            //            if(!adjaMatrix.isEmpty()){
            for(Matrix mx: matrixList){
                int a = matrixList.indexOf(mx);
                for(int i = 1; i < mx.getDimension(); i++){
                    adjazenzmatrix(a, i);
                    for(int k = 0; k < mx.getDimension(); k++)
                        for(int j = 0; j < mx.getDimension(); j++){
                            if(potenzListe.get(i - 1).get(i).getElement(k, j) == i){
                                if(k != j){
                                    System.out.println("Kantenfolge " + i + " existiert von Kante " + (k + 1) + " bis "
                                            + (j + 1));
                                }
                            }
                        }
                }
                zaehler++;
            }
            //            }else{
            //                throw new GraphenException("anzahlKantenfolgenVonKzuK | Empty adjaMatrix list!");
            //            }

        }else{
            throw new GraphenException("anzahlKantenfolgenVonKzuK | Empty matrix list!");
        }

    }

    public void anzahlKantenfolgenTest(int weg) throws GraphenException{
        if(!matrixList.isEmpty()){
            if(weg > 0 && weg < Math.pow(matrixList.get(0).getDimension(), matrixList.get(0).getDimension())){
                adjazenzmatrix(0, weg);
                if(!potenzListe.isEmpty()){

                    if(weg > 1){
                        Matrix mx = potenzListe.get(0).get(weg - 1);
                        Matrix mx2 = potenzListe.get(0).get(weg);
                        for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                            for(int k = 0; k < matrixList.get(0).getDimension(); k++){
                                if(i != k){
                                    if(mx.getElement(i, k) == 0 && mx2.getElement(i, k) == weg || mx.getElement(i, k) == weg && mx2.getElement(i, k) == weg || mx2.getElement(i, k) == weg){
                                        System.out.println(weg + " mal Kantenfolge der Länge " + weg + " von Kante " + (i + 1) + " bis " + (k + 1));
                                    }
                                    if(mx.getElement(i, k) == 0 && mx2.getElement(i, k) == (weg - 1) || mx.getElement(i, k) == (weg - 1) || mx2.getElement(i, k) == (weg - 1)){
                                        System.out.println((weg - 1) + " mal Kantenfolge der Länge " + weg + " von " + "Kante " + (i + 1) + " bis " + (k + 1));
                                    }


                                    //                        if(mx.getElement(i, k) == 0 && mx2.getElement(i, k) ==
                                    //                        weg || mx.getElement(i, k) == weg && mx2.getElement(i,
                                    //                        k) == weg || mx2.getElement(i,k) == weg){
                                    //                            System.out.println(weg+" Kantenfolgen der Länge " +
                                    //                            weg + " von Kante " + (i + 1) + " bis " + (k + 1));
                                    //                        }
                                    //                        if(mx.getElement(i, k) == 0 && mx2.getElement(i, k) ==
                                    //                        (weg-1) || mx.getElement(i, k) == (weg-1) && mx2
                                    //                        .getElement(i, k) == (weg-1)){
                                    //                            System.out.println((weg-1)+" Kantenfolgen der Länge
                                    //                            " + (weg-1) + " von Kante " + (i + 1) + " bis " +
                                    //                            (k + 1));
                                    //                        }
                                }
                            }
                        }
                    }else{
                        Matrix mx = potenzListe.get(0).get(weg);
                        for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                            for(int k = 0; k < matrixList.get(0).getDimension(); k++){
                                if(i != k){
                                    if(mx.getElement(i, k) == weg){
                                        System.out.println(weg + " mal Kantenfolgen der Länge " + weg + " von Kante " + (i + 1) + " bis " + (k + 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            throw new GraphenException("anzahlKantenfolgenVonKzuK | Empty matrix list!");
        }
    }

    public void anzahlKantenfolgen(int weg) throws GraphenException{
        if(!matrixList.isEmpty()){
            if(weg > 0 && weg < Math.pow(matrixList.get(0).getDimension(), matrixList.get(0).getDimension())){
                adjazenzmatrix(0, weg);
                if(!potenzListe.isEmpty()){

                    if(weg > 1){
                        Matrix mx = potenzListe.get(0).get(weg - 1);
                        Matrix mx2 = potenzListe.get(0).get(weg);
                        for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                            for(int k = 0; k < matrixList.get(0).getDimension(); k++){
                                if(i != k){
                                    int a = mx.getElement(i, k);
                                    int b = mx2.getElement(i, k);
                                    if(a == 0 && b == weg - 1){
                                        System.out.println((weg - 1) + " mal Kantenfolge der Länge " + weg + " von " + "Kante " + (i + 1) + " bis " + (k + 1) + " Kürzeste Kantenfolge von " + "Kante " + (i + 1) + " bis " + (k + 1));
                                    }
                                    if(a == 0 && b == weg){
                                        System.out.println((weg) + " mal Kantenfolge der Länge " + weg + " von Kante "
                                                + (i + 1) + " bis " + (k + 1) + " Kürzeste Kantenfolge von Kante " + (i + 1) + " bis " + (k + 1));
                                    }
                                    if(a != 0 && b == weg - 1){
                                        System.out.println((weg - 1) + " mal Kantenfolge der Länge " + weg + " von " + "Kante " + (i + 1) + " bis " + (k + 1));
                                    }
                                    if(a != 0 && b == weg){
                                        System.out.println((weg) + " mal Kantenfolge der Länge " + weg + " von Kante "
                                                + (i + 1) + " bis " + (k + 1));
                                    }


                                    //                                    if(a == 0 && b == weg-1){
                                    //                                        System.out.println((weg-1) + " mal
                                    //                                        Kantenfolge der Länge " + weg + " von
                                    //                                        Kante " + (i + 1) + " bis " + (k + 1)+"
                                    //                                        Kürzeste Kantenfolge von Kante " + (i +
                                    //                                        1) + " bis " + (k + 1));
                                    //                                    }
                                    //                                    if(a == 0 && b == weg){
                                    //                                        System.out.println((weg) + " mal
                                    //                                        Kantenfolge der Länge " + weg + " von
                                    //                                        Kante " + (i + 1) + " bis " + (k + 1)+"
                                    //                                        Kürzeste Kantenfolge von Kante " + (i +
                                    //                                        1) + " bis " + (k + 1));
                                    //                                    }
                                    //                                    if(a != 0 && b == weg-1){
                                    //                                        System.out.println((weg - 1) + " mal
                                    //                                        Kantenfolge der Länge " + weg + " von
                                    //                                        Kante " + (i + 1) + " bis " + (k + 1));
                                    //                                    }
                                    //                                    if(a != 0 && b == weg){
                                    //                                        System.out.println((weg) + " mal
                                    //                                        Kantenfolge der Länge " + weg + " von
                                    //                                        Kante " + (i + 1) + " bis " + (k + 1));
                                    //                                    }


                                    //                        if(mx.getElement(i, k) == 0 && mx2.getElement(i, k) ==
                                    //                        weg || mx.getElement(i, k) == weg && mx2.getElement(i,
                                    //                        k) == weg || mx2.getElement(i,k) == weg){
                                    //                            System.out.println(weg+" Kantenfolgen der Länge " +
                                    //                            weg + " von Kante " + (i + 1) + " bis " + (k + 1));
                                    //                        }
                                    //                        if(mx.getElement(i, k) == 0 && mx2.getElement(i, k) ==
                                    //                        (weg-1) || mx.getElement(i, k) == (weg-1) && mx2
                                    //                        .getElement(i, k) == (weg-1)){
                                    //                            System.out.println((weg-1)+" Kantenfolgen der Länge
                                    //                            " + (weg-1) + " von Kante " + (i + 1) + " bis " +
                                    //                            (k + 1));
                                    //                        }
                                }
                            }
                        }
                    }else{
                        if(weg == 1){
                            Matrix mx = potenzListe.get(0).get(weg);
                            for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                                for(int k = 0; k < matrixList.get(0).getDimension(); k++){
                                    if(i != k){
                                        if(mx.getElement(i, k) == weg){
                                            System.out.println(weg + " mal Kantenfolgen der Länge " + weg + " von " + "Kante " + (i + 1) + " bis " + (k + 1));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            throw new GraphenException("anzahlKantenfolgenVonKzuK | Empty matrix list!");
        }
    }

    public void distanzMatrix(int weg) throws GraphenException{
        if(!matrixList.isEmpty()){
            adjazenzmatrix(0, weg);
            distanzListe = new ArrayList<>();
            adjaMatrix = new HashMap<>();
            Matrix dmx1 = new Matrix(matrixList.get(0).getDimension());
            if(!potenzListe.isEmpty()){
                for(int p = 0; p < potenzListe.get(0).size(); p++){
                    Matrix tempMx1 = new Matrix("Distanz #" + (p + 1) + "-", matrixList.get(0).getDimension());       //Neu-Instanz neu implementieren todo! Unten nochmal programmiert.
                    if(!adjaMatrix.isEmpty()){
                        for(int t = 0; t < tempMx1.getDimension(); t++){
                            for(int b = 0; b < tempMx1.getDimension(); b++){
                                tempMx1.setElementDistanzMatrix(t, b, adjaMatrix.get(p).getElement(t, b));
                            }
                        }
                    }

                    Matrix mx1 = potenzListe.get(0).get(p + 1);
                    Matrix mx2 = potenzListe.get(0).get(2);

                    for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                        for(int k = 0; k < matrixList.get(0).getDimension(); k++){
                            if(p < 1){
                                if(i != k){
                                    if(mx1.getElement(i, k) == 1){
                                        tempMx1.setElement(i, k, 1);
                                    }
                                    if(mx1.getElement(i, k) == 0){
                                        tempMx1.setElementDistanzMatrix(i, k, -1);
                                    }
                                }
                            }else{
                                if(!adjaMatrix.isEmpty()){
                                    if(i != k){
                                        if(mx1.getElement(i, k) != 0 && adjaMatrix.get(p).getElement(i, k) == -1){
                                            tempMx1.setElement(i, k, p + 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    adjaMatrix.put(p + 1, tempMx1);


                }
                distanzListe.add(0, adjaMatrix);

            }else{
                throw new GraphenException("distanzMatrix | Empty matrix map!");
            }
        }else{
            throw new GraphenException("distanzMatrix | Empty matrix list!");
        }
    }

    public void distanzMatrix2(int weg) throws GraphenException{
        if(!matrixList.isEmpty()){
            int tempZaehler = 1;
            if(weg > 0){
                adjazenzmatrix(0, weg);
                distanzListe = new ArrayList<>();
                Matrix mx1 = potenzListe.get(0).get(tempZaehler);
                Map<Integer, Matrix> tempDistanzMap = new HashMap<>();
                Matrix dmx1 = new Matrix("#" + tempZaehler + "er Distanz", matrixList.get(0).getDimension());
                for(int p = 0; p < potenzListe.get(0).size(); p++){
                    if(!potenzListe.get(0).isEmpty()){
                        if(tempZaehler == 1){

                            for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                                for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                                    if(i != j){
                                        if(mx1.getElement(i, j) == 1){
                                            dmx1.setElementDistanzMatrix(i, j, 1);
                                        }
                                        if(mx1.getElement(i, j) == 0){
                                            dmx1.setElementDistanzMatrix(i, j, -1);
                                        }
                                    }
                                }
                            }
                            tempDistanzMap.put(tempZaehler, dmx1);
                            tempZaehler++;
                        }

                        if(pruefeDistanzMatrix(tempDistanzMap.get(tempZaehler - 1))){
                            Matrix dmx2 = new Matrix("#" + tempZaehler + "er Distanz",
                                    matrixList.get(0).getDimension());

                            for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                                for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                                    dmx2.setElementDistanzMatrix(i, j,
                                            tempDistanzMap.get(tempZaehler - 1).getElement(i, j));
                                }
                            }

                            for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                                for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                                    if(i != j){
                                        if(potenzListe.get(0).get(tempZaehler).getElement(i, j) != 0 && tempDistanzMap.get(tempZaehler - 1).getElement(i, j) == -1){
                                            dmx2.setElementDistanzMatrix(i, j, tempZaehler);
                                        }
                                    }
                                }
                            }
                            tempDistanzMap.put(tempZaehler, dmx2);
                        }
                        tempZaehler++;
                    }
                }
                distanzListe.add(0, tempDistanzMap);
            }else{
                throw new GraphenException("distanzMatrix2 | weg must be bigger than 0!");
            }
        }else{
            throw new GraphenException("distanzMatrix2 | Empty matrix list!");
        }
    }

    public void distanzMatrix3() throws GraphenException{  //für Berechnungen in Benutzung
        if(!matrixList.isEmpty()){
            int tempZaehler = 1;
            int wegZaehler = 0;
            //            if(weg > 0){
            adjazenzmatrix(0, matrixList.get(0).getDimension());
            distanzListe = new ArrayList<>();
            Matrix mx1 = potenzListe.get(0).get(tempZaehler);
            Map<Integer, Matrix> tempDistanzMap = new HashMap<>();
            Matrix dmx1 = new Matrix("#" + tempZaehler + "er Distanz", matrixList.get(0).getDimension());

            for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                    if(i != j){
                        if(mx1.getElement(i, j) == 1){
                            dmx1.setElementDistanzMatrix(i, j, 1);
                        }
                        if(mx1.getElement(i, j) == 0){
                            dmx1.setElementDistanzMatrix(i, j, -1);
                        }
                    }
                }
            }
            tempDistanzMap.put(tempZaehler, dmx1);
            tempZaehler++;
            wegZaehler++;

            for(int p = 0; p < potenzListe.get(0).size(); p++){
                if(!potenzListe.get(0).isEmpty()){
                    if(wegZaehler < matrixList.get(0).getDimension() && pruefeDistanzMatrix(tempDistanzMap.get(tempZaehler - 1))){
                        if(tempZaehler == 1){
                            //                            Matrix dmx1 = new Matrix(matrixList.get(0).getDimension());


                        }else{
                            Matrix dmx2 = new Matrix("#" + tempZaehler + "er Distanz",
                                    matrixList.get(0).getDimension());

                            for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                                for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                                    dmx2.setElementDistanzMatrix(i, j,
                                            tempDistanzMap.get(tempZaehler - 1).getElement(i, j));
                                }
                            }

                            for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                                for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                                    if(i != j){
                                        if(potenzListe.get(0).get(tempZaehler).getElement(i, j) != 0 && tempDistanzMap.get(tempZaehler - 1).getElement(i, j) == -1){
                                            dmx2.setElementDistanzMatrix(i, j, tempZaehler);
                                        }
                                    }
                                }
                            }
                            tempDistanzMap.put(tempZaehler, dmx2);
                        }
                        tempZaehler++;
                        wegZaehler++;
                    }

                }
            }
            distanzListe.add(0, tempDistanzMap);
            distanzListenGroesse = distanzListe.get(0).size();
            //            }else{
            //                throw new GraphenException("distanzMatrix2 | weg must be bigger than 0!");
            //            }
        }else{
            throw new GraphenException("distanzMatrix2 | Empty matrix list!");
        }
    }

    public List<Map<Integer, Matrix>> getDistanzListe() throws GraphenException{
        if(!distanzListe.isEmpty()){
            //            List<Map<Integer, Matrix>> tempList;
            //            for(int i = 0; i<distanzListe.get(0).size();i++){
            //            tempList.add(distanzListe);
            //            }
            return distanzListe;
        }else{
            throw new GraphenException("wegMatrix | Empty matrix list!");
        }
    }


    public int getDistanzListenGroesse(){
        return distanzListenGroesse;
    }

    private boolean pruefeDistanzMatrix(Matrix mx) throws GraphenException{
        if(mx != null){
            if(!matrixList.isEmpty()){
                int tempZaehler = 0;
                for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                    for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                        if(mx.getElement(i, j) == -1){
                            return true;
                        }

                    }
                }
            }else{
                throw new GraphenException("prüfeDistanzMatrix | Empty matrixList at pruefeDistanzMatrix!");
            }
        }else{
            throw new GraphenException("prüfeDistanzMatrix | Null-Ref. at pruefeDistanzMatrix!");
        }
        return false;
    }

    public int distanzVonKzuK(int knoten1, int knoten2) throws GraphenException{
        //        int a;
        if(!matrixList.isEmpty()){
            if(knoten1 > 0 && knoten1 <= matrixList.get(0).getDimension()){
                if(knoten2 > 0 && knoten2 <= matrixList.get(0).getDimension()){
                    distanzMatrix3();
                    if(knoten1 != knoten2){
                        if(this.distanzListenGroesse > 0){
                            return getDistanzListe().get(0).get(this.distanzListenGroesse).getElement((Math.min(knoten1 - 1, knoten2 - 1)), (Math.max(knoten1 - 1, knoten2 - 1)));
                        }else{
                            throw new GraphenException("distanzVonKzuK | Empty distanzList!");
                        }
                    }else{
                        throw new GraphenException("distanzVonKzuK | Not allowed same vertices as input! Your input: "
                                + "Vertex1:" + knoten1 + ", Vertex2:" + knoten2);
                    }
                }else{
                    throw new GraphenException("distanzVonKzuK | Vertex2 degree must be between 0 and " + matrixList.get(0).getDimension() + ", Your input: " + knoten2);
                }
            }else{
                throw new GraphenException("distanzVonKzuK | Vertex1 degree must be between 0 and " + matrixList.get(0).getDimension() + ", Your input: " + knoten1);
            }
        }else{
            throw new GraphenException("distanzVonKzuK | Empty matrix list!");
        }
    }

    public List<Matrix> exzentritaeten() throws GraphenException{  //Hier wird nur eine Matrix mit nur den
        // Knotenwerten der Exzentritäten erzeugt!
        int tempEx = Integer.MIN_VALUE;
        int tempExAusgabe = Integer.MIN_VALUE;
        int tempKnoteni = 0;
        int tempKnotenj = 0;
        exzentritaetenList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        distanzListe = new ArrayList<>();
        if(!matrixList.isEmpty()){
            Matrix mx1 = new Matrix("Exzentritäten ", matrixList.get(0).getDimension());
            distanzMatrix3();
            if(!distanzListe.isEmpty()){  //Zum Testen wurde in dieser Methode die distanzMatrix3() abgewählt und die
                // distanzListe erzeugt, sonst NullPointerException!
                for(int i = 1; i < matrixList.get(0).getDimension() + 1; i++){
                    for(int j = 1; j < matrixList.get(0).getDimension() + 1; j++){
                        if(i != j){
                            if(distanzVonKzuK(i, j) > tempEx){
                                tempEx = distanzVonKzuK(i, j);
                                tempExAusgabe = distanzVonKzuK(i, j);
                                tempKnotenj = j;
                                tempKnoteni = i;
                                mx1.setElement(i - 1, j - 1, 0);
                            }else{
                                mx1.setElement(i - 1, j - 1, 0);
                            }
                        }else{
                            mx1.setElement(i - 1, j - 1, 0);
                        }
                    }
                    mx1.setElement(tempKnoteni - 1, tempKnotenj - 1, tempEx);
                    //                    System.out.println("Exzentrität vom Knoten "+i+" ist: "+tempEx+" | Vom
                    //                    Knoten "+i+" zu "+tempKnotenj );
                    //                    System.out.println("ex(" + tempKnoteni + ") = " + tempEx + " | [" +
                    //                    tempKnoteni + ", " + tempKnotenj + "]");  //In Verwendung
                    //                    tempKnotenj = 0;
                    tempEx = 0;
                    //                    builder.append("Exzentrität von Knoten "+i+" zu "+tempKnoten+ " ist:
                    //                    "+tempEx).toString();
                }
                exzentritaetenList.add(mx1);
            }else{
                throw new GraphenException("exzentritäten | Empty distanzList!");
            }
        }else{
            throw new GraphenException("exzentritäten | Empty matrixList!");
        }
        return exzentritaetenList;
    }

    public int getExzentritaetVomKnoten(int knoten) throws GraphenException{
        int a = 0;
        int tempKnoteni = 0;
        int tempKnotenj = 0;
        int tempEx = 0;
        //        exzentritaetenList = new ArrayList<>();
        if(!matrixList.isEmpty()){
            exzentritaeten();
            if(!exzentritaetenList.isEmpty()){      //Für Test exzentritäten() abgewählt und Liste erzeugt!
                if(knoten > 0 && knoten <= matrixList.get(0).getDimension()){
                    for(int k = 0; k < matrixList.get(0).getDimension(); k++){
                        if(exzentritaetenList.get(0).getElement(knoten - 1, k) != 0){
                            a = exzentritaetenList.get(0).getElement(knoten - 1, k);
                            System.out.println("ex(" + knoten + ") = " + a + " | [" + knoten + ", " + (k + 1) + "]");
                        }
                    }
                }else{
                    throw new GraphenException("getExzentritätVomKnoten | Vertex must be between 0 and " + matrixList.get(0).getDimension());
                }
            }else{
                throw new GraphenException("getExzentritätVomKnoten | Empty exentric list!");
            }
        }else{
            throw new GraphenException("getExzentritätVomKnoten | Empty matrixList!");
        }

        return a;
    }

    public int durchmesser() throws GraphenException{
        int tempDm = Integer.MIN_VALUE;
        int tempKnoteni = 0;
        int tempKnotenj = 0;
        if(!matrixList.isEmpty()){
            exzentritaeten();
            if(!exzentritaetenList.isEmpty()){
                for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                    for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                        if(getExzentritaetenList().get(0).getElement(i, j) > tempDm){
                            tempDm = getExzentritaetenList().get(0).getElement(i, j);
                            tempKnoteni = i;
                            tempKnotenj = j;
                        }
                    }
                }
            }else{
                throw new GraphenException("getExzentritätVomKnoten | Empty exentric list!");
            }
        }else{
            throw new GraphenException("getExzentritätVomKnoten | Empty matrixList!");
        }
        System.out.println("dm(G) = " + tempDm );
        return tempDm;
    }

    public int durchmesser2() throws GraphenException{
        int tempDm = Integer.MIN_VALUE;
        if(!matrixList.isEmpty()){
//            if(!distanzListe.isEmpty()){
                for(int i = 0; i<matrixList.get(0).getDimension();i++){
                    if(getExzentritaetVomKnoten(i+1 ) > tempDm){
                        tempDm = getExzentritaetVomKnoten(i+1 );
                    }
                }
//            }else{
//                throw new GraphenException("getExzentritätVomKnoten | Empty exentric list!");
//            }
        }else{
            throw new GraphenException("durchmesser2 | Empty matrixList!");
        }
        System.out.println("d(G)= "+tempDm);
        return tempDm;
    }

    public int radius() throws GraphenException{
        int tempRad = Integer.MAX_VALUE;
        if(!matrixList.isEmpty()){
            exzentritaeten();
            if(!exzentritaetenList.isEmpty()){
                for(int i = 0; i < matrixList.get(0).getDimension(); i++){
                    for(int j = 0; j < matrixList.get(0).getDimension(); j++){
                        if(getExzentritaetenList().get(0).getElement(i, j) <= tempRad && getExzentritaetenList().get(0).getElement(i, j) > 0){
                            tempRad = getExzentritaetenList().get(0).getElement(i, j);
//                            System.out.println("rad(G) = " + tempRad + "[" + (i + 1) + "," + (j + 1) + "]");   //Menge der Radius Knaten!
                        }
                    }
                }
            }else{
                throw new GraphenException("radius | Empty matrixList!");
            }
        }else{
            throw new GraphenException("getExzentritätVomKnoten | Empty matrixList!");
        }
        System.out.println("rad(G) = " + tempRad);
        return tempRad;
    }

    public int radius2() throws GraphenException{
        int tempRad = Integer.MAX_VALUE;
        if(!matrixList.isEmpty()){
            //            if(!distanzListe.isEmpty()){
            for(int i = 0; i<matrixList.get(0).getDimension();i++){
                if(getExzentritaetVomKnoten(i+1 ) < tempRad){
                    tempRad = getExzentritaetVomKnoten(i+1 );
                }
            }
            //            }else{
            //                throw new GraphenException("getExzentritätVomKnoten | Empty exentric list!");
            //            }
        }else{
            throw new GraphenException("getExzentritätVomKnoten | Empty matrixList!");
        }
        System.out.println("d(G)= "+tempRad);
        return tempRad;
    }

    public List<Matrix> getExzentritaetenList() throws GraphenException{
        if(!matrixList.isEmpty()){
            if(!exzentritaetenList.isEmpty()){
                return exzentritaetenList;
            }else{
                throw new GraphenException("getExzentritaetenList | Empty exentric list!");
            }
        }else{
            throw new GraphenException("getExzentritaetenList | Empty matrixList!");
        }
    }


    public Matrix delete(Matrix matrix) throws GraphenException{
        Matrix matrix1 = null;
        boolean removed = false;
        if(matrix != null){
            if(!matrixList.isEmpty()){
                Iterator<Matrix> iter = matrixList.listIterator();
                while(iter.hasNext()){
                    matrix1 = iter.next();
                    if(matrix.equals(matrix1)){
                        iter.remove();
                        removed = true;
                    }
                }
            }else{
                throw new GraphenException("delete() | Matrix list is empty!");
            }
        }else{
            throw new GraphenException("delete() | Null-Ref at delete!");
        }
        if(!removed){
            throw new GraphenException("Searched matrix dont exists in list!");
        }
        return matrix1;
    }

    public void save(PersistType type, String filename) throws GraphenException, PersisterException{
        String path = "";
        int zaehler = 1;

        if(filename != null && type != null){
            if(!filename.isBlank()){
                if(type.equals(PersistType.SER)){
                    path = "src" + File.separator + "save" + File.separator + filename + ".ser";
                }else{
                    path += "src" + File.separator + "export" + File.separator + filename + ".csv";
                }
                Persistable<List<Matrix>> persister = getPersister(type);
                if(persister != null){
                    if(!matrixList.isEmpty()){
                        persister.persist(matrixList, path); /*persisterMap.get(type).persist(matrixList, path);
                        same: new PersisterSER<>().persist(matrixList, path);*/
                    }else{
                        throw new GraphenException("save() | Empty matirxList!");
                    }
                }else{
                    throw new GraphenException("save() | Null-Ref at persist/getpersist()!");
                }
                //
            }else{
                throw new GraphenException("save() | Filename is blank!");
            }
        }else{
            throw new GraphenException("save() | Null-Ref at " + (filename == null ? "filename!" : "type!"));
        }
    }

    public void persistadjazenzMatrix(Map<Integer, Matrix> adjaMatrix, PersistType type, String filename) throws GraphenException, PersisterException{
        String path = "";
        int zaehler = 1;

        if(filename != null && type != null){
            if(!filename.isBlank()){
                if(type.equals(PersistType.SER)){
                    path = "src" + File.separator + "save" + File.separator + filename + ".ser";
                }else{
                    path += "src" + File.separator + "export" + File.separator + filename + ".csv";
                }
                Persistable<List<Matrix>> persister = getPersister(type);
                if(persister != null){
                    if(!matrixList.isEmpty()){
                        persister.persist2(adjaMatrix, path); /*persisterMap.get(type).persist(matrixList, path);
                        same: new PersisterSER<>().persist(matrixList, path);*/
                    }else{
                        throw new GraphenException("save() | Empty matirxList!");
                    }
                }else{
                    throw new GraphenException("save() | Null-Ref at persist/getpersist()!");
                }
                //
            }else{
                throw new GraphenException("save() | Filename is blank!");
            }
        }else{
            throw new GraphenException("save() | Null-Ref at " + (filename == null ? "filename!" : "type!"));
        }
    }

    public List<Map<Integer, Matrix>> getMapListe() throws GraphenException{
        if(!potenzListe.isEmpty()){
            return potenzListe;
        }else{
            throw new GraphenException("getMapListe | Empty List!");
        }
    }

    public void persistadjazenzMatrixMap(List<Map<Integer, Matrix>> dataMat, PersistType type, String filename) throws GraphenException, PersisterException{
        String path = "";
        int zaehler = 1;

        if(filename != null && type != null){
            if(!filename.isBlank()){
                if(type.equals(PersistType.SER)){
                    path = "src" + File.separator + "save" + File.separator + filename + ".ser";
                }else{
                    path += "src" + File.separator + "export" + File.separator + filename + ".csv";
                }
                Persistable<List<Matrix>> persister = getPersister(type);
                if(persister != null){
                    if(!matrixList.isEmpty()){
                        persister.persist3(dataMat, path); /*persisterMap.get(type).persist(matrixList, path);
                        same: new PersisterSER<>().persist(matrixList, path);*/
                    }else{
                        throw new GraphenException("save() | Empty matirxList!");
                    }
                }else{
                    throw new GraphenException("save() | Null-Ref at persist/getpersist()!");
                }
                //
            }else{
                throw new GraphenException("save() | Filename is blank!");
            }
        }else{
            throw new GraphenException("save() | Null-Ref at " + (filename == null ? "filename!" : "type!"));
        }
    }

    public void load(PersistType type, String filename) throws GraphenException, PersisterException{
        if(filename != null && type != null){
            Persistable<List<Matrix>> persister = getPersister(type);
            if(persister != null){
                try{
                    List<Matrix> matrixList1;
                    matrixList1 = persister.load(filename);
                    matrixList.addAll(matrixList1);
                }catch(NullPointerException e){
                    throw new GraphenException("Null-Ref.  returned by load in concrete class! " + e.getMessage(), e);
                }
            }else{
                throw new GraphenException("load() | Null-Ref at persister!");
            }
        }else{
            throw new GraphenException("load() | Null-Ref. at " + (type == null ? "type!" : "filename!"));
        }
    }

    public Persistable<List<Matrix>> getPersister(PersistType type){
        return persisterMap.get(type);
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Normal matrix list: -----------------------------------------\n");
        for(Matrix mx: matrixList){
            builder.append(mx.toStringCSVMatrix()).append(Constants.LINE_BREAK);
        }

        if(!potenzListe.isEmpty()){
            builder.append("Potenz matrix list: -----------------------------------------\n");
            for(int k = 0; k < potenzListe.size(); k++){
                for(int j = 1; j <= potenzListe.get(k).size(); j++){
                    builder.append(potenzListe.get(k).get(j).toStringCSVMatrix()).append(Constants.LINE_BREAK);
                }
            }
        }

        //        if(!adjaMatrix.isEmpty()){
        //            for(int i = 1; i < adjaMatrix.size(); i++){
        //                builder.append(adjaMatrix.get(i).toStringCSVMatrix());
        //            }
        //        }
        return builder.toString();
    }


    public String toString2(){
        StringBuilder builder = new StringBuilder();
        //        builder.append("Normal matrix list: -----------------------------------------\n");
        //        for(Matrix mx: matrixList){
        //            builder.append(mx.toStringCSVMatrix()).append(Constants.LINE_BREAK);
        //        }

        if(!potenzListe.isEmpty()){
            builder.append("Potenz matrix list: -----------------------------------------\n");
            for(int k = 0; k < potenzListe.size(); k++){
                for(int j = 1; j <= potenzListe.get(k).size(); j++){
                    builder.append(potenzListe.get(k).get(j).toStringCSVMatrix()).append(Constants.LINE_BREAK);
                }
            }
        }
        //        if(!adjaMatrix.isEmpty()){
        //            for(int i = 1; i < adjaMatrix.size(); i++){
        //                builder.append(adjaMatrix.get(i).toStringCSVMatrix());
        //            }
        //        }
        return builder.toString();
    }


}