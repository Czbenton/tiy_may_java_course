import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelematicsService {

    private ObjectMapper mapper = new ObjectMapper();

    public void report(VehicleInfo vehicleInfo) {
        // Write the info to a file as json (will overwrite if it already exists). Continue if an exception occurs
        try {
            String vehicleInfoJson = mapper.writeValueAsString(vehicleInfo);
            try (FileWriter out = new FileWriter(vehicleInfo.getVIN() + ".json")) {
                out.write(vehicleInfoJson);
                out.flush();
            }
        } catch (JsonProcessingException e) {
            System.out.println("Caught JsonProcessingException " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException " + e.getMessage());
        }

        // Read all the json files and store in list
        List<VehicleInfo> vehicleInfos = new ArrayList<>();
        File files = new File(".");
        for (File f : files.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // If there is an exception keep going with the next one
                File file = new File(f.getName());
                try (Scanner scanner = new Scanner(file)) {
                    String vehicleInfoJson = scanner.nextLine();
                    vehicleInfo = mapper.readValue(vehicleInfoJson, VehicleInfo.class);
                    vehicleInfos.add(vehicleInfo);
                } catch (JsonParseException e) {
                    System.out.println("Caught JsonParseException " + e.getMessage());
                } catch (JsonMappingException e) {
                    System.out.println("Caught JsonMappingException " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Caught IOException " + e.getMessage());
                }
            }
        }

        // variable to keep a running total
        double totOdometer = 0;
        double totConsumption = 0;
        double totLastOilChange = 0;
        double totEngineSize = 0;
        double totMpg = 0;

        // calculate the totals
        for (VehicleInfo vehicleInfo1 : vehicleInfos) {
            totOdometer += vehicleInfo1.getOdometer();
            totConsumption += vehicleInfo1.getConsumption();
            totEngineSize += Double.valueOf(vehicleInfo1.getEngineSize());
            totLastOilChange += vehicleInfo1.getOdometerReadingLastOilChange();
            totMpg += vehicleInfo1.milesPerGallon();
        }

        // Write the top of the html that has the averages replacing the values surrounded by % with a number
        int total = vehicleInfos.size();
        String html = HtmlText.HTML_TOP.replace("%count%", String.valueOf(total));
        html = html.replace("%odometer%", String.format("%.1f", totOdometer / total));
        html = html.replace("%consumption%", String.format("%.1f", totConsumption / total));
        html = html.replace("%lastoilchange%", String.format("%.1f", totLastOilChange / total));
        html = html.replace("%enginesize%", String.format("%.1f", totEngineSize / total));
        html = html.replace("%mpg%", String.format("%.1f", totMpg / total));

        // Use a StringBuilder to reduce the number of strings concatinations
        StringBuilder htmlPage = new StringBuilder(html);

        // Now assemble the rows replacing the values surrounded by % with a number
        for (VehicleInfo vehicleInfo1 : vehicleInfos) {
            html = HtmlText.TABLE_ROW_HTML.replace("%vin%", vehicleInfo1.getVIN());
            html = html.replace("%odometer%", String.valueOf(vehicleInfo1.getOdometer()));
            html = html.replace("%consumption%", String.valueOf(vehicleInfo1.getConsumption()));
            html = html.replace("%lastoilchange%", String.valueOf(vehicleInfo1.getOdometerReadingLastOilChange()));
            html = html.replace("%enginesize%", String.format("%.1f", Double.valueOf(vehicleInfo1.getEngineSize())));
            html = html.replace("%mpg%", String.format("%.1f", vehicleInfo1.milesPerGallon()));

            htmlPage.append(html);
        }

        htmlPage.append(HtmlText.HTML_FOOTER);

        // Write the dashboard.html file
        try (PrintWriter out = new PrintWriter("Dashboard.html")) {
            out.println(htmlPage.toString());
            out.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException (could not write dashbord.html) " + e.getMessage());
        }
    }
}
