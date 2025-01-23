package src.main.java.com.example.demo.behaviorialdp.visitorpattern;

public class DeluxeRoom implements RoomElement{

    int roomPrice=0;
    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
