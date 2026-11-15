/**
 * Represents a Dietitian.
 */
public class Dietitian extends HealthProfessional {
    public Dietitian(String id, String name, String gender, String phone, String department, String notes) {
        super(id, name, gender, phone, department, notes);
    }

    @Override
    public String getSpecificRole() {
        return "Dietitian";
    }
}