package converter;

import filter.BinaryFilter;
import filter.DecimalFilter;

public class DecimalBinaryConvert implements Converter{
    int[] specialNumber = {128, 64, 32, 16, 8, 4, 2, 1};
    private final StringBuilder bin = new StringBuilder();
    private int dec = 0;

    @Override
    public String getResult() {
        return "";
    }

    @Override
    public String getArgument() {
        return "";
    }

    public String convert(String p, int base) {
        if(base == 10) return binary_to_decimal(p);
        if(base == 2) return decimal_to_binary(Integer.parseInt(p));
        return null;
    }

    /**
     * Converts a decimal integer into its binary string representation.
     * This method takes a decimal (base-10) integer and converts it into a binary string (base-2),
     * using a predefined array `specialNumber` to represent the binary digit positions. The method
     * iteratively checks if the decimal value is greater than or equal to each value in the `specialNumber`
     * array. If so, a '1' is appended to the binary result and the corresponding value is subtracted from
     * the input. Otherwise, a '0' is appended.
     * The `specialNumber` array contain values representing powers of 2, arranged in descending
     * order (from the most significant bit to the least significant bit).
     * Before the conversion, the method validates the input using a `DecimalFilter` to ensure that
     * the provided argument is a valid decimal number. If the validation fails, an `IllegalArgumentException`
     * is thrown.
     *
     * @param p The decimal integer to be converted to binary.
     * @return A binary string representation of the input decimal value.
     *
     * @throws IllegalArgumentException if the input value is not a valid decimal integer as per the
     *                                  `DecimalFilter` test.
     */
    public String decimal_to_binary(int p) {
        if(!DecimalFilter.test(String.valueOf(p))) throw new IllegalArgumentException("Cannot use non-decimal argument");
        for (int j : specialNumber) {
            if (p >= j) {
                bin.append("1");
                p -= j;
            } else {
                bin.append("0");
            }
        }
        return bin.toString();
    }

    /**
     * Converts a binary string representation into its decimal equivalent.
     * This method takes a binary string, where each character represents a bit (either '0' or '1'),
     * and converts it into a decimal (base-10) number. The conversion is done by comparing each
     * character in the input string to '1'. If the character is '1', the corresponding power
     * of 2 (from the `specialNumber` array) is added to the cumulative result.
     * The `specialNumber` array must contain values representing powers of 2 in decreasing
     * order, corresponding to the position of each bit in the binary number, starting from the
     * most significant bit (MSB).
     *
     * @param p The binary string to be converted. The string should only contain '0' and '1' characters.
     *          The length of the string must not exceed the length of the `specialNumber` array.
     * @return The decimal (base-10) representation of the binary input, as a String.
     *
     * @throws IllegalArgumentException if the input string contains invalid characters or exceeds
     *                                  the length of the `specialNumber` array.
     */
    public String binary_to_decimal(String p) {
        if(!BinaryFilter.test(p))  throw new IllegalArgumentException("Cannot use non-binary argument");
        for (int i = 0; i < specialNumber.length; i++) {
            if(String.valueOf(p.charAt(i)).equals("1")) dec += specialNumber[i];
        }

        return String.valueOf(dec);
    }
}
