package org.example;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();
    private Directory parent; // verfolgt das übergeordnete Verzeichnis, um Zyklen zu erkennen

    public Directory(String name) {
        this.name = name;
    }

    // Übergeordnetes Verzeichnis festlegen (wird aufgerufen, wenn dies als Unterverzeichnis hinzugefügt wird)
    public void setParent(Directory parent) {
        this.parent = parent;
    }

    // Methode zum Hinzufügen eines Components (Datei oder Verzeichnis)
    public void addComponent(FileSystemComponent component) {

        if (component instanceof Directory) {
            Directory directory = (Directory) component;
            if (isDescendant(directory)) {
                System.out.println("Cannot add " + directory.getName() + " to " + name + " (circular reference detected)");
                return;
            }
            directory.setParent(this); // Elternobjekt festlegen, bevor es hinzugefügt wird
        }

        components.add(component);
        System.out.println("Added " + component.getName() + " to " + name);
    }

    // überprüft, ob durch das Hinzufügen eines Verzeichnisses ein Zyklus erstellt würde
    private boolean isDescendant(Directory directory) {
        Directory current = this;
        while (current != null) {
            if (current == directory) {
                return true; // ein Zyklus erkannt
            }
            current = current.parent;
        }
        return false;
    }

    // Methode zum Entfernen eines Components (Datei oder Verzeichnis)
    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
        System.out.println("Removed " + component.getName() + " from " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    // Struktur des Dateisystems anzeigen (rekursiv für alle Unterverzeichnisse und Dateien)
    @Override
    public void print(String path, String prefix) {

        if (name.equals("Root")) {
            System.out.println(name);
        } else {
            System.out.println("|");
            System.out.println(prefix + "-- " + name);
        }

        String newPrefix = "|";
        for (FileSystemComponent component : components) {
            component.print(path, newPrefix);
        }
    }
}
