/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author User
 */
public enum Time {
    _0830("08:30", "09:50"),
    _1000("10:00", "11:20"),
    _1130("11:30", "12:50"),
    _0100("01:00", "02:20"),
    _0230("02:30", "03:50"),
    _0400("04:00", "05:20");
    
    
  private String startTime;
  private String endTime;
  
  private Time(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return this.name().replaceAll("_", "");
    }

  


}
