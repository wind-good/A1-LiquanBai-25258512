# PROG2004 A1 - Hospital Appointment System

## Description
This is an application based on a Java console. The purpose of this program is to simulate a hospital appointment system, allowing patients to make appointments with the doctors that suit them. These contents are one of the parts of the PROG2004 Object-Oriented Programming course. This file is a program manual for users.

## Functions and Characteristics of This Program
- **Patient Management**: Repeatedly uses existing patient's personal information based on the phone number, without repeatedly inputting data.
- **Medical Professionals**: Includes an abstract base class and 5 specific roles (general practitioner, specialist, nurse, surgeon, nutritionist).
- **Appointment Function**: Users can freely choose a doctor and make their own appointments from the available 30-minute time slots (08:00 to 16:00).
- **Preventing Duplicate Appointments**: The system has the ability to verify the input of time, so that the same doctor cannot be scheduled at the same time.
- **Viewing and Cancellation**: The patient's appointments are sorted by time, as this is very convenient for viewing; users can also cancel appointments by phone number and time slot.
- **Input Validation**: Robust handling of invalid input (such as inputting letters instead of numbers) to prevent the program from crashing eventually.

## How to Run
1. Open the project in an integrated development environment (such as IntelliJ IDEA, Eclipse, or VS Code).
2. Navigate to `src/AssignmentOne.java`.
3. Run the `main` method.
4. Follow the screen prompts in the console to interact with the system.

## Object-Oriented Concepts of the Application
- **Encapsulation**: All entity classes (Patient, HealthProfessional) use private attributes and provide public getter/setter methods.
- **Inheritance**: The doctor subclass inherits from the `HealthProfessional` abstract class.
- **Polymorphism**: Overridden methods such as `getSpecificRole()` and `toString()` have different behaviors for different types of doctors.
- **Abstraction**: The `HealthProfessional` class is an abstract class, forcing its subclasses to implement their respective specific roles.
