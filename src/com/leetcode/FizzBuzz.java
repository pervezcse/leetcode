package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        Map<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int i = 1; i <= n; i++) {
            String fizzBuzz = "";
            for (Integer key : map.keySet()) {
                if (i % key == 0) {
                    fizzBuzz += map.get(key);
                }
            }
            if ("".equals(fizzBuzz)) {
                fizzBuzz = String.valueOf(i);
            }
            result.add(fizzBuzz);
        }
        return result;
    }
}
