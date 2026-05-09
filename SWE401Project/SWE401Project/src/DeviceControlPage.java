
import javax.swing.*;
import java.awt.*;

public class DeviceControlPage  extends JFrame{

    //constructer
    public DeviceControlPage(String deviceName, SmartHomeController controller){

        setTitle("Control " + deviceName);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Title
        JLabel title = new JLabel("Control " + deviceName, SwingConstants.CENTER);

        // Slider
        JSlider slider = new JSlider(0, 100, 50);

        // On/Off buttons
        JRadioButton onBtn = new JRadioButton("ON");
        JRadioButton offBtn = new JRadioButton("OFF");
        ButtonGroup group = new ButtonGroup();
        group.add(onBtn);
        group.add(offBtn);

        JPanel onOffPanel = new JPanel();
        onOffPanel.add(onBtn);
        onOffPanel.add(offBtn);

        // Apply button
        JButton applyBtn = new JButton("Apply");

        // Layout
        setLayout(new GridLayout(4, 1));
        add(title);
        add(slider);
        add(onOffPanel);
        add(applyBtn);
        
     
       applyBtn.addActionListener(e -> {
           long ID = 1;
           for(int x = 0; x < controller.devices.size() ; x++){
               if(controller.devices.get(x).deviceName.equals(deviceName)){
                   ID = controller.devices.get(x).deviceID;
               }
           }
           
           if (onBtn.isSelected()) {
               controller.turnOn(ID);
               System.out.println(deviceName + " turned on.");}
           
           else if (offBtn.isSelected()){
                controller.turnOff(ID);
                System.out.println(deviceName + " turned off.");
           }
               
       });
       
       setVisible(true);
       
    
}
    }
