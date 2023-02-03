package model;

import exception.GraphenException;

import java.util.List;

public interface MatrixOperationen{
    public void integerElementeHinzufuegen(int wert);
    public void stringElementeHinzufuegen(List<String> wert) throws GraphenException;
}
