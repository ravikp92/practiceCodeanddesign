package src.main.java.com.example.demo.behaviorialdp.visitorpattern;

public interface RoomVisitor {

    void visit(SingleRoom singleRoom);
    void visit(DeluxeRoom deluxeRoom);
}
