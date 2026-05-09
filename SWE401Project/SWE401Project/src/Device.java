/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Malak
 */
public class Device {
    long deviceID;
    String deviceName;
    Boolean status; // true for ON and false for OFF
    String location;

    public Device(long deviceID, String deviceName, String location) {
        this.deviceID = deviceID;
        this.deviceName = deviceName;
        this.location = location;
    }
    
    public void performAction(String action){
        
    }

    public long getDeviceID() {
        return deviceID;
    }
    
  
    
}
