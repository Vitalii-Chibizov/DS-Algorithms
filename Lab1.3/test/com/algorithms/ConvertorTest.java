package com.algorithms;

import static org.junit.Assert.*;
import static com.algorithms.Convertor.*;

import org.junit.Test;

public class ConvertorTest {
    // TODO-Lab1.3: After completing test plan, implement unit tests.

    String[] binary = {"0", "1", "110", "1101", "100101"};
    String[] octal = {"0", "7", "10", "4321", "54321"};


    @Test
    public void convert_valid() {
        int[] expected = {0, 1, 6, 13, 37};
        for (int i = 0; i < expected.length; i++) {
            int actual = convert(binary[i], 2);
            assertEquals(expected[i], actual);
        }
    }

    @Test
    public void convertFromOctal_valid() {
        int[] expected = {0, 7, 8, 2257, 22737};
        for (int i = 0; i < expected.length; i++) {
            int actual = convert(octal[i], 8);
            assertEquals(expected[i], actual);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void convert_null() {
        convert(null,2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertBinary_nonDigitCharacter() {
        convert("11O1",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertOctal_nonDigitCharacter() {
        convert("7O5",8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertBinary_InvalidDigit_toBase() {
        convert("100102",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertOctal_InvalidDigit_toBase() {
        convert("2087",8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertBinary_overflow() {
        convert("10000000000000000000000000000000",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertOctal_overflow() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(convert("20000000000",8));
    }

}
