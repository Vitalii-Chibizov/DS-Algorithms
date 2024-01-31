package com.algorithms;

public class Convertor {

    private static final String NULL_WARNING =
            "You passed null, fix it";
    private static final String NEGATIVE_VALUE =
            "You passed negative number, fix it";
    private static final String UNACCEPTABLE_DIGIT_VALUE =
            "You passed illegal digit, fix it";
    private static final String TOO_LARGE_VALUE =
            "Result is out of bound";

    public static int convert(String original, int base) {
        // check for null
        if (original == null) {
            throw new IllegalArgumentException(NULL_WARNING);
        }
        long result = 0;
        int positionValue = 1;
        char[] digits = original.toCharArray();
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(digits[i]);
            // check for legal digit
            if (digit < 0) {
                throw new IllegalArgumentException(NEGATIVE_VALUE);
            } else if (digit >= base) {
                throw new IllegalArgumentException(UNACCEPTABLE_DIGIT_VALUE);
            } else {
                result += digit * positionValue;
                if(result < 0){
                    throw new IllegalArgumentException(TOO_LARGE_VALUE);
                }
                positionValue *= base;
            }
        }
        return (int)result;
    }

}
