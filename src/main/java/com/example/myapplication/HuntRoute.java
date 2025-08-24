package com.example.myapplication;

public class HuntRoute {
    private int routeId;
    private double distance;
    private int points;
    
    public HuntRoute(int id, double dist, int pts) {
        this.routeId = id;
        this.distance = dist;
        this.points = pts;
    }
    
    public int getId() {
        return routeId;
    }
    
    public double getDistance() {
        return distance;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setId(int id) {
        this.routeId = id;
    }
    
    public void setDistance(double dist) {
        this.distance = dist;
    }
    
    public void setPoints(int pts) {
        this.points = pts;
    }
    
    public String toTableRow() {
        return String.format("%2d | %8.1f | %6d", routeId, distance, points);
    }
    
    @Override
    public String toString() {
        return String.format("HuntRoute{id=%d, distance=%.1f km, points=%d}", routeId, distance, points);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HuntRoute other = (HuntRoute) obj;
        return routeId == other.routeId;
    }
    
    @Override
    public int hashCode() {
        return routeId;
    }
}
