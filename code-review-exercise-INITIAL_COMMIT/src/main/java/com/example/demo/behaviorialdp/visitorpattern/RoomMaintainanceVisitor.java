package src.main.java.com.example.demo.behaviorialdp.visitorpattern;

public class RoomMaintainanceVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Maintainance of single room");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Maintainance of deluxe room");

    }
}
