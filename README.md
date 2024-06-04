# Parking Payment Management System

Welcome to the Parking Payment Management System project repository. This Java-based application is designed to revolutionize the parking experience by simplifying the payment process and enhancing overall efficiency. Below you will find detailed information about the project, its features, requirements, and how to get started.

## Table of Contents

- [Introduction](#introduction)
- [Team](#team)
- [Features](#features)
- [Video Demonstration](#video_demonstration)
- [Usage](#usage)
- [Architecture](#architecture)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [System Requirements](#system-requirements)
- [Installation](#installation)

## Introduction

The Parking Payment Management System is a Java-based application with a user-friendly graphical user interface (GUI). Developed by a dedicated team of professionals, this system aims to streamline the parking experience for daily commuters and parking management authorities. The project incorporates real-time data analytics to provide an efficient and modern solution to parking payment challenges.


## Team

- Mohammed Kashif Ahmed - Documentation Lead & Technical Support
- Ben Chase - Progress Facilitator
- Patrick Wilson - Technical Lead
- Naman Verma - Project Manager

## Features

- **User-Friendly GUI**: Easy navigation and interaction for all users.
- **Secure Payment Methods**: Ensures secure and efficient transaction processing.
- **Real-Time Data Analytics**: Tracks parking space occupancy and usage patterns.
- **Database Management**: Manages parking spots, transactions, and generates reports.
- **Scalable Design**: Accommodates up to 40 cars with efficient space utilization.

## Video Demonstration

1. **User Single Car Entry and Receipt Generation:**
   The admin successfully enters a single vehicle's details into the system by selecting a parking lot, specifying the parking duration, and inputting the vehicle's license
   number. This action adds the entry to the database and generates a detailed receipt, including TicketId, SpotID, VehiclePlate, CheckInTime, CheckOutTime and Duration,
   Parking Rate, Total Amount paid, and ActualCheckOutTime.


https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/70994cac-67f0-4ec1-8da1-4bc6e6df50ed


2. **Multiple Car Entries and Database Population:**
   Multiple car entries are added to the system, demonstrating how the database can handle and store multiple records. The video shows several vehicles being registered with
   their respective details, showcasing the system's capacity to manage numerous entries efficiently.


https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/fa9d6304-90d5-43fe-9187-9f4d245f03ee


3. **User Early Checkout and Database Update:**
   A user checks out before their scheduled checkout time by entering their TicketID. The actual checkout time is recorded in the database, reflecting the early departure.
   This clip highlights the system's ability to update records accurately based on user actions.

   
https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/f1409d09-cd88-4f1e-a1b1-c4eafff86ad0


4. **User Late Checkout and Late Payment Fee Processing:**
   A user checks out after their scheduled checkout time, resulting in late payment fees. The system records the actual checkout time, calculates the late payment charge, and
   indicates how late the user is checking out. This information is updated in the database and included in the generated receipt.


https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/e9f90b64-3809-46ec-8af7-b2258cf80148


5. **Daily Report Generation and Data Export:**
   The system generates daily reports for each vehicle based on database records. It analyzes peak hours, reports average parking durations per day, and exports the data into
   CSV files for storage. This clip demonstrates the comprehensive reporting capabilities of the system and its ability to facilitate data analysis.
   

https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/8f26e979-0d3d-4af5-a656-1ed03ce89756


**Overall Video Demonstration:**
   https://drive.google.com/file/d/1qKFreP-dDiWVJuq8L-RVH78v_Uddy3h8/view?usp=sharing

## Usage

1. Launching the Application:
   - Run the application from your IDE or command line.
   - The main interface allows users to select parking spots and make payments.
2. User Input Handling:
   - Enter the required details such as vehicle number and parking duration.
   - Follow the prompts to complete the payment.
3. Admin Features:
   - Access admin functionalities to manage parking spots, view transaction history, and generate reports.

## Architecture & Architectural Designs:

The application follows a modular design with the following key components:
   - User Interface: Developed using JavaFX for a responsive and intuitive experience.
   - Backend Processing: Utilizes Java for business logic and database interactions.
   - Database Management: Handles data storage, retrieval, and reporting functionalities.

1. Primary/Main Functions:


   ![image](https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/1337b36f-2cd9-4364-b186-5d7623466ff3)

   
3. Secondary Functions Design:

   
   ![image](https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/8b03e580-d9ca-47a2-8e32-bfd75eef19fb)

   
5. DataBase Design:

   
   ![image](https://github.com/M-K4SH1F/Parking-Payment-Managment-System/assets/159590221/f36af709-ffa0-4176-8e4a-0e879e21c55c)



## Testing

   - Unit Testing: Conducted on individual components to verify functionality.
   - Integration Testing: Ensures seamless interaction between modules.
   - User Acceptance Testing: Validates the system against user requirements.

## Contributing
We welcome contributions to enhance the Parking Payment Management System. Please follow these steps:

   1. Fork the repository.
   2. Create a new branch for your feature or bug fix.
   3. Commit your changes and push the branch to your fork.
   3. Create a pull request with a detailed description of your changes.

## System Requirements

- **Java Development Kit (JDK)**
- **Java Runtime Environment (JRE)**
- **Integrated Development Environment (IDE)** such as Eclipse or IntelliJ IDEA
- **Database Management System** (MySQL or similar)

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/Parking-Payment-Management-System.git
   cd Parking-Payment-Management-System
2. **Setup Database:**
   - Ensure you have installed MySQL or any other compatible DBMS.
   - Create a database and import the provided SQL schema.
3. **Configure Application:**
   - Update the database connection details in the application's configuration file.
4. **Compile and Run:**
   - Open the project in your preferred IDE.
   - Compile and run the application.
