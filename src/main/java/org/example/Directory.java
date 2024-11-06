package org.example;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    // Methode zum Hinzufügen eines Components (Datei oder Verzeichnis)
    public void addComponent(FileSystemComponent component) {
        components.add(component);
        System.out.println("Added " + component.getName() + " to " + name);
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
        String currentPath = path + "/" + name;
        System.out.println(prefix + "+ " + name);

        String newPrefix = prefix + "| ";
        for (FileSystemComponent component : components) {
            component.print(currentPath, newPrefix);
        }
    }
}
