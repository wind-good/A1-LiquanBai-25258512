/**
 * Represents a General Practitioner (GP).
 * Inherits from HealthProfessional.
 */
public class GeneralPractitioner extends HealthProfessional {
    
    // Specific attribute for GP: can they prescribe medication?
    private boolean canPrescribe;

    /**
     * Constructs a General Practitioner.
     */
    public GeneralPractitioner(String id, String name, String gender, String phone, String department, String notes) {
        super(id, name, gender, phone, department, notes);
        this.canPrescribe = true; // GPs can prescribe
    }

    @Override
    public String getSpecificRole() {
        return "General Practitioner";
    }
}