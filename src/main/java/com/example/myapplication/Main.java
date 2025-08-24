package com.example.myapplication;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 CENG201 HOMEWORK ASSIGNMENTS - MAIN TEST SUITE");
        System.out.println("============================================================");
        System.out.println();
        
        // Test 1: Treasure Hunt System
        System.out.println("🏴‍☠️ TESTING TREASURE HUNT SYSTEM");
        System.out.println("----------------------------------------");
        try {
            TreasureHuntTest.main(args);
        } catch (Exception e) {
            System.out.println("❌ Treasure Hunt Test failed: " + e.getMessage());
        }
        System.out.println();
        
        // Test 2: Player Scoreboard System
        System.out.println("🏆 TESTING PLAYER SCOREBOARD SYSTEM");
        System.out.println("----------------------------------------");
        try {
            ScoreboardTest.main(args);
        } catch (Exception e) {
            System.out.println("❌ Scoreboard Test failed: " + e.getMessage());
        }
        System.out.println();
        
        // Test 3: Hunt Route Planner System
        System.out.println("��️ TESTING HUNT ROUTE PLANNER SYSTEM");
        System.out.println("----------------------------------------");
        try {
            RoutePlannerTest.main(args);
        } catch (Exception e) {
            System.out.println("❌ Route Planner Test failed: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("🎉 ALL TESTS COMPLETED!");
        System.out.println("============================================================");
        System.out.println("✅ Treasure Hunt System: Hash Table Implementation");
        System.out.println("✅ Player Scoreboard System: QuickSort Implementation");
        System.out.println("✅ Hunt Route Planner System: MergeSort Implementation");
        System.out.println("============================================================");
    }
}
