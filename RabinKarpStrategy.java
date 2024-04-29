import java.util.ArrayList;

class RabinKarpStringSearchStrategy<T> implements StringSearchStrategy<T> {
    @Override
    public boolean containsSubstring(T string, T substring) {
        String str = String.valueOf(string);
        String sub = String.valueOf(substring);
        
        if (sub.length() > str.length())
            return false;
        
        ArrayList<Integer> prefixResult = PrefixFunction(str, sub);
        return !prefixResult.isEmpty();
    }

    private ArrayList<Integer> PrefixFunction(String string, String substring) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        final int alphabetSize = 256;
        final int mod = 9973;

        int substringHash = ((int) substring.charAt(0)) % mod;
        int stringHash = ((int) string.charAt(0)) % mod;

        int firstIndexHash = 1;

        for (int i = 1; i < substring.length(); i++) {
            substringHash *= alphabetSize;
            substringHash += (int)substring.charAt(i);
            substringHash %= mod;

            stringHash *= alphabetSize;
            stringHash += (int)string.charAt(i);
            stringHash %= mod;

            firstIndexHash *= alphabetSize;
            firstIndexHash %= mod;
        }

        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (substringHash == stringHash && CompareText(string, i, substring))
                result.add(i);

            if (i != string.length() - substring.length()) {
                stringHash -= (((int)string.charAt(i)) * firstIndexHash) % mod;
                stringHash += mod;
                stringHash *= alphabetSize;
                stringHash += (int)string.charAt(i + substring.length());
                stringHash %= mod;
            }
        }

        return result;
    }

    private boolean CompareText(String string, int index, String substring) {
        for (int i = 0; i < substring.length(); i++)
            if (substring.charAt(i) != string.charAt(index + i))
                return false;
        return true;
    }
}
