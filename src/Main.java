import converter.Converter;
import filter.BinaryFilter;
import filter.DecimalFilter;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        System.out.println(converter.convert("255555", 2));
        System.out.println(converter.convert("00011000", 8));
    }
}