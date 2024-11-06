package org.example;

public class FileSystemBeispiel {
    public static void main(String[] args) {

        // Dateien erstellen
        File resume = new File("Resume.docx");
        File coverLetter = new File("CoverLetter.docx");
        File vacationPhoto = new File("Vacation.jpg");
        File readme = new File("Readme.txt");

        // Verzeichnisse erstellen
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");
        Directory photos = new Directory("Photos");

        // Dateien und Verzeichnisse hinzufügen
        documents.addComponent(resume);
        documents.addComponent(coverLetter);

        photos.addComponent(vacationPhoto);

        root.addComponent(documents);
        root.addComponent(photos);
        root.addComponent(readme);

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
