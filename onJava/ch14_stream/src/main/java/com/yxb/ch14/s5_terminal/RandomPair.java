package com.yxb.ch14.s5_terminal;

import java.util.*;
import java.util.stream.*;

public class RandomPair {
    Random rand = new Random(47);
    Iterator<Character> capChars = rand.ints(65, 91)
            .mapToObj(i -> (char) i)
            .iterator();

    public Stream<Pair> stream() {
        return rand.ints(100, 1000).distinct().mapToObj(i -> new Pair(capChars.next(), i));
    }

}
