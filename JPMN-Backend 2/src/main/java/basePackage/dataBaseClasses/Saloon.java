package basePackage.dataBaseClasses;

public class Saloon {
    private int saloon_ID;
    private String saloon_name;
    private int seats;

    public int getSaloon_ID() {
        return saloon_ID;
    }

    public void setSaloon_ID(int saloon_ID) {
        this.saloon_ID = saloon_ID;
    }

    public String getSaloon_name() {
        return saloon_name;
    }

    public void setSaloon_name(String saloon_name) {
        this.saloon_name = saloon_name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Saloon(int saloon_ID, String saloon_name, int seats) {
        this.saloon_ID = saloon_ID;
        this.saloon_name = saloon_name;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Saloon{" +
                "saloon_ID=" + saloon_ID +
                ", saloon_name='" + saloon_name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
