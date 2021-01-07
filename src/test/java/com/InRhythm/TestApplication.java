package com.InRhythm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class TestApplication {
    private SoftAssertions softAssertions;
    private final String input = "bbb aaaa";

    @Before
    public void beforeTest() {
        softAssertions = new SoftAssertions();
    }

    @After
    public void afterTest() {
        softAssertions.assertAll();
    }

    @Test
    public void one_biggest_word() {
        List<String> listOutput = LongestWord.getInput(input);
        softAssertions.assertThat(listOutput.get(0)).isEqualTo("2");
        softAssertions.assertThat(listOutput.get(1)).isEqualTo("aaaa");
    }

    @Test
    public void two_biggest_word() {
        List<String> listOutput = LongestWord.getInput(input + " aaaa");
        softAssertions.assertThat(listOutput.get(0)).isEqualTo("3");
        softAssertions.assertThat(listOutput.get(1)).isEqualTo("aaaa");
        softAssertions.assertThat(listOutput.get(2)).isEqualTo("aaaa");
    }

    @Test
    public void no_words() {
        List<String> listOutput = LongestWord.getInput("@ /.  *$");
        softAssertions.assertThat(listOutput.get(0)).isEqualTo("0");
    }

    @Test
    public void spesial_char_as_part_of_word() {
        List<String> listOutput = LongestWord.getInput("'" + input + "!'");
        softAssertions.assertThat(listOutput.get(0)).isEqualTo("2");
        softAssertions.assertThat(listOutput.get(1)).isEqualTo("aaaa");
    }

    @Test
    public void words_without_spase() {
        List<String> listOutput = LongestWord.getInput(input+".rrrr");
        softAssertions.assertThat(listOutput.get(0)).isEqualTo("3");
        softAssertions.assertThat(listOutput.get(1)).isEqualTo("aaaa");
        softAssertions.assertThat(listOutput.get(2)).isEqualTo("rrrr");
    }
}
