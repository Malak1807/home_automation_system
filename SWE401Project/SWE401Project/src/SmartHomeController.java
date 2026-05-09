
import java.util.ArrayList;



/**
 *
 * @author Malak
 */
public class SmartHomeController {
    ArrayList<Device> devices = new ArrayList<>();
    
    public void turnOn(long deviceID){
        for(int x = 0; x < devices.size() ; x++){
            if(devices.get(x).getDeviceID() == deviceID){
                devices.get(x).status = true;
            }
        }
    }
    
    public void turnOff(long deviceID){
        for(int x = 0; x < devices.size() ; x++){
            if(devices.get(x).getDeviceID() == deviceID){
                devices.get(x).status = false;
            }
        }
    }
    
    public void controlDevice(long deviceID, String action){
        for(int x = 0; x < devices.size() ; x++){
            if(devices.get(x).getDeviceID() == deviceID){
                devices.get(x).performAction(action);
            }
        }
    }
    
    public void addDevice(Device device){
        devices.add(device);
    }
    
    public void removeDevice(Device device){
        devices.remove(device);
    }
}
