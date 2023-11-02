package edu.project1;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryTest {

    @Test
    void randomWordTest() {
        Dictionary dictionary = new DemoDictionary();

        String word = dictionary.randomWord();

        assertThat(word).isNotNull();
        assertThat(word.length()).isGreaterThan(1);
    }

    @Test
    void demoDictionaryTest() {
        Dictionary demoDictionary = new DemoDictionary();
        String[] contentOfDemoDictionary = {"java", "the", "best"};

        String wordFromDemoDictionary = demoDictionary.randomWord();
        boolean isContains = List.of(contentOfDemoDictionary).contains(wordFromDemoDictionary);

        assertThat(isContains).isTrue();
    }
}
