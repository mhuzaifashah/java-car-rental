# Car Rental Management System

A desktop Java Swing application for managing car rentals, built with NetBeans and Apache Ant.

---

## Features

- **Authentication** — Login screen to secure access
- **Car Management** — Add, edit, and delete cars from the inventory
- **Rent a Car** — Record rental transactions with customer details and dates
- **Return a Car** — Process vehicle returns and calculate additional charges
- **File-based Storage** — Data persisted to local text files

---

## Tech Stack

| Component       | Technology              |
|----------------|-------------------------|
| Language        | Java (JDK 20)           |
| GUI Framework   | Java Swing              |
| Build Tool      | Apache Ant (NetBeans)   |


---

## Project Structure

```
RentSystem/
├── src/
│   └── rentsystem/
│       ├── RentSystem.java       # Application entry point
│       ├── Start.java            # Splash / welcome screen
│       ├── Login.java            # User authentication
│       ├── HomePage.java         # Main dashboard
│       ├── AddCar.java           # Car inventory management (CRUD)
│       ├── RentCar.java          # Rental transaction form
│       ├── ReturnCar.java        # Return processing
│       ├── FileHandler.java      # File I/O utilities
│       └── CarFileHandler.java   # Car record file operations
├── src/Image/                    # UI image assets
├── build/                        # Compiled class files
├── nbproject/                    # NetBeans project config
├── build.xml                     # Ant build script
└── manifest.mf                   # JAR manifest
```

---

## Application Flow

```
RentSystem (main)
    └── Start (splash screen)
            └── Login (authentication)
                    └── HomePage (main menu)
                            ├── Add Car
                            ├── Rent Car
                            └── Return Car
```

---

## Getting Started

### Prerequisites

- Java JDK 20 or higher
- Apache Ant (or NetBeans IDE)

### Build

```bash
ant build
```

### Run

```bash
java -cp build/classes rentsystem.RentSystem
```

Or open the project in **NetBeans** and press **Run** (`F6`).

### Login Credentials

| Field    | Value    |
|----------|----------|
| Username | `admin`  |
| Password | `huzaifa`|

---

## Data Storage

The application stores data in two plain text files:

**`car_details.txt`** — Car inventory records:
```
Car ID: [ID]  Reg No: [REG]  Brand: [BRAND]  Name: [NAME]  Model: [MODEL]  Fuel Type: [FUEL]  Price: [PRICE]  Car Type: [TYPE]
```

**`CarRecords.txt`** — Rental/transaction records:
```
Car ID: [ID]  Reg No: [REG]  Brand: [BRAND]  Name: [NAME]  Model: [MODEL]  Fuel Type: [FUEL]  Price: [PRICE]
```

---

## Screenshots

> UI uses full-screen maximized frames with custom background images and icon-based buttons.

---

## Author

**Muhammad Huzaifa**

---

## License

This project is for educational purposes.
