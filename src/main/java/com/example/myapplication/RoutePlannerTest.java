package com.example.myapplication;

import java.io.PrintStream;

public class RoutePlannerTest {
    public static void main(String[] var0) {
        System.out.println("=== HUNT ROUTE PLANNER TEST ===\n");
        RoutePlanner var1 = new RoutePlanner();
        System.out.println("1. Adding 8 routes...");
        var1.addRoute(new HuntRoute(1, (double)2.5F, 150));
        var1.addRoute(new HuntRoute(2, 8.7, 300));
        var1.addRoute(new HuntRoute(3, 1.2, 100));
        var1.addRoute(new HuntRoute(4, 5.3, 250));
        var1.addRoute(new HuntRoute(5, 12.1, 500));
        var1.addRoute(new HuntRoute(6, 3.8, 180));
        var1.addRoute(new HuntRoute(7, 7.2, 280));
        var1.addRoute(new HuntRoute(8, 0.8, 80));
        System.out.println("8 routes added successfully!\n");
        System.out.println("2. Unsorted routes:");
        printUnsortedRoutes(var1);
        System.out.println("3. Sorting with MergeSort...");
        long var2 = System.nanoTime();
        var1.sortRoutes();
        long var4 = System.nanoTime();
        long var6 = (var4 - var2) / 1000000L;
        System.out.println("Sorting completed! Time: " + var6 + " ms\n");
        System.out.println("4. Sorted routes:");
        var1.printRoutes();
        System.out.println("5. Rank-based route search:");
        HuntRoute var8 = var1.getClosestRoute();
        if (var8 != null) {
            PrintStream var10000 = System.out;
            int var10001 = var8.getId();
            var10000.println("🗺️ Closest route: " + var10001 + " (Distance: " + var8.getDistance() + " km, Points: " + var8.getPoints() + ")");
        }

        HuntRoute var9 = var1.getRouteByRank(3);
        if (var9 != null) {
            PrintStream var26 = System.out;
            int var31 = var9.getId();
            var26.println("🥉 3rd Place: " + var31 + " (Distance: " + var9.getDistance() + " km, Points: " + var9.getPoints() + ")");
        }

        HuntRoute var10 = var1.getRouteByRank(8);
        if (var10 != null) {
            PrintStream var27 = System.out;
            int var32 = var10.getId();
            var27.println("🔟 10th Place: " + var32 + " (Distance: " + var10.getDistance() + " km, Points: " + var10.getPoints() + ")");
        }

        System.out.println();
        System.out.println("6. Distance range search (2.0-6.0 km):");
        HuntRoute[] var11 = var1.getRoutesByDistanceRange((double)2.0F, (double)6.0F);
        System.out.println("Routes with distance between 2.0-6.0 km:");

        for(HuntRoute var15 : var11) {
            PrintStream var28 = System.out;
            int var33 = var15.getId();
            var28.println("  - Treasure " + var33 + ": " + var15.getDistance() + " km, " + var15.getPoints() + " points");
        }

        System.out.println();
        System.out.println("7. Route statistics:");
        PrintStream var29 = System.out;
        Object[] var10002 = new Object[]{var1.getTotalDistance()};
        var29.println("Total distance: " + String.format("%.2f", var10002) + " km");
        System.out.println("Total points: " + var1.getTotalPoints() + " points");
        var29 = System.out;
        var10002 = new Object[]{var1.getEfficiencyRatio()};
        var29.println("Efficiency ratio: " + String.format("%.2f", var10002) + " points/km");
        System.out.println();
        System.out.println("8. Performance test:");
        System.out.println("Testing with 1000 routes...");
        RoutePlanner var21 = new RoutePlanner(1000);
        var2 = System.nanoTime();

        for(int var22 = 1; var22 <= 1000; ++var22) {
            double var24 = Math.random() * (double)50.0F + 0.1;
            int var16 = (int)(Math.random() * (double)1000.0F) + 50;
            var21.addRoute(new HuntRoute(var22, var24, var16));
        }

        var4 = System.nanoTime();
        long var23 = (var4 - var2) / 1000000L;
        System.out.println("1000 routes added in: " + var23 + " ms");
        var2 = System.nanoTime();
        var21.sortRoutes();
        var4 = System.nanoTime();
        long var25 = (var4 - var2) / 1000000L;
        System.out.println("1000 routes sorted in: " + var25 + " ms");
        System.out.println("Total time: " + (var23 + var25) + " ms");
        System.out.println("Average sorting time: " + (double)var25 / (double)1000.0F + " ms");
        System.out.println("\n=== TEST COMPLETED ===");
    }

    private static void printUnsortedRoutes(RoutePlanner var0) {
        System.out.println("=== HUNT ROUTES (Unsorted) ===");
        System.out.println("ID | Distance  | Points");
        System.out.println("----|-----------|-------");

        for(int var1 = 0; var1 < var0.getRouteCount(); ++var1) {
            HuntRoute var2 = var0.getRouteByRank(var1 + 1);
            if (var2 != null) {
                System.out.println(var2.toTableRow());
            }
        }

        System.out.println("================================");
        System.out.println("Total routes: " + var0.getRouteCount());
        System.out.println();
    }
}
