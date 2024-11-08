package org.example;

public class FileSystemBeispiel {
    public static void main(String[] args) {

        // Dateien erstellen
        File resume = new File("Resume.docx");
        File resume1 = new File("Resume.docx");
        File coverLetter = new File("CoverLetter.docx");
        File vacationPhoto = new File("Vacation.jpg");

        // Verzeichnisse erstellen
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");
        Directory documents1 = new Directory("Documents");
        Directory photos = new Directory("Photos");
        Directory readme = new Directory("Readme.txt");

        // Dateien und Verzeichnisse hinzufügen
        documents.addComponent(resume);
        documents.addComponent(resume1);
        documents.addComponent(coverLetter);
        //documents.addComponent(root);

        photos.addComponent(vacationPhoto);
        //photos.addComponent(root);

        root.addComponent(documents);
        root.addComponent(photos);
        root.addComponent(readme);
        root.addComponent(documents1);

        // Struktur anzeigen
        System.out.println("\nStruktur des Dateisystems:");
        root.print("", "");

        // Demonstration des Entfernens eines Elements
        System.out.println("\nEntfernen von CoverLetter.docx aus Documents:");
        documents.removeComponent(coverLetter);
        //photos.removeComponent(vacationPhoto);
        //root.removeComponent(photos);

        // Aktualisierte Struktur anzeigen
        System.out.println("\nAktualisierte Struktur des Dateisystems:");
        root.print("", "");
    }

}
