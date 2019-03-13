package com.springboot;

public class BinaryUtils {
    public static int x=0;

    /**
     * 二进制转十进制
     *
     * @param binaryNumber
     * @return
     */
    public static int BinaryToDecimal(int binaryNumber) {
        int decimal = 0;
        int p = 0;
        while (true) {
            if (binaryNumber == 0) {
                break;
            } else {
                int temp = binaryNumber % 10;
                decimal += temp * Math.pow(2, p);
                binaryNumber = binaryNumber / 10;
                p++;
            }
        }
        return decimal;
    }

    public static int decimalToBinary(int decimal) {
        toBinary(decimal);
        return x;
    }

    public static void toBinary(int num) {
        x = num % 2;
        if (num >= 2) {
            toBinary(num / 2);
        }
    }
}
