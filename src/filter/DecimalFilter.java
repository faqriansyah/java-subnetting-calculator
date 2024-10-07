package filter;

public class DecimalFilter{
    public static boolean test(String p) {
        return Integer.parseInt(p) <= 255;
     }
}
