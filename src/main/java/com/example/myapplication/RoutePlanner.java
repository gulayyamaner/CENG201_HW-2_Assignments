package com.example.myapplication;

public class RoutePlanner {
    private HuntRoute[] routeList;
    private int routeCount;
    private int maxRoutes;
    private static final int DEFAULT_SIZE = 20;

    public RoutePlanner() {
        this.maxRoutes = 20;
        this.routeList = new HuntRoute[this.maxRoutes];
        this.routeCount = 0;
    }

    public RoutePlanner(int var1) {
        this.maxRoutes = var1;
        this.routeList = new HuntRoute[this.maxRoutes];
        this.routeCount = 0;
    }

    public void addRoute(HuntRoute var1) {
        if (var1 == null) {
            throw new IllegalArgumentException("Route cannot be null");
        } else {
            if (this.routeCount >= this.maxRoutes) {
                this.expandCapacity();
            }

            this.routeList[this.routeCount++] = var1;
        }
    }

    private void expandCapacity() {
        this.maxRoutes *= 2;
        HuntRoute[] var1 = new HuntRoute[this.maxRoutes];
        System.arraycopy(this.routeList, 0, var1, 0, this.routeCount);
        this.routeList = var1;
        int var10001 = this.maxRoutes / 2;
        System.out.println("RoutePlanner capacity increased: " + var10001 + " -> " + this.maxRoutes);
    }

    public void sortRoutes() {
        if (this.routeCount > 1) {
            HuntRoute[] var1 = new HuntRoute[this.routeCount];
            this.mergeSort(0, this.routeCount - 1, var1);
        }
    }

    private void mergeSort(int var1, int var2, HuntRoute[] var3) {
        if (var1 < var2) {
            int var4 = (var1 + var2) / 2;
            this.mergeSort(var1, var4, var3);
            this.mergeSort(var4 + 1, var2, var3);
            this.merge(var1, var4, var2, var3);
        }
    }

    private void merge(int var1, int var2, int var3, HuntRoute[] var4) {
        int var5 = var1;
        int var6 = var2 + 1;
        int var7 = var1;

        while(var5 <= var2 && var6 <= var3) {
            if (this.routeList[var5].getDistance() <= this.routeList[var6].getDistance()) {
                var4[var7++] = this.routeList[var5++];
            } else {
                var4[var7++] = this.routeList[var6++];
            }
        }

        while(var5 <= var2) {
            var4[var7++] = this.routeList[var5++];
        }

        while(var6 <= var3) {
            var4[var7++] = this.routeList[var6++];
        }

        for(int var8 = var1; var8 <= var3; ++var8) {
            this.routeList[var8] = var4[var8];
        }
    }

    public void printRoutes() {
        System.out.println("=== HUNT ROUTES (Sorted by Distance) ===");
        System.out.println("ID | Distance  | Points");
        System.out.println("----|-----------|-------");

        for(int var1 = 0; var1 < this.routeCount; ++var1) {
            HuntRoute var2 = this.routeList[var1];
            System.out.println(var2.toTableRow());
        }

        System.out.println("================================");
        System.out.println("Total routes: " + this.routeCount);
        System.out.println();
    }

    public HuntRoute getRouteByRank(int var1) {
        return var1 >= 1 && var1 <= this.routeCount ? this.routeList[var1 - 1] : null;
    }

    public HuntRoute getClosestRoute() {
        return this.routeCount == 0 ? null : this.routeList[0];
    }

    public HuntRoute[] getRoutesByDistanceRange(double var1, double var3) {
        int var5 = 0;

        for(int var6 = 0; var6 < this.routeCount; ++var6) {
            double var7 = this.routeList[var6].getDistance();
            if (var7 >= var1 && var7 <= var3) {
                ++var5;
            }
        }

        HuntRoute[] var11 = new HuntRoute[var5];
        int var12 = 0;

        for(int var8 = 0; var8 < this.routeCount; ++var8) {
            double var9 = this.routeList[var8].getDistance();
            if (var9 >= var1 && var9 <= var3) {
                var11[var12++] = this.routeList[var8];
            }
        }

        return var11;
    }

    public double getTotalDistance() {
        double var1 = (double)0.0F;

        for(int var3 = 0; var3 < this.routeCount; ++var3) {
            var1 += this.routeList[var3].getDistance();
        }

        return var1;
    }

    public int getTotalPoints() {
        int var1 = 0;

        for(int var2 = 0; var2 < this.routeCount; ++var2) {
            var1 += this.routeList[var2].getPoints();
        }

        return var1;
    }

    public double getEfficiencyRatio() {
        double var1 = this.getTotalDistance();
        return var1 == (double)0.0F ? (double)0.0F : (double)this.getTotalPoints() / var1;
    }

    public int getRouteCount() {
        return this.routeCount;
    }

    public int getCapacity() {
        return this.maxRoutes;
    }

    public boolean isEmpty() {
        return this.routeCount == 0;
    }

    public void clear() {
        this.routeCount = 0;
        this.routeList = new HuntRoute[this.maxRoutes];
    }
}
