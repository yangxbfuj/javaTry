package com.yxb.ch14.s5_terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapCollector {
    static class IntValue {
        private int i = 0;

        IntValue(int i) {
            this.i = i;
        }

        public void add(int a) {
            this.i += a;
        }

        public int get() {
            return this.i;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Character> map = new RandomPair()
                .stream()
                .limit(8)
                .collect(Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);

        ArrayList<String> words = Stream.of("1", "2", "3") .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(words);

        words.stream().filter(s -> s.equals("cheese")) .forEach(System.out::println);
        HashMap<String, String> map1 = Stream.of("1", "2", "3").parallel().collect(HashMap::new, (l, s) -> l.put(s, s), HashMap::putAll);
        System.out.println(map1);
        // 当程序并行运行时，第一个函数将多次创建，所以第三个函数是用来合并结果的
        int x = Stream.of(1, 2, 3, 4).map(IntValue::new).parallel().collect(() -> new IntValue(0), (i, o) -> i.add(o.get()), (i, o) -> i.add(o.get())).get();
        System.out.println(x);
    }
}
