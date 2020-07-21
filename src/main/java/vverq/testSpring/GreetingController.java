package vverq.testSpring;


import com.opencsv.bean.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


@Controller
public class GreetingController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFile(
            @RequestParam("col") int col, @RequestParam("prefix") String prefix, Model model) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(".\\src\\main\\resources\\1.csv"), StandardCharsets.UTF_8))) {

            ColumnPositionMappingStrategy<Airport> strategy = new ColumnPositionMappingStrategy<>();
            String[] fields = {
                    "id", "name", "city", "country", "IATA", "ICAO",
                    "latitude", "longitude", "altitude", "timezone",
                    "DST", "ianaTZ", "type", "source"
            };
            strategy.setType(Airport.class);
            strategy.setColumnMapping(fields);

            CsvToBean<Airport> csvToBean = new CsvToBeanBuilder<Airport>(reader)
                    .withMappingStrategy(strategy)
                    .withType(Airport.class)
                    .withSeparator(',')
                    .withIgnoreQuotations(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            String field = fields[col];
            String prefixLowerCase = prefix.toLowerCase();
            Iterator<Airport> airportIterator = csvToBean.iterator();
            ArrayList<Airport> airports = new ArrayList<>();
            while(airportIterator.hasNext()) {
                Airport airport = airportIterator.next();
                if (airport.getFieldByName(field).toLowerCase().startsWith(prefixLowerCase)) {
                    airports.add(airport);
                }
            }
            airports.sort(new Comparator<Airport>() {
                @Override
                public int compare(Airport a1, Airport a2) {
                    return a1.getFieldByName(field).compareTo((a2.getFieldByName(field)));
                }
            });
            model.addAttribute("airports", airports);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "file-upload-status";
    }
}
