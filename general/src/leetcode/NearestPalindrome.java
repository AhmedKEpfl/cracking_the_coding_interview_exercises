package leetcode;

public class NearestPalindrome {

    public static void main(String args[]) {
        if(args.length != 1) {
            throw new IllegalArgumentException("You should provide one argument");
        }
        String argument = args[0];
        String result = getNearestPalindrome(argument);
        System.out.println("Closest palindrome is " + result);
    }

    public static String getNearestPalindrome(String n) {
        long nInteger;
        try {
            nInteger = Long.parseLong(n);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("The number provided should be an integer");
        }
        if(nInteger < 0) {
            return toStringNb(0);
        } else if(nInteger < 10) {
            return toStringNb(nInteger);
        }

        if(is10Power(n)) {
            return toStringNb(nInteger - 1);
        }
        if(nInteger < 10) {}
        int[] nArray = getArrayFromString(n);
        for(int i = 0; i < Math.ceil(nArray.length / 2f) - 1; i++) {
            nArray[nArray.length - i - 1] = nArray[i];
        }

        int bestDigit = -1;
        long bestDist = Integer.MAX_VALUE;
        for(int d = 0; d < 10; d++) {
            long value = getValueFromDigit(nArray, d);
            long dist = Math.abs(value - nInteger);
            if(dist < bestDist) {
                bestDist = dist;
                bestDigit = d;
            }
        }
        return toStringNb(getValueFromDigit(nArray, bestDigit));
    }

    private static boolean is10Power(String n) {
        if(n.charAt(0) != '1') {
            return false;
        }
        for(int i = 1; i < n.length(); i++) {
            if(n.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private static String toStringNb(long nb) {
        return "" + nb;
    }

    private static long getValueFromDigit(int[] nArray, int d) {
        int middleIndex = nArray.length / 2;
        if(nArray.length % 2 == 0) {
            nArray[middleIndex - 1] = d;
            nArray[middleIndex] = d;
        } else {
            nArray[middleIndex] = d;
        }
        return getValue(nArray);
    }

    private static long getValue(int[] nArray) {
        long power = 10;
        long base = 1;
        long result = 0;
        for(int i = nArray.length - 1; i >= 0; i--) {
            result += (nArray[i] * base);
            base *= power;
        }
        return result;
    }

    private static int[] getArrayFromString(String n) {
        int[] result = new int[n.length()];
        for(int i = 0; i < n.length(); i++) {
            result[i] = Integer.parseInt("" + n.charAt(i));
        }
        return result;
    }
}
