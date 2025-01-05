package com.example.demo.designquestions.TicTacToeGame;

public class Pair<K, V> {
    private final K key;
    private final V value;

    // Constructor
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Overriding toString for easy printing
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    // Overriding equals to compare Pair objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!key.equals(pair.key)) return false;
        return value.equals(pair.value);
    }

    // Overriding hashCode for proper hashing
    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    // Static factory method to create a pair
    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }
}
