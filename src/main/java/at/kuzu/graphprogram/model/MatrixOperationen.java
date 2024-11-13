package at.kuzu.graphprogram.model;

import at.kuzu.graphprogram.exception.GraphenException;

import java.util.List;
@FunctionalInterface
public interface MatrixOperationen{
    public void stringElementeHinzufuegen(List<String> wert) throws GraphenException;
}
