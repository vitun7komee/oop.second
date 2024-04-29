class Solution<T> {
    private StringSearchStrategy<T> strategy;

    public Solution(StringSearchStrategy<T> strategy) {
        this.strategy = strategy;
    } 

    public void setStrategy(StringSearchStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public boolean containsSubstring(T string, T substring) {
        return strategy.containsSubstring(string, substring);
    }
}
