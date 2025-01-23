package src.main.java.com.example.demo.behaviorialdp.visitorpattern;

public interface RoomElement {
    public void accept(RoomVisitor visitor);
}
