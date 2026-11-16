/**
 * Represents an Appointment.
 */
public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional doctor;
    private String timeSlot;

    public Appointment(Patient patient, HealthProfessional doctor, String timeSlot) {
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    public Patient getPatient() { return patient; }
    public HealthProfessional getDoctor() { return doctor; }
    public String getTimeSlot() { return timeSlot; }

    @Override
    public int compareTo(Appointment other) {
        return this.timeSlot.compareTo(other.timeSlot);
    }

    @Override
    public String toString() {
        return "Time: " + timeSlot + " | Doctor: " + doctor.getName() + " (" + doctor.getSpecificRole() + ") | " + patient.toString();
    }
}





