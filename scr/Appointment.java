/**
 * Represents an appointment linking a patient, a doctor, and a time slot.
 * Implements Comparable to allow sorting by time slot.
 */
public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional doctor;
    private String timeSlot; // Format: "HH:mm", e.g., "09:30"

    public Appointment(Patient patient, HealthProfessional doctor, String timeSlot) {
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    public Patient getPatient() { return patient; }
    public HealthProfessional getDoctor() { return doctor; }
    public String getTimeSlot() { return timeSlot; }

    /**
     * Compares appointments by time slot for sorting from earliest to latest.
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeSlot.compareTo(other.timeSlot);
    }

    @Override
    public String toString() {
        return "Time: " + timeSlot + " | Doctor: " + doctor.getName() + 
               " (" + doctor.getSpecificRole() + ") | " + patient.toString();
    }
}