package com.back;

import java.util.ArrayList;

public class Calc {
    public static int run(String exp) {
        // a + b + c - ...
        // 1. 연산자를 저장함
        // 2. 부호를 저장함
        // 3. 피연산자를 읽고
        // 4. 연산자와 피연산자 사이에 부호 계산 진행
        // 5. 4번의 결과가 연산자로 다시 들어감

        ArrayList<Integer> params = new ArrayList<>();
        String moduler = ""; // 부호
        String[] expBits = exp.split(" "); // 공백을 기준으로 Token을 다 나눔

        for (int i = 0; i < expBits.length; i++) {
            if (i % 2 == 0) { // 연산자 저장
                params.add(Integer.parseInt(expBits[i])); // 숫자만 넣는 정수 arraylist 구현

                if (moduler.equals("+")) { // 0 1 값 계산하고 0으로 넣음, 1값 삭제
                    int num1 = params.get(0);
                    int num2 = params.get(1);
                    params.set(0, num1 + num2);
                    params.remove(1);
                } else if (moduler.equals("-")) { // 0 1 값 계산하고 0으로 넣음, 1값 삭제
                    int num1 = params.get(0);
                    int num2 = params.get(1);
                    params.set(0, num1 - num2);
                    params.remove(1);
                }
                else if(moduler.equals("*")) {
                    int num1 = params.get(0);
                    int num2 = params.get(1);
                    params.set(0, num1 * num2);
                    params.remove(1);
                }
            }

            else  {
                    if (expBits[i].equals("+")) {
                        moduler = "+";
                    } else if (expBits[i].equals("-")) {
                        moduler = "-";
                    }
                    else if(expBits[i].equals("*")) {
                        moduler = "*";
                    }
            }

        }

        return params.get(0);
    }
}

