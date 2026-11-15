/**
 * Represents a patient in the hospital system.
 * Equality is based on the patient's phone number to avoid duplicates.
 */
public class Patient {
    private String name;
    private String phone;
    private String gender;
    private String notes;

    public Patient(String name, String phone, String gender, String notes) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.notes = notes;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getGender() { return gender; }
    public String getNotes() { return notes; }

    /**
     * Overrides equals to check if a patient already exists based on phone number.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return phone.equals(patient.phone);
    }

    /**
     * Overrides hashCode to be consistent with the equals method.
     */
    @Override
    public int hashCode() {
        return phone.hashCode();
    }

    @Override
    public String toString() {
        return "Patient: " + name + " | Phone: " + phone + " | Gender: " + gender;
    }
}