package com.example.myapplication;

public class Player {
    private int id;
    private String playerName;
    private int playerScore;
    
    public Player(int playerId, String name, int score) {
        this.id = playerId;
        this.playerName = name;
        this.playerScore = score;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return playerName;
    }
    
    public int getScore() {
        return playerScore;
    }
    
    public void setId(int playerId) {
        this.id = playerId;
    }
    
    @Override
    public String toString() {
        return String.format("Player{id=%d, name='%s', score=%d}", id, playerName, playerScore);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player other = (Player) obj;
        return id == other.id;
    }
    
    @Override
    public int hashCode() {
        return id;
    }
}
