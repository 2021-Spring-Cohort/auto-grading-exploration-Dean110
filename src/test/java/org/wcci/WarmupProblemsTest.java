package org.wcci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Watchable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WarmupProblemsTest {

    private WarmupProblems underTest;

    @BeforeEach
    void setUp() {
        underTest = new WarmupProblems();
    }

    @Test
    void stringTimes() {
        assertAll(
                ()-> assertThat(underTest.stringTimes("hi",2).equals("hihi")),
                ()-> assertThat(underTest.stringTimes("Hi", 3).equals("HiHiHi")),
                ()-> assertThat(underTest.stringTimes("Zizzer", 1).equals("Zizzer"))
        );
    }

    @Test
    @DisplayName("icyHot() acceptance tests.")
    void icyHot() {
        assertAll(
                ()-> assertThat(underTest.icyHot(120, -1)).withFailMessage("Given "+ 120 + " and " + -1 +" expected true.").isFalse(),
                ()-> assertThat(underTest.icyHot(-1, 120)).isTrue(),
                ()-> assertThat(underTest.icyHot(2, 120)).withFailMessage("Given "+ 2 + " and " + 120 +" expected false.").isFalse(),
                ()-> assertThat(underTest.icyHot(-10, 100)).isFalse(),
                ()-> assertThat(underTest.icyHot(0, 120)).isFalse(),
                ()-> assertThat(underTest.icyHot(200, 0)).isFalse()
        );
    }
}