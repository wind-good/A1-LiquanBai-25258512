import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages appointments and time slots.
 */
public class AppointmentManager {
    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<String> allTimeSlots;

    public AppointmentManager() {
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.allTimeSlots = new ArrayList<>();
        
        // Generate 08:00 to 16:00 slots
        for (int i = 8; i < 16; i++) {
            allTimeSlots.add(String.format("%02d:00", i));
            allTimeSlots.add(String.format("%02d:30", i));
        }
    }

    public Patient findPatientByPhone(String phone) {
        for (Patient p : patients) {
            if (p.getPhone().equals(phone)) {
                return p;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<String> getAvailableSlots(HealthProfessional doctor) {
        List<String> available = new ArrayList<>(allTimeSlots);
        for (Appointment app : appointments) {
            if (app.getDoctor().equals(doctor)) {
                available.remove(app.getTimeSlot());
            }
        }
        return available;
    }

    public String bookAppointment(Patient patient, HealthProfessional doctor, String time) {
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

    public String cancelAppointment(String phone, String time) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment app = appointments.get(i);
            if (app.getPatient().getPhone().equals(phone) && app.getTimeSlot().equals(time)) {
                appointments.remove(i);
                return "Success: Cancelled appointment at " + time + " for phone " + phone + ".";
            }
        }
        return "Error: No appointment found for phone " + phone + " at " + time + ".";
    }

    public void printAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked yet.");
            return;
        }
        Collections.sort(appointments);
        System.out.println("--- All Appointments ---");
        for (Appointment app : appointments) {
            System.out.println(app.toString());
        }
    }
}