/**
 * Represents a General Practitioner.
 */
public class GeneralPractitioner extends HealthProfessional {
    public GeneralPractitioner(String id, String name, String gender, String phone, String department, String notes) {
        super(id, name, gender, phone, department, notes);
    }

    @Override
    public String getSpecificRole() {
        return "General Practitioner";
    }
}