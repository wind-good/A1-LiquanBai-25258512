import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main application class with interactive menu.
 * Handles user inputs, displays the menu, and prevents crashes from invalid inputs.
 */
public class AssignmentOne {
    
    // Global Scanner for user input
    private static Scanner scanner = new Scanner(System.in);
    // Manager to handle all appointment and patient data
    private static AppointmentManager manager = new AppointmentManager();
    // List to hold the doctors available in the clinic
    private static List<HealthProfessional> doctors = new ArrayList<>();

    /**
     * The main method to start the application.
     */
    public static void main(String[] args) {
        // Initialize doctors into the system
        doctors.add(new GeneralPractitioner("101", "Dr. Alice", "Female", "0400111222", "General", "None"));
        doctors.add(new GeneralPractitioner("102", "Dr. Bob", "Male", "0400222333", "General", "None"));
        doctors.add(new Specialist("201", "Dr. Charlie", "Male", "0400333444", "Cardiology", "None", "Cardiologist"));
        doctors.add(new Nurse("301", "Nurse Joy", "Female", "0400444555", "Triage", "Day shift"));
        doctors.add(new Surgeon("401", "Dr. Dave", "Male", "0400555666", "Surgery", "None"));

        boolean running = true;
        while (running) {
            System.out.println("\n--- Hospital System ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Exit");
            System.out.print("Select option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    bookFlow();
                    break;
                case "2":
                    manager.printAllAppointments();
                    break;
                case "3":
                    cancelFlow();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }

    /**
     * Handles the flow of booking an appointment.
     */
    private static void bookFlow() {
        System.out.print("Enter patient phone: ");
        String phone = scanner.nextLine();
        
        Patient patient = manager.findPatientByPhone(phone);
        if (patient != null) {
            System.out.println("Welcome back, " + patient.getName() + "!");
        } else {
            System.out.print("New patient. Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            patient = new Patient(name, phone, gender, "None");
            manager.addPatient(patient);
        }

        System.out.println("\nSelect a doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).toString());
        }
        
        System.out.print("Enter number: ");
        String docInput = scanner.nextLine(); 
        int docIndex;
        
        try {
            docIndex = Integer.parseInt(docInput) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return; 
        }
        
        if (docIndex < 0 || docIndex >= doctors.size()) {
            System.out.println("Invalid doctor number.");
            return;
        }
        
        HealthProfessional selectedDoc = doctors.get(docIndex);
        System.out.println("Available slots: " + manager.getAvailableSlots(selectedDoc));

        boolean isBooked = false;
        while (!isBooked) {
            System.out.print("\nEnter desired time (e.g. 09:30) or type 'back' to return to main menu: ");
            String time = scanner.nextLine();

            if (time.equalsIgnoreCase("back")) {
                System.out.println("Returning to main menu...");
                return;
            }

            String result = manager.bookAppointment(patient, selectedDoc, time);
            System.out.println(result);

            if (result.startsWith("Success")) {
                isBooked = true;
            } else {
                System.out.println("Please try again with a valid available time, or type 'back' to cancel.");
            }
        }
    }

    /**
     * Handles the flow of cancelling an appointment.
     */
    private static void cancelFlow() {
        System.out.print("Enter patient phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter time to cancel: ");
        String time = scanner.nextLine();
        System.out.println(manager.cancelAppointment(phone, time));
    }
}