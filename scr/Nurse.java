/**
 * Represents a Nurse in the clinic.
 */
public class Nurse extends HealthProfessional {
    
    public Nurse(String id, String name, String gender, String phone, String department, String notes) {
        super(id, name, gender, phone, department, notes);
    }

    @Override
    public String getSpecificRole() {
        return "Nurse";
    }
    
    /**
     * Specific behaviour for Nurse.
     */
    public void takeBloodSample() {
        System.out.println("Nurse " + getName() + " is taking a blood sample.");
    }
}