
import java.awt.Scrollbar;
import java.lang.reflect.Array;
import java.util.Scanner;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Malak
 */
public class Main extends Application{
    
    public SmartHomeController controller = new SmartHomeController();

    @Override
    public void start(Stage primaryStage){
        //create controller
        
        
         //create the five main appliances/devices
        Device d1 = new Device(1, "Lights", "Distributed");
        Device d2 = new Device(2, "AC", "Distributed");
        Device d3 = new Device(3, "TV", "Living Room");
        Device d4 = new Device(4, "Oven", "Kitchen");
        Device d5 = new Device(5, "Washing Machine", "Storage Room");
        
        //add devices to controller for control
        controller.addDevice(d1);
        controller.addDevice(d2);
        controller.addDevice(d3);
        controller.addDevice(d4);
        controller.addDevice(d5);
        
        //create nodes
        //text node
        Text title = new Text("Your Appliances                       ");
        title.setFont(Font.font("Courier New",FontWeight.BOLD, 30));
        title.setFill(Color.web("#429BBD"));
        
        //rectangle nodes
        Rectangle lights = new Rectangle(200, 200);
        Image img = new Image(getClass().getResourceAsStream("/allImages/lights.png"));
        lights.setFill(new ImagePattern(img));
        lights.setArcWidth(30);  // horizontal corner radius
        lights.setArcHeight(30); // vertical corner radius
        lights.setStroke(Color.NAVY);
       
        Rectangle AC = new Rectangle(200, 200);
        Image img2 = new Image(getClass().getResourceAsStream("/allImages/AC.jpg"));
        AC.setFill(new ImagePattern(img2));
        AC.setArcWidth(30);  // horizontal corner radius
        AC.setArcHeight(30); // vertical corner radius
        AC.setStroke(Color.NAVY);
        
        Rectangle TV = new Rectangle(200, 200);
        Image img3 = new Image(getClass().getResourceAsStream("/allImages/TV.png"));
        TV.setFill(new ImagePattern(img3));
        TV.setArcWidth(30);  // horizontal corner radius
        TV.setArcHeight(30); // vertical corner radius
        TV.setStroke(Color.NAVY);
        
        Rectangle oven = new Rectangle(200, 200);
        Image img4 = new Image(getClass().getResourceAsStream("/allImages/oven.png"));
        oven.setFill(new ImagePattern(img4));
        oven.setArcWidth(30);  // horizontal corner radius
        oven.setArcHeight(30); // vertical corner radius
        oven.setStroke(Color.NAVY);
        
        Rectangle washingMachine = new Rectangle(200, 200);
        Image img5 = new Image(getClass().getResourceAsStream("/allImages/washingMachine.png"));
        washingMachine.setFill(new ImagePattern(img5));
        washingMachine.setArcWidth(30);  // horizontal corner radius
        washingMachine.setArcHeight(30); // vertical corner radius
        washingMachine.setStroke(Color.NAVY);
        
        //button for adding new apliances node
        Button btn = new Button("Add New Appliance");
        btn.setStyle("-fx-background-color: #429BBD; -fx-text-fill: white; -fx-border-color: navy; -fx-border-radius: 10; -fx-background-radius: 10;");
        
        
        //create background for pane
        BackgroundFill b = new BackgroundFill(Color.web("#C7D9DA"), new CornerRadii(0),Insets.EMPTY);
        
        //create layout pane
        FlowPane pane = new FlowPane();
        pane.setPrefWidth(700);
        pane.setPrefHeight(500);
        pane.setHgap(10); // horizontal spacing
        pane.setVgap(10); // vertical spacing
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setBackground(new Background(b));
        
        //add nodes to pane
        pane.getChildren().addAll(title, lights, AC, TV, oven, washingMachine, btn);
        
        //events
        
         lights.setOnMouseClicked(e -> {
            new DeviceControlPage("Lights", controller);
        });
        
        AC.setOnMouseClicked(e -> {
            new DeviceControlPage("AC", controller);
        });
        
        TV.setOnMouseClicked(e -> {
            new DeviceControlPage("TV", controller);
        });
        
        oven.setOnMouseClicked(e -> {
            new DeviceControlPage("Oven", controller);
        });
        
        washingMachine.setOnMouseClicked(e -> {
            new DeviceControlPage("Washing Machine", controller);
        });
        
        //button event
        int[] counter = new int[1];
        counter[0] = 5;
        Scanner scan = new Scanner(System.in);
        btn.setOnMouseClicked(e -> {
            //ask about name of new appliance
            System.out.println("Appliance name: ");
            String name = scan.nextLine();
            
            //ask about location of new appliance
            System.out.println("Appliance location: ");
            String location = scan.nextLine();
            
            //create new device
            Device d = new Device(++counter[0], name, location);
            controller.addDevice(d);
            
            //create new rectangle for new device
            Rectangle r = new Rectangle(200, 200);
            r.setFill(Color.web("#429BBD"));
            r.setArcWidth(30);  // horizontal corner radius
            r.setArcHeight(30); // vertical corner radius
            r.setStroke(Color.NAVY);
            
            //add event for new rectangle
            r.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    new DeviceControlPage(name, controller);
                }
            });
            
            //new appliances will be displayed through text rather than images; unlike the main appliances
            Text label = new Text(name);
            label.setFill(Color.NAVY);
            label.setFont(Font.font("Courier New", 20));
            label.setX(50);
            label.setY(100);
            
            //rectangle and text are grouped
            Group g = new Group(r, label);     
            
            //remove button
            pane.getChildren().remove(btn);
            
            //add new rectangle for new device
            pane.getChildren().add(g);
            
            //add button again 
            pane.getChildren().add(btn);
        });
         
        //create scroll pane
        ScrollPane scroll = new ScrollPane(pane);
        scroll.setFitToWidth(true);   // automatically fit width to window
        
        //create scene
        Scene scene = new Scene(scroll, 700, 500);
        
        //Set stage
        primaryStage.setTitle("List of Appliances");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    

    public static void main (String[] args){
        
        launch(args);
        
    }
   
}
