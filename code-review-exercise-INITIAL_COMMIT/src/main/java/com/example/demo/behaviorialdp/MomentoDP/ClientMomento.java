package src.main.java.com.example.demo.behaviorialdp.MomentoDP;

public class ClientMomento {
    public static void main(String[] args) {
        ConfigurationCareTaker configurationCareTaker=new ConfigurationCareTaker();

        ConfigurationOriginator configurationOriginator=new ConfigurationOriginator(5,18);
        ConfigurationMomento originatorMomento=configurationOriginator.createMomento();
        configurationCareTaker.addMomento(originatorMomento);

        configurationOriginator.setHeight(7);
        configurationOriginator.setWidth(11);

        ConfigurationMomento snapshot1=configurationOriginator.createMomento();
        configurationCareTaker.addMomento(snapshot1);

        configurationOriginator.setHeight(1);
        configurationOriginator.setWidth(1);

        ConfigurationMomento snapshot2=configurationOriginator.createMomento();
        configurationCareTaker.addMomento(snapshot2);

        ConfigurationMomento restore=configurationCareTaker.undo();
        configurationOriginator.restoreMomento(restore);

        System.out.println("Height : "+configurationOriginator.height);
        System.out.println("Width : "+configurationOriginator.width);





    }
}
