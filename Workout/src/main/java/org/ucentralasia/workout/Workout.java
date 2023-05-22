package org.ucentralasia.workout;

public class Workout {
    private String day;
    private int pushUps;
    private int pullUps;
    private int chinUps;
    private int squats;

    public Workout(String day, int pushUps, int pullUps, int chinUps, int squats) {
        this.day = day;
        this.pushUps = pushUps;
        this.pullUps = pullUps;
        this.chinUps = chinUps;
        this.squats = squats;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getPushUps() {
        return pushUps;
    }

    public void setPushUps(int pushUps) {
        this.pushUps = pushUps;
    }

    public int getPullUps() {
        return pullUps;
    }

    public void setPullUps(int pullUps) {
        this.pullUps = pullUps;
    }

    public int getChinUps() {
        return chinUps;
    }

    public void setChinUps(int chinUps) {
        this.chinUps = chinUps;
    }

    public int getSquats() {
        return squats;
    }

    public void setSquats(int squats) {
        this.squats = squats;
    }

    @Override
    public String toString() {
        return day + ": Push Ups - " + pushUps + ", Pull Ups - " + pullUps + ", Chin Ups - " + chinUps + ", Squats - " + squats;
    }
}
