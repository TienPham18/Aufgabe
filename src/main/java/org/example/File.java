package org.example;

public class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String path, String prefix) {
        System.out.println(prefix + "   |-- " + name);
    }
}
