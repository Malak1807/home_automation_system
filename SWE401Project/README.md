# Smart Home Automation System

A JavaFX desktop application for monitoring and controlling smart home appliances. Built as part of SWE 401 at Abu Dhabi University.

## Overview

The application presents a visual dashboard of household appliances. Users can view all registered devices at a glance, click any device to open its control panel, and add new custom appliances at runtime. Each device control panel provides an ON/OFF toggle and an intensity slider.

## Project Structure

```
SWE401Project/
├── src/
│   ├── Main.java                   # Application entry point; builds the main dashboard UI
│   ├── Device.java                 # Device model (ID, name, location, status)
│   ├── SmartHomeController.java    # Controller managing the device list (add, remove, turn on/off)
│   ├── DeviceControlPage.java      # Per-device control window (Swing JFrame)
│   ├── allImages/                  # Device icons (lights, AC, TV, oven, washing machine)
│   └── swe401project/
│       └── SWE401Project.java      # NetBeans-generated scaffold (not used in main flow)
├── nbproject/                      # NetBeans project configuration
├── build.xml                       # Ant build script
└── manifest.mf
```

## Features

- **Dashboard view** — displays five default appliances (Lights, AC, TV, Oven, Washing Machine) as image tiles in a scrollable FlowPane.
- **Device control panel** — clicking any tile opens a Swing window with an ON/OFF radio button pair, an intensity slider (0–100), and an Apply button.
- **Add new appliance** — the "Add New Appliance" button prompts for a name and location via the console, then adds a new tile to the dashboard dynamically.
- **Central controller** — `SmartHomeController` maintains the device registry and handles turn-on/turn-off logic by device ID.


## Classes

### `Device`
Represents a single appliance.

### `SmartHomeController`
Manages the list of all `Device` objects. Key methods:

- `addDevice(Device)` / `removeDevice(Device)` — register or deregister devices.
- `turnOn(long id)` / `turnOff(long id)` — update a device's status by ID.
- `controlDevice(long id, String action)` — delegate an action to a device.

### `Main`
JavaFX `Application` subclass. Initialises the five default devices, builds the dashboard UI (FlowPane inside a ScrollPane), and wires click events on each tile to open a `DeviceControlPage`.

### `DeviceControlPage`
Swing `JFrame` that opens as a secondary window for a selected device. Contains a label, an intensity `JSlider`, ON/OFF `JRadioButton`s grouped in a `ButtonGroup`, and an Apply button that calls `SmartHomeController.turnOff()` to update the device state.

## Known Limitations

- The "Add New Appliance" dialog reads input from the console (`System.in`) rather than a GUI dialog box — input will only work when the app is launched from a terminal.
- The `Device.performAction()` method is declared but not implemented.