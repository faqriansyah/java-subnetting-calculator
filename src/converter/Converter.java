package converter;

public class Converter {
    int[] specialNumber = {128, 64, 32, 16, 8, 4, 2, 1};

    public String convert(String p, int base) {
        if(base == 8) return binary_to_decimal(p);
        if(base == 2) return decimal_to_binary(Integer.parseInt(p));
        return null;
    }

    public String decimal_to_binary(int p) {
        StringBuilder bin = new StringBuilder();
        for(int i = 0; i < specialNumber.length; i++) {
            if(p > specialNumber[i]) {
                System.out.println(p + " - " + specialNumber[i]);
                p -= specialNumber[i];
                System.out.println("P value : " + p);
            }

            bin.append(p > specialNumber[i] ? "0" : "1");
        }
        return bin.toString();
    }

    public String binary_to_decimal(String p) {
        int res = 0;
        for (int i = 0; i < specialNumber.length; i++) {
            if(String.valueOf(p.charAt(i)).equals("1")) res += specialNumber[i];
            res += 0;
        }
        return String.valueOf(res);
    }
}
