/**
 * Represents a generic health professional in the clinic.
 * This is an abstract class that provides the foundation for specific roles.
 */
public abstract class HealthProfessional {
    // Attributes common to all health professionals
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String department;
    private String notes;

    /**
     * Constructs a HealthProfessional with specific details.
     */
    public HealthProfessional(String id, String name, String gender, String phone, String department, String notes) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.department = department;
        this.notes = notes;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }

    /**
     * Abstract method to force subclasses to specify their exact role.
     */
    public abstract String getSpecificRole();

    @Override
    public String toString() {
        return "Role: " + getSpecificRole() + " | ID: " + id + " | Name: " + name + 
               " | Dept: " + department + " | Phone: " + phone;
    }
}