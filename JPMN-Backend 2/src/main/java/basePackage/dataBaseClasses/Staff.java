package basePackage.dataBaseClasses;

public class Staff {
    private long staff_ID;
    private String name;
    private String salary;
    private String salt1;
    private String email_address;
    private String salt2;

    public long getStaff_ID() {
        return staff_ID;
    }

    public void setStaff_ID(long staff_ID) {
        this.staff_ID = staff_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSalt1() {
        return salt1;
    }

    public void setSalt1(String salt1) {
        this.salt1 = salt1;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getSalt2() {
        return salt2;
    }

    public void setSalt2(String salt2) {
        this.salt2 = salt2;
    }

    public Staff(int staff_ID, String name, String salary, String salt1, String email_address, String salt2) {
        this.staff_ID = staff_ID;
        this.name = name;
        this.salary = salary;
        this.salt1 = salt1;
        this.email_address = email_address;
        this.salt2 = salt2;
    }
    
    public Staff(String name, String salary, String salt1, String email_address, String salt2) {
        //this.staff_ID = staff_ID;
        this.name = name;
        this.salary = salary;
        this.salt1 = salt1;
        this.email_address = email_address;
        this.salt2 = salt2;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_ID=" + staff_ID +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", salt1='" + salt1 + '\'' +
                ", email_address='" + email_address + '\'' +
                ", salt2='" + salt2 + '\'' +
                '}';
    }
}
