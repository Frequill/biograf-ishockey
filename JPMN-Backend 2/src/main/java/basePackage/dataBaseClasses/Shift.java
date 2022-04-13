package basePackage.dataBaseClasses;

public class Shift {
    private long shift_ID;
    private int staff_ID;
    String start_time;
    String end_time;
    
    public long getShift_ID() {
        return shift_ID;
    }

    public void setShift_ID(int shift_ID) {
        this.shift_ID = shift_ID;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public void setStaff_ID(int staff_ID) {
        this.staff_ID = staff_ID;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Shift(int shift_ID, int staff_ID, String start_time, String end_time) {
        this.shift_ID = shift_ID;
        this.staff_ID = staff_ID;
        this.start_time = start_time;
        this.end_time = end_time;
    }
    
    public Shift(String start_time, String end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shift_ID=" + shift_ID +
                ", staff_ID=" + staff_ID +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
