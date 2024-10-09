package converter;

import filter.BinaryFilter;
import filter.DecimalFilter;

import java.util.ArrayList;

public class DecimalBinaryConvert implements Converter{
    int[] specialNumber = {128, 64, 32, 16, 8, 4, 2, 1};
    private final StringBuilder bin = new StringBuilder();
    private final ArrayList<String> argument = new ArrayList<>();
    private int dec = 0;

    @Override
    public String getResult(int target) {
        if(target == 1) return String.valueOf(dec);
        if(target == 2) return bin.toString();
        return null;
    }

    @Override
    public ArrayList<String> getArgument() {
        return argument;
    }

    @Override
    public void convert(String p, int target) {
        argument.add(p);
        if(target == 1) binary_to_decimal(p);
        if(target == 2) decimal_to_binary(Integer.parseInt(p));
    }

    private void decimal_to_binary(int p) {
        if(!DecimalFilter.test(String.valueOf(p))) throw new IllegalArgumentException("Cannot use non-decimal argument");
        for (int j : specialNumber) {
            if (p >= j) {
                bin.append("1");
                p -= j;
            } else {
                bin.append("0");
            }
        }
    }

    private void binary_to_decimal(String p) {
        if(!BinaryFilter.test(p))  throw new IllegalArgumentException("Cannot use non-binary argument");
        for (int i = 0; i < specialNumber.length; i++) {
            if(String.valueOf(p.charAt(i)).equals("1")) dec += specialNumber[i];
        }
    }
}
