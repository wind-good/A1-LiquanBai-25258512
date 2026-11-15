import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages appointments and time slots.
 * Handles the business logic for booking, cancelling, and validating appointments.
 */
public class AppointmentManager {
    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<String> allTimeSlots;

    /**
     * Initializes the manager and generates the fixed daily time slots.
     */
    public AppointmentManager() {
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.allTimeSlots = new ArrayList<>();
        
        // Generate 08:00 to 16:00 slots in 30-minute intervals
        for (int i = 8; i < 16; i++) {
            allTimeSlots.add(String.format("%02d:00", i));
            allTimeSlots.add(String.format("%02d:30", i));
        }
    }

    /**
     * Finds a patient by their phone number.
     * @param phone The phone number to search for.
     * @return The Patient object if found, otherwise null.
     */
    public Patient findPatientByPhone(String phone) {
        for (Patient p : patients) {
            if (p.getPhone().equals(phone)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Registers a new patient into the system.
     * @param patient The patient to add.
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Gets the available time slots for a specific doctor.
     * @param doctor The doctor to check.
     * @return A list of available time slot strings.
     */
    public List<String> getAvailableSlots(HealthProfessional doctor) {
        List<String> available = new ArrayList<>(allTimeSlots);
        for (Appointment app : appointments) {
            if (app.getDoctor().equals(doctor)) {
                available.remove(app.getTimeSlot());
            }
        }
        return available;
    }

    /**
     * Books an appointment if all checks pass (valid time, no double-booking).
     * @param patient The patient booking the appointment.
     * @param doctor The doctor being booked.
     * @param time The requested time slot.
     * @return A success or error message.
     */
    public String bookAppointment(Patient patient, HealthProfessional doctor, String time) {
        // Clean up input: remove leading/trailing spaces and fix Chinese colons
        time = time.trim().replace("：", ":");

        if (!allTimeSlots.contains(time)) {
            return "Error: Invalid time. Please choose a valid 30-min slot between 08:00 and 16:00.";
        }
        
        for (Appointment app : appointments) {
            if (app.getDoctor().equals(doctor) && app.getTimeSlot().equals(time)) {
                return "Error: Doctor " + doctor.getName() + " is already booked at " + time + ".";
            }
        }
        
        appointments.add(new Appointment(patient, doctor, time));
        return "Success: Booked with " + doctor.getName() + " at " + time + " for " + patient.getName() + ".";
    }

    /**
     * Cancels an appointment by patient phone and time.
     * @param phone The patient's phone number.
     * @param time The time slot to cancel.
     * @return A success or error message.
     */
    public String cancelAppointment(String phone, String time) {
        // Clean up input: remove leading/trailing spaces and fix Chinese colons
        time = time.trim().replace("：", ":");

        for (int i = 0; i < appointments.size(); i++) {
            Appointment app = appointments.get(i);
            if (app.getPatient().getPhone().equals(phone) && app.getTimeSlot().equals(time)) {
                appointments.remove(i);
                return "Success: Cancelled appointment at " + time + " for phone " + phone + ".";
            }
        }
        return "Error: No appointment found for phone " + phone + " at " + time + ".";
    }

    /**
     * Prints all appointments sorted by time slot.
     */
    public void printAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked yet.");
            return;
        }
        Collections.sort(appointments);
        System.out.println("--- All Appointments (Sorted by Time) ---");
        for (Appointment app : appointments) {
            System.out.println(app.toString());
        }
    }
}