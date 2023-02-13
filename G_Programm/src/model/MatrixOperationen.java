package model;

import exception.GraphenException;

import java.util.List;
@FunctionalInterface
public interface MatrixOperationen{
    public void stringElementeHinzufuegen(List<String> wert) throws GraphenException;
}
