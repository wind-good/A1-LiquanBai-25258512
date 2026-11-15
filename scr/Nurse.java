/**
 * Represents a Nurse.
 */
public class Nurse extends HealthProfessional {
    public Nurse(String id, String name, String gender, String phone, String department, String notes) {
        super(id, name, gender, phone, department, notes);
    }

    @Override
    public String getSpecificRole() {
        return "Nurse";
    }
}