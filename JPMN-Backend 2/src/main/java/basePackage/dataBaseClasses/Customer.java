package basePackage.dataBaseClasses;

public class Customer {
    private long customer_ID;
    private String customer_name;
    private String customer_email;
    private String salt1;
    private String creditcard_number;
    private String salt2;

    public long getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getSalt1() {
        return salt1;
    }

    public void setSalt1(String salt1) {
        this.salt1 = salt1;
    }

    public String getCreditcard_number() {
        return creditcard_number;
    }

    public void setCreditcard_number(String creditcard_number) {
        this.creditcard_number = creditcard_number;
    }

    public String getSalt2() {
        return salt2;
    }

    public void setSalt2(String salt2) {
        this.salt2 = salt2;
    }
    
    public Customer(String customer_name, String customer_email, String salt1, String creditcard_number, String salt2) {
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.salt1 = salt1;
        this.creditcard_number = creditcard_number;
        this.salt2 = salt2;
    }
    
    public Customer(long customer_ID, String customer_name, String customer_email, String salt1, String creditcard_number, String salt2) {
        this.customer_ID = customer_ID;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.salt1 = salt1;
        this.creditcard_number = creditcard_number;
        this.salt2 = salt2;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_ID=" + customer_ID +
                ", customer_name='" + customer_name + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", salt1='" + salt1 + '\'' +
                ", creditcard_number='" + creditcard_number + '\'' +
                ", salt2='" + salt2 + '\'' +
                '}';
    }
}
