package edu.project1;

public class DemoDictionary implements Dictionary {

    private final String[] innerDictionary = {"java", "the", "best"};

    @Override
    public String randomWord() {
        return innerDictionary[(int) (Math.random() * innerDictionary.length)];
    }
}
