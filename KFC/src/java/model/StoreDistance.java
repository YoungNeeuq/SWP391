/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class StoreDistance {
    private int store_id;
    private double distance;
    private double longtitude;
    private double latitude;

    public StoreDistance() {
    }

    public StoreDistance(int store_id, double distance, double longtitude, double latitude) {
        this.store_id = store_id;
        this.distance = distance;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "StoreDistance{" + "store_id=" + store_id + ", distance=" + distance + ", longtitude=" + longtitude + ", latitude=" + latitude + '}';
    }
    
}
