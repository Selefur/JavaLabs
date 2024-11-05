package org.example;

class TextFile {
    private String path;
    private String description;

    public TextFile(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }
}
