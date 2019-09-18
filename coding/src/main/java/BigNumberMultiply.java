public class BigNumberMultiply {

    public static void main(String[] args) {
        System.out.println(multiply("123", "23"));
    }

    static String multiply(String x, String y) {

        int xLength = x.length();
        int yLength = y.length();
        String result = null;
        for (int i = yLength - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(y.charAt(i));
            String partial = multiplyPartial(x, digit);
            String partialWithZero = addZeros(partial, yLength - 1 - i);
            result = addPartials(partialWithZero, result);
        }

        return result;
    }
    private static String multiplyPartial(String x, int digit) {
        int carry = 0;
        char[] charArray = new char[x.length() + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = x.length() - 1; i >= 0; i--) {
            int xDigit = Character.getNumericValue(x.charAt(i));
            int resultPartialInt = (xDigit * digit + carry) % 10;
            carry = xDigit * digit / 10;
            charArray[i + 1] = Character.forDigit(resultPartialInt, 10);
        }
        charArray[0] = Character.forDigit(carry, 10);

        for (int i = 0; i < charArray.length; i++) {
            sb.append(Character.getNumericValue(charArray[i]));
        }
        return sb.toString();

    }

    private static String addZeros(String x, int numberOfZeros) {
        StringBuilder sb = new StringBuilder().append(x);
        for (int i = 0; i < numberOfZeros; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    private static String addPartials(String partial, String result) {

        if (result == null) return partial;
        int carry = 0;
        char[] charArray = new char[result.length() + 1];
        for (int i = result.length() - 1, j = partial.length() - 1; i >= 0; i--, j--) {

            System.out.println(i);
            int resultDigit = Character.getNumericValue(result.charAt(i));
            int partialDigit = Character.getNumericValue(partial.charAt(j));

            int r = (resultDigit + partialDigit + carry) % 10;
            carry = carry / 10;
            charArray[i + 1] = Character.forDigit(r, 10);
        }
        charArray[0] = Character.forDigit(carry, 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            sb.append(Character.getNumericValue(charArray[i]));
        }

        return sb.toString();

    }
}
