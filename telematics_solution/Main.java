
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        TelematicsService carReporter = new TelematicsService();

        try (Scanner s = new Scanner(System.in)) {
            System.out.print("\ninput vehicle VIN number: ");
            while(s.hasNext()){
                VehicleInfo vehicleInfo = new VehicleInfo();

                String input = s.next();
                vehicleInfo.setVIN(input);

                System.out.print("input odometer: ");
                input = s.next();
                vehicleInfo.setOdometer(Double.parseDouble(input));

                System.out.print("input total fuel consumption: ");
                input = s.next();
                vehicleInfo.setConsumption(Double.parseDouble(input));

                System.out.print("input odometer reading from last oil change: ");
                input = s.next();
                vehicleInfo.setOdometerReadingLastOilChange(Double.parseDouble(input));

                System.out.print("input engine size: ");
                input = s.next();
                vehicleInfo.setEngineSize(input);

                carReporter.report(vehicleInfo);

                System.out.print("\ninput vehicle VIN number: ");
            }
        }
    }
}
