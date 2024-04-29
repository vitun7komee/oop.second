class NaiveStringSearchStrategy<T> implements StringSearchStrategy<T> {
    @Override
    public boolean containsSubstring(T string, T substring) {
        String str = String.valueOf(string);
        String sub = String.valueOf(substring);
        
        if (sub.length() > str.length())
            return false;
        
        int result = NaiveStringMatcher(str, sub);
        return result != -1;
    }

    private int NaiveStringMatcher(String string, String substring) {
        int stringLength = string.length();
        int subStringLength = substring.length();

        for (int i = 0; i <= stringLength - subStringLength; ++i) {
            int j = 0;
            while (j < subStringLength && string.charAt(i + j) == substring.charAt(j))
                ++j;
            if (j == subStringLength)
                return i;
        }

        return -1;
    }
}

// class NaiveStringSearchStrategy<T> implements StringSearchStrategy<T> {
//     @Override
//     public boolean containsSubstring(T string, T substring) {
//         String str = String.valueOf(string);
//         String sub = String.valueOf(substring);
//         return str.contains(sub);
//     }
// }

