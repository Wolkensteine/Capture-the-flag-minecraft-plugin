package main.utils;

public class arrays {

    // This method appends an integer to an integer array
    public int[] append(int[] array, int number) {
        int[] tmp = new int[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = number;
        return tmp;
    }

    // This method appends a string to a string array
    public String[] append(String[] array, String number) {
        String[] tmp = new String[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = number;
        return tmp;
    }

}
