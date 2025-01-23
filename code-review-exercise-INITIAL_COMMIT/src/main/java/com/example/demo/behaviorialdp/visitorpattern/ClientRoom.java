package src.main.java.com.example.demo.behaviorialdp.visitorpattern;

public class ClientRoom {
    public static void main(String[] args) {

        RoomElement singleroomObject= new SingleRoom();
        RoomElement deluxeRoomObj=new DeluxeRoom();


        RoomVisitor price=new RoomPricingVisitor();
        singleroomObject.accept(price);
        System.out.println("price:" + ((SingleRoom)singleroomObject).roomPrice);

        RoomVisitor maintain=new RoomMaintainanceVisitor();
        deluxeRoomObj.accept(maintain);
        deluxeRoomObj.accept(price);
        System.out.println("price:" + ((DeluxeRoom)deluxeRoomObj).roomPrice);


    }
}
