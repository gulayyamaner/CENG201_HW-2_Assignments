package com.example.myapplication;

public class Scoreboard {
    private Player[] playerList;
    private int playerCount;
    private int maxPlayers;
    private static final int DEFAULT_SIZE = 20;

    public Scoreboard() {
        this.maxPlayers = 20;
        this.playerList = new Player[this.maxPlayers];
        this.playerCount = 0;
    }

    public Scoreboard(int var1) {
        this.maxPlayers = var1;
        this.playerList = new Player[this.maxPlayers];
        this.playerCount = 0;
    }

    public void addPlayer(Player var1) {
        if (var1 == null) {
            throw new IllegalArgumentException("Player cannot be null");
        } else {
            if (this.playerCount >= this.maxPlayers) {
                this.increaseCapacity();
            }

            this.playerList[this.playerCount++] = var1;
        }
    }

    private void increaseCapacity() {
        this.maxPlayers *= 2;
        Player[] var1 = new Player[this.maxPlayers];
        System.arraycopy(this.playerList, 0, var1, 0, this.playerCount);
        this.playerList = var1;
        int var10001 = this.maxPlayers / 2;
        System.out.println("Scoreboard capacity increased: " + var10001 + " -> " + this.maxPlayers);
    }

    public void sortScoreboard() {
        if (this.playerCount > 1) {
            this.quickSort(0, this.playerCount - 1);
        }
    }

    private void quickSort(int var1, int var2) {
        if (var1 < var2) {
            int var3 = this.partition(var1, var2);
            this.quickSort(var1, var3 - 1);
            this.quickSort(var3 + 1, var2);
        }
    }

    private int partition(int var1, int var2) {
        Player var3 = this.playerList[var2];
        int var4 = var1 - 1;

        for(int var5 = var1; var5 < var2; ++var5) {
            if (this.playerList[var5].getScore() > var3.getScore()) {
                ++var4;
                this.swap(var4, var5);
            }
        }

        this.swap(var4 + 1, var2);
        return var4 + 1;
    }

    private void swap(int var1, int var2) {
        Player var3 = this.playerList[var1];
        this.playerList[var1] = this.playerList[var2];
        this.playerList[var2] = var3;
    }

    public void printScoreboard() {
        System.out.println("=== SCOREBOARD (Sorted by Score) ===");
        System.out.println("Rank | ID | Name                     | Score");
        System.out.println("-----|----|--------------------------|-------");

        for(int var1 = 0; var1 < this.playerCount; ++var1) {
            Player var2 = this.playerList[var1];
            System.out.printf("%4d | %2d | %-24s | %6d%n", var1 + 1, var2.getId(), var2.getName(), var2.getScore());
        }

        System.out.println("=====================================");
        System.out.println("Total players: " + this.playerCount);
        System.out.println();
    }

    public Player getPlayerByRank(int var1) {
        return var1 >= 1 && var1 <= this.playerCount ? this.playerList[var1 - 1] : null;
    }

    public Player getTopPlayer() {
        return this.playerCount == 0 ? null : this.playerList[0];
    }

    public Player[] getPlayersByScoreRange(int var1, int var2) {
        int var3 = 0;

        for(int var4 = 0; var4 < this.playerCount; ++var4) {
            int var5 = this.playerList[var4].getScore();
            if (var5 >= var1 && var5 <= var2) {
                ++var3;
            }
        }

        Player[] var8 = new Player[var3];
        int var9 = 0;

        for(int var6 = 0; var6 < this.playerCount; ++var6) {
            int var7 = this.playerList[var6].getScore();
            if (var7 >= var1 && var7 <= var2) {
                var8[var9++] = this.playerList[var6];
            }
        }

        return var8;
    }

    public int getPlayerCount() {
        return this.playerCount;
    }

    public int getCapacity() {
        return this.maxPlayers;
    }

    public boolean isEmpty() {
        return this.playerCount == 0;
    }

    public void clear() {
        this.playerCount = 0;
        this.playerList = new Player[this.maxPlayers];
    }
}
