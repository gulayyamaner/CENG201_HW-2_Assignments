package com.example.myapplication;

public class TreasureHuntTest {
    public static void main(String[] var0) {
        System.out.println("=== TREASURE HUNT TEST ===\n");
        TreasureInventory var1 = new TreasureInventory();
        System.out.println("1. Adding 5 treasures...");
        var1.addTreasure(new Treasure(1, "Golden Amulet", 100));
        var1.addTreasure(new Treasure(2, "Silver Coin", 50));
        var1.addTreasure(new Treasure(3, "Diamond Ring", 200));
        var1.addTreasure(new Treasure(4, "Ruby Necklace", 150));
        var1.addTreasure(new Treasure(5, "Emerald Bracelet", 75));
        System.out.println("5 treasures added successfully!\n");
        System.out.println("2. Current inventory:");
        var1.printInventory();
        System.out.println("3. Treasure search test:");
        Treasure var2 = var1.findTreasure(3);
        if (var2 != null) {
            System.out.println("Found treasure with ID 3: " + String.valueOf(var2));
        } else {
            System.out.println("Treasure with ID 3 not found");
        }

        Treasure var3 = var1.findTreasure(99);
        if (var3 != null) {
            System.out.println("Found treasure with ID 99: " + String.valueOf(var3));
        } else {
            System.out.println("Treasure with ID 99 not found (expected)");
        }

        System.out.println();
        System.out.println("4. Treasure removal test:");
        Treasure var4 = var1.removeTreasure(2);
        if (var4 != null) {
            System.out.println("Removed treasure: " + String.valueOf(var4));
        } else {
            System.out.println("Treasure with ID 2 not found");
        }

        System.out.println();
        System.out.println("5. Updated inventory:");
        var1.printInventory();
        System.out.println("6. Performance test:");
        long var5 = System.nanoTime();

        for(int var7 = 100; var7 < 1100; ++var7) {
            var1.addTreasure(new Treasure(var7, "Test Treasure " + var7, var7 * 10));
        }

        long var13 = System.nanoTime();
        long var9 = (var13 - var5) / 1000000L;
        System.out.println("1000 treasures added in: " + var9 + " ms");
        System.out.println("Total treasure count: " + var1.getItemCount());
        System.out.println("Hash table capacity: " + var1.getCapacity());
        System.out.println();
        System.out.println("7. Search performance test:");
        var5 = System.nanoTime();

        for(int var11 = 0; var11 < 1000; ++var11) {
            var1.findTreasure(var11);
        }

        var13 = System.nanoTime();
        var9 = (var13 - var5) / 1000000L;
        System.out.println("1000 treasure searches in: " + var9 + " ms");
        System.out.println("Average search time: " + (double)var9 / (double)1000.0F + " ms");
        System.out.println("\n=== TEST COMPLETED ===");
    }
}
