package com.example.hustlers;

public class RecognitionObject {
    private String username;
    private String name;
    private SimilarityClassifier.Recognition recognition;

    public RecognitionObject(String username, String name, SimilarityClassifier.Recognition recognition) {
        this.username = username;
        this.name = name;
        this.recognition = recognition;
    }

    public String getUserName() {
        return username;
    }
    public String getName() {
        return name;
    }

    public SimilarityClassifier.Recognition getRecognition() {
        return recognition;
    }

    // You can also override toString() and other methods as needed.
}
