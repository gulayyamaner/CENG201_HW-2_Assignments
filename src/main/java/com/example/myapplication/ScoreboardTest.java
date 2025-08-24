package com.example.myapplication;

import java.io.PrintStream;

public class ScoreboardTest {
    public static void main(String[] var0) {
        System.out.println("=== PLAYER SCOREBOARD TEST ===\n");
        Scoreboard var1 = new Scoreboard();
        System.out.println("1. Adding 10 players...");
        var1.addPlayer(new Player(1, "Ahmet Yilmaz", 1250));
        var1.addPlayer(new Player(2, "Fatma Demir", 890));
        var1.addPlayer(new Player(3, "Mehmet Kaya", 2100));
        var1.addPlayer(new Player(4, "Ayse Ozkan", 750));
        var1.addPlayer(new Player(5, "Ali Celik", 1800));
        var1.addPlayer(new Player(6, "Zeynep Arslan", 950));
        var1.addPlayer(new Player(7, "Mustafa Sahin", 1650));
        var1.addPlayer(new Player(8, "Elif Yildiz", 1100));
        var1.addPlayer(new Player(9, "Burak Ozturk", 1400));
        var1.addPlayer(new Player(10, "Selin Korkmaz", 1950));
        System.out.println("10 players added successfully!\n");
        System.out.println("2. Unsorted scoreboard:");
        printUnsortedScoreboard(var1);
        System.out.println("3. Sorting with QuickSort...");
        long var2 = System.nanoTime();
        var1.sortScoreboard();
        long var4 = System.nanoTime();
        long var6 = (var4 - var2) / 1000000L;
        System.out.println("Sorting completed! Time: " + var6 + " ms\n");
        System.out.println("4. Sorted scoreboard:");
        var1.printScoreboard();
        System.out.println("5. Rank-based player search:");
        Player var8 = var1.getTopPlayer();
        if (var8 != null) {
            PrintStream var10000 = System.out;
            String var10001 = var8.getName();
            var10000.println("🏆 1st Place: " + var10001 + " (" + var8.getScore() + " points)");
        }

        Player var9 = var1.getPlayerByRank(3);
        if (var9 != null) {
            PrintStream var26 = System.out;
            String var29 = var9.getName();
            var26.println("🥉 3rd Place: " + var29 + " (" + var9.getScore() + " points)");
        }

        Player var10 = var1.getPlayerByRank(10);
        if (var10 != null) {
            PrintStream var27 = System.out;
            String var30 = var10.getName();
            var27.println("🔟 10th Place: " + var30 + " (" + var10.getScore() + " points)");
        }

        System.out.println();
        System.out.println("6. Score range search (1000-1500):");
        Player[] var11 = var1.getPlayersByScoreRange(1000, 1500);
        System.out.println("Players with scores between 1000-1500:");

        for(Player var15 : var11) {
            PrintStream var28 = System.out;
            String var31 = var15.getName();
            var28.println("  - " + var31 + ": " + var15.getScore() + " points");
        }

        System.out.println();
        System.out.println("7. Performance test:");
        System.out.println("Testing with 1000 players...");
        Scoreboard var21 = new Scoreboard(1000);
        var2 = System.nanoTime();

        for(int var22 = 1; var22 <= 1000; ++var22) {
            int var24 = (int)(Math.random() * (double)5000.0F) + 100;
            var21.addPlayer(new Player(var22, "Test Player " + var22, var24));
        }

        var4 = System.nanoTime();
        long var23 = (var4 - var2) / 1000000L;
        System.out.println("1000 players added in: " + var23 + " ms");
        var2 = System.nanoTime();
        var21.sortScoreboard();
        var4 = System.nanoTime();
        long var25 = (var4 - var2) / 1000000L;
        System.out.println("1000 players sorted in: " + var25 + " ms");
        System.out.println("Total time: " + (var23 + var25) + " ms");
        System.out.println("Average sorting time: " + (double)var25 / (double)1000.0F + " ms");
        System.out.println("\n=== TEST COMPLETED ===");
    }

    private static void printUnsortedScoreboard(Scoreboard var0) {
        System.out.println("=== SCOREBOARD (Unsorted) ===");
        System.out.println("ID | Name                     | Score");
        System.out.println("----|--------------------------|-------");

        for(int var1 = 0; var1 < var0.getPlayerCount(); ++var1) {
            Player var2 = var0.getPlayerByRank(var1 + 1);
            if (var2 != null) {
                System.out.printf("%2d | %-24s | %6d%n", var2.getId(), var2.getName(), var2.getScore());
            }
        }

        System.out.println("===============================");
        System.out.println("Total players: " + var0.getPlayerCount());
        System.out.println();
    }
}
