/**
 * Represents a Surgeon.
 */
public class Surgeon extends HealthProfessional {
    
    public Surgeon(String id, String name, String gender, String phone, String department, String notes) {
        super(id, name, gender, phone, department, notes);
    }

    @Override
    public String getSpecificRole() {
        return "Surgeon";
    }
}