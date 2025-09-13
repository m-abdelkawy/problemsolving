package com.problemsolving.w3global;

import java.util.Arrays;
import java.util.Collections;

public final class MakeItImmutable {

    private final char[] charArray;

    public MakeItImmutable(char[] value) {
        if (value == null || value.length == 0) {
            this.charArray = null;
        } else {
            this.charArray = Arrays.copyOf(value, value.length);
        }
    }

    public char[] getCharArray() {
        return Arrays.copyOf(charArray, charArray.length);
    }
}
