package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size + 1];
        itemsWithoutNull = Arrays.copyOf(items, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] addedAllFind = new Item[size + 1];
        int index = 0;
        for (int i = 0; i <= size; i++) {
            if (items[i].getName().equals(key)) {
                addedAllFind[index] = items[i];
                index++;
            }
        }
        return Arrays.copyOf(addedAllFind, index);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) return false;
        item.setId(items[index].getId());
        items[index] = item;
        return true;
    }
}