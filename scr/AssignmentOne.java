/**
 * Main entry point for the Hospital Appointment System.
 * Demonstrates the creation of doctors, patients, and appointments.
 */
public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("--- Hospital Appointment System Initializing ---");

        // 1. Create objects of different doctor types
        HealthProfessional gp1 = new GeneralPractitioner("101", "Dr. Alice", "Female", "0400111222", "General", "None");
        HealthProfessional nurse1 = new Nurse("201", "Nurse Bob", "Male", "0400333444", "Triage", "None");
        HealthProfessional spec1 = new Specialist("301", "Dr. Charlie", "Male", "0400555666", "Cardiology", "None", "Cardiologist");
        HealthProfessional surg1 = new Surgeon("401", "Dr. Dave", "Male", "0400777888", "Surgery", "None");

        // 2. Demonstrate Polymorphism (calling the same method on different objects)
        System.out.println("\n=== Demonstrating Doctor Subclasses ===");
        System.out.println(gp1.toString());
        System.out.println(nurse1.toString());
        System.out.println(spec1.toString());
        System.out.println(surg1.toString());

        // 3. Test Patient equality (Duplicate phone number check)
        System.out.println("\n=== Testing Patient and Appointment ===");
        Patient p1 = new Patient("John Doe", "0400111222", "Male", "None");
        Patient p2 = new Patient("John Smith", "0400111222", "Male", "None"); 
        
        System.out.println("Are p1 and p2 the same person? " + p1.equals(p2)); // Should output: true

        // 4. Test Appointment creation
        Appointment app1 = new Appointment(p1, gp1, "09:30");
        System.out.println(app1.toString());

        System.out.println("\n=== Initialization Complete ===");
    }
}