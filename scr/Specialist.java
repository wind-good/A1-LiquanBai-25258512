/**
 * Represents a Specialist.
 */
public class Specialist extends HealthProfessional {
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