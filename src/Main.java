import converter.DecimalBinaryConvert;

public class Main {
    public static void main(String[] args) {
        DecimalBinaryConvert decimalBinaryConvert = new DecimalBinaryConvert();
        decimalBinaryConvert.convert("11101111", 1);
        decimalBinaryConvert.convert("239", 2);
        System.out.println(decimalBinaryConvert.getArgument());
        System.out.println(decimalBinaryConvert.getResult(2));
        System.out.println(decimalBinaryConvert.getResult(1));
    }
}