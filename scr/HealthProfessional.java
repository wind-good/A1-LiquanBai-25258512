/**
 * Represents a generic health professional.
 */
public abstract class HealthProfessional {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String department;
    private String notes;

    public HealthProfessional(String id, String name, String gender, String phone, String department, String notes) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.department = department;
        this.notes = notes;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public abstract String getSpecificRole();

    @Override
    public String toString() {
        return "[" + getSpecificRole() + "] ID: " + id + " | Name: " + name + " | Dept: " + department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HealthProfessional that = (HealthProfessional) obj;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}




