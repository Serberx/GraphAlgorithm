# Graph Program

Ein Java-Programm zur Berechnung und Verwaltung von Graphen. Dieses Projekt bietet umfangreiche Funktionen für die
Arbeit mit Graphen, wie das Berechnen von Komponenten, das Verwalten und Löschen von Knoten sowie die Persistierung von
Matrizen in CSV- und Serienformaten.

## Inhaltsverzeichnis

- [Überblick](#überblick)
- [Funktionen](#funktionen)
- [Setup und Installation](#setup-und-installation)
## Überblick

Dieses Projekt bietet eine robuste Struktur zur Verwaltung und Analyse von Graphen mithilfe
von Matrizenoperationen. Der Fokus liegt auf der Berechnung und Visualisierung von Graph-Eigenschaften wie Weg-Matrizen,
Exzentrizitäten, Radius, Durchmesser und Komponenten eines Graphen. Das Programm ermöglicht auch das Speichern und Laden
von Graph-Daten in CSV- oder Serialisierungsformaten.

## Funktionen

### Matrizenverwaltung

Die Klasse `MatrixVerwaltung` bildet das Rückgrat des Programms und ermöglicht die Verwaltung und Analyse mehrerer
Graph-Matrizen. Sie bietet eine Reihe von wichtigen Funktionen zur Analyse von Graphenstrukturen, insbesondere durch
Matrizenoperationen. Zu den Hauptfunktionen gehören:

- **Berechnung der Wegmatrix**:
    - Die Methoden `getWegmatrix()` und `getWegmatrixLastMatrix()` berechnen die Erreichbarkeit von Knoten im Graphen.
      Sie erstellen die Wegmatrix, die angibt, ob es einen Weg zwischen zwei Knoten gibt, und berücksichtigen dabei auch
      gelöschte Knoten, wenn notwendig.

- **Komponentenberechnung**:
    - Die Methoden `getComponents()` und `getComponentsLastMatrix()` berechnen die Anzahl der zusammenhängenden
      Komponenten im Graphen. Dabei wird überprüft, wie viele separate Teilgraphen im Graphen existieren, sowohl mit als
      auch ohne gelöschte Knoten.

- **Knoten löschen**:
    - Mit der Methode `deleteNode()` kann ein Knoten aus dem Graphen entfernt werden. Das Löschen eines Knotens führt zu
      einer Neubewertung der Struktur des Graphen, da alle Berechnungen, die mit dem entfernten Knoten zusammenhängen,
      aktualisiert werden.

- **Berechnung von Radius und Durchmesser**:
    - Der **Durchmesser** des Graphen, der durch die Methode `durchmesser()` berechnet wird, stellt den größten Abstand
      zwischen zwei Knoten im Graphen dar.
    - Der **Radius**, berechnet mit der Methode `radius()`, ist der kleinste Abstand eines Knotens zum entferntesten
      Knoten.
    - Beide Werte werden unter Verwendung der Exzentritäten der Knoten berechnet, die durch die Methode
      `exzentritaeten()` ermittelt werden.

- **Artikulationen**:
    - Die Methode `getArtikulation()` identifiziert kritische Knoten, deren Entfernung den Graphen in mehrere Teile
      zerfallen lässt. Diese "Artikulationspunkte" sind entscheidend für die Konnektivität des Graphen und können durch
      die Entfernung eines einzelnen Knotens oder einer Kante die Struktur des Graphen ändern.

### Persistierung

Das Programm unterstützt die Persistierung von Matrizen im CSV- und Serienformat:

- **CSV-Persistierung**: Die Klasse `PersisterCSV` speichert Matrizen im CSV-Format und ermöglicht das einfache Lesen
  und Schreiben in Dateien.
- **Serialisierungs-Persistierung**: Die Klasse `PersisterSER` speichert Matrizen in einem binären Format, das die
  schnelle Speicherung und Wiederherstellung der Datenstruktur ermöglicht.

## Setup und Installation

### Voraussetzungen

- **Java 11 oder höher**: Dieses Programm benötigt eine Java-Entwicklungsumgebung (JDK 11+).
- **Maven**: Zum Verwalten von Abhängigkeiten und Bauen des Projekts.

### Installation und Ausführung

1. **Klonen Sie das Repository**:
   ```bash
   git clone https://github.com/username/graphprogram.git
