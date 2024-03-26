package TIL.복습.다형성;

public class InstanceofExample {
    public static void main(String[] args) {
        Bus bus = new Bus();
        ride(bus);


    }

    public static void ride(Vehicle vehicle){
        if(vehicle instanceof Bus bus){
            bus.checkFare();
        }
        vehicle.run();
    }
}
