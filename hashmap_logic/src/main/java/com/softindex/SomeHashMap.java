package com.softindex;

/**
 * Простой пример хэш-таблицы. Хеш-таблица имеет постоянный размер для хранения 16 элементов
 * Конфликты хеш-функции решаются с помощью стратегия открытой адресации. Хэш-функция использует остаток деления на 16.
 *
 * Для разрешения коллизии применяется линейное зондирование.
 * Когда слот помеченный хэш-функцией как занят, тогда алгоритм пытается найти пустой в этом массиве.
 * Когда нагрузки превышает значение 0.7% тогда производительность хеш-таблицы будет снижаться.
 */

public class SomeHashMap {

    private final int DEFAULT_CAPACITY;
    private Entry[] entries;
    private int size;

    public SomeHashMap() {
        DEFAULT_CAPACITY = 16;
        entries = new Entry[DEFAULT_CAPACITY];

        for (int i=0; i<DEFAULT_CAPACITY; ++i)
        {
            entries[i] = null;
        }
    }

    public void put(int key, long value){
        int hash = key % DEFAULT_CAPACITY;

        while (entries[hash]!=null
                && entries[hash].getKey()!=key)
        {
            hash = (hash+1) % DEFAULT_CAPACITY;
        }
        entries[hash] = new Entry(key, value);
        ++size;
    }

    public long get(int key) {
        int hash = key % DEFAULT_CAPACITY;

        while (entries[hash]!=null
                && entries[hash].getKey()!=key)
        {
            hash = (hash+1) % DEFAULT_CAPACITY;
        }

        if (entries[hash] == null)
            return -1;
        return entries[hash].getValue();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Entry entry : entries) {
            if (entry != null){
                sb.append(entry + ",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    class Entry {
        private int key;
        private long value;

        Entry(int key, long value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public long getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
