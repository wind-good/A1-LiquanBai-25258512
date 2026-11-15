/**
 * Main entry point for the Hospital Appointment System.
 * Demonstrates the creation of specific health professionals.
 */
public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("--- Hospital Appointment System Initializing ---");
        System.out.println("=== Demonstrating Doctor Subclasses ===");

        // Create objects of different types
        HealthProfessional gp1 = new GeneralPractitioner("101", "Dr. Alice", "Female", "0400111222", "General", "Friendly");
        HealthProfessional nurse1 = new Nurse("201", "Nurse Bob", "Male", "0400333444", "Triage", "Experienced");
        HealthProfessional spec1 = new Specialist("301", "Dr. Charlie", "Male", "0400555666", "Cardiology", "Heart expert", "Cardiologist");
        HealthProfessional surg1 = new Surgeon("401", "Dr. Dave", "Male", "0400777888", "Surgery", "Chief Surgeon");

        // Polymorphism in action: calling the same method on different objects
        System.out.println(gp1.toString());
        System.out.println(nurse1.toString());
        System.out.println(spec1.toString());
        System.out.println(surg1.toString());
        
        System.out.println("=== Initialization Complete ===");
    }
}