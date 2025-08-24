package com.example.myapplication;

public class Treasure {
    private int treasureId;
    private String treasureName;
    private int treasureValue;

    public Treasure(int var1, String var2, int var3) {
        this.treasureId = var1;
        this.treasureName = var2;
        this.treasureValue = var3;
    }

    public int getId() {
        return this.treasureId;
    }

    public String getName() {
        return this.treasureId;
    }

    public int getValue() {
        return this.treasureValue;
    }

    public void setId(int var1) {
        this.treasureId = var1;
    }

    public void setName(String var1) {
        this.treasureName = var1;
    }

    public void setValue(int var1) {
        this.treasureValue = var1;
    }

    public String toString() {
        return "Treasure{id=" + this.treasureId + ", name='" + this.treasureName + "', value=" + this.treasureValue + "}";
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 != null && this.getClass() == var1.getClass()) {
            Treasure var2 = (Treasure)var1;
            return this.treasureId == var2.treasureId;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.treasureId;
    }
}
