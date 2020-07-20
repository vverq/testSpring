package vverq.testSpring;


import com.opencsv.bean.*;
import com.samskivert.mustache.Mustache;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Map<String, Object> model) {

        // validate file
        System.out.println(file.getOriginalFilename());
        if (file.isEmpty()) {
            model.put("message", "Please select a CSV file to upload.");
            model.put("status", false);
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                ColumnPositionMappingStrategy<Airport> strategy = new ColumnPositionMappingStrategy<>();
                 String[] fields = {"id", "name", "city", "country", "IATA", "ICAO", "latitude", "longitude", "altitude", "timezone", "DST", "ianaTZ", "type", "source"};
                 strategy.setType(Airport.class);
                 strategy.setColumnMapping(fields);

                CsvToBean<Airport> csvToBean = new CsvToBeanBuilder<Airport>(reader)
                        .withMappingStrategy(strategy)
                        .withType(Airport.class)
                        .withSeparator(',')
                        .withIgnoreQuotations(true)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<Airport> airports = csvToBean.parse();
                model.put("airports", airports);

                // save users list on model
                //                model.addAttribute("users", airports);
                //                model.addAttribute("status", true);

            } catch (Exception ex) {
                ex.printStackTrace();
                //                model.addAttribute("message", "An error occurred while processing the CSV file.");
                //                model.addAttribute("status", false);
            }
        }
        return "file-upload-status";
    }
}
