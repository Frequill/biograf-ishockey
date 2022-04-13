package basePackage.dataBaseClasses;

public class Transaction {
    private int customer_ID;
    private int tickets_purchased;
    private String saloon;
    private String title;
    private String date_of_purchase;

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public int getTickets_purchased() {
        return tickets_purchased;
    }

    public void setTickets_purchased(int tickets_purchased) {
        this.tickets_purchased = tickets_purchased;
    }

    public String getSaloon() {
        return saloon;
    }

    public void setSaloon(String saloon) {
        this.saloon = saloon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(String date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public Transaction(int customer_ID, int tickets_purchased, String saloon, String title, String date_of_purchase) {
        this.customer_ID = customer_ID;
        this.tickets_purchased = tickets_purchased;
        this.saloon = saloon;
        this.title = title;
        this.date_of_purchase = date_of_purchase;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customer_ID=" + customer_ID +
                ", tickets_purchased=" + tickets_purchased +
                ", saloon='" + saloon + '\'' +
                ", title='" + title + '\'' +
                ", date_of_purchase='" + date_of_purchase + '\'' +
                '}';
    }
}
