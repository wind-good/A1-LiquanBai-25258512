/**
 * Represents a Specialist doctor.
 */
public class Specialist extends HealthProfessional {
    
    // Specific attribute for Specialist
    private String specialtyArea;

    public Specialist(String id, String name, String gender, String phone, String department, String notes, String specialtyArea) {
        super(id, name, gender, phone, department, notes);
        this.specialtyArea = specialtyArea;
    }

    @Override
    public String getSpecificRole() {
        return "Specialist (" + specialtyArea + ")";
    }
}