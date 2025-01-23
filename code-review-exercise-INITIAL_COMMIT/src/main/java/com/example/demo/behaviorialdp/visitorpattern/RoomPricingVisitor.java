package src.main.java.com.example.demo.behaviorialdp.visitorpattern;

public class RoomPricingVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Single room pricing");
        singleRoom.roomPrice=1000;
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Deluxe room pricing");
        deluxeRoom.roomPrice=3000;
    }
}
