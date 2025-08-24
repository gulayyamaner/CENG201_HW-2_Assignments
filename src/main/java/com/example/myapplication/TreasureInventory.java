package com.example.myapplication;

import java.io.PrintStream;
import java.util.LinkedList;

public class TreasureInventory {
    private static final int INITIAL_SIZE = 16;
    private static final double MAX_LOAD = (double)0.75F;
    private LinkedList<Treasure>[] storage;
    private int itemCount;
    private int maxCapacity;

    public TreasureInventory() {
        this.maxCapacity = 16;
        this.storage = new LinkedList[this.maxCapacity];
        this.itemCount = 0;

        for(int var1 = 0; var1 < this.maxCapacity; ++var1) {
            this.storage[var1] = new LinkedList();
        }
    }

    public TreasureInventory(int var1) {
        this.maxCapacity = var1;
        this.storage = new LinkedList[this.maxCapacity];
        this.itemCount = 0;

        for(int var2 = 0; var2 < this.maxCapacity; ++var2) {
            this.storage[var2] = new LinkedList();
        }
    }

    private int getBucketIndex(int var1) {
        return Math.abs(var1) % this.maxCapacity;
    }

    public void addTreasure(Treasure var1) {
        if (var1 == null) {
            throw new IllegalArgumentException("Cannot add null treasure");
        } else {
            if ((double)this.itemCount / (double)this.maxCapacity >= (double)0.75F) {
                this.expandStorage();
            }

            int var2 = this.getBucketIndex(var1.getId());
            LinkedList<Treasure> var3 = this.storage[var2];

            for(Treasure var5 : var3) {
                if (var5.getId() == var1.getId()) {
                    var3.remove(var5);
                    var3.add(var1);
                    return;
                }
            }

            var3.add(var1);
            ++this.itemCount;
        }
    }

    public Treasure removeTreasure(int var1) {
        int var2 = this.getBucketIndex(var1);
        LinkedList<Treasure> var3 = this.storage[var2];

        for(Treasure var5 : var3) {
            if (var5.getId() == var1) {
                var3.remove(var5);
                --this.itemCount;
                return var5;
            }
        }

        return null;
    }

    public Treasure findTreasure(int var1) {
        int var2 = this.getBucketIndex(var1);

        for(Treasure var5 : this.storage[var2]) {
            if (var5.getId() == var1) {
                return var5;
            }
        }

        return null;
    }

    public void printInventory() {
        System.out.println("=== TREASURE INVENTORY ===");
        System.out.println("Total items: " + this.itemCount);
        System.out.println("Capacity: " + this.maxCapacity);
        PrintStream var10000 = System.out;
        Object[] var10002 = new Object[]{(double)this.itemCount / (double)this.maxCapacity};
        var10000.println("Load factor: " + String.format("%.2f", var10002));
        System.out.println();

        for(int var1 = 0; var1 < this.maxCapacity; ++var1) {
            LinkedList<Treasure> var2 = this.storage[var1];
            if (!var2.isEmpty()) {
                System.out.println("Bucket " + var1 + " (" + var2.size() + " items):");

                for(Treasure var4 : var2) {
                    System.out.println("  " + String.valueOf(var4));
                }

                System.out.println();
            }
        }

        System.out.println("========================");
    }

    private void expandStorage() {
        int var1 = this.maxCapacity;
        LinkedList<Treasure>[] var2 = this.storage;
        this.maxCapacity *= 2;
        this.storage = new LinkedList[this.maxCapacity];

        for(int var3 = 0; var3 < this.maxCapacity; ++var3) {
            this.storage[var3] = new LinkedList();
        }

        this.itemCount = 0;
        LinkedList<Treasure>[] var9 = var2;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            for(Treasure var8 : var9[var5]) {
                this.addTreasure(var8);
            }
        }

        System.out.println("Storage expanded: " + var1 + " -> " + this.maxCapacity);
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public int getCapacity() {
        return this.maxCapacity;
    }

    public boolean isEmpty() {
        return this.itemCount == 0;
    }
}
