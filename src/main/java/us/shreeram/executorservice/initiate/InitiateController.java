package us.shreeram.executorservice.initiate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.*;

@RestController
public class InitiateController {

    // Creating a /start request mapping
    @RequestMapping("/start")
    public String initiateScript(

            //Creating query param with script name and path as header
            @RequestParam("scriptname") String scriptName,
            @RequestHeader("path") String path
    ) {
        final List<String> cmdList = new ArrayList<String>();
        final String script;

        //Creating Script path
        script = path+scriptName;

        // Adding commands to list
        cmdList.add(script);

        final ProcessBuilder pb = new ProcessBuilder(cmdList);
        try {
                pb.redirectErrorStream(true);

                //  Starting a process in server
                Process p = pb.start();

                //  Initiate the buffer reader to get the console output and print it in spring Logs
                BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while((line = reader.readLine()) != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    Date date = new Date();
                    System.out.println(formatter.format(date)+"   "+line);

                }
            return "Started the backend" +  script +" process.";
            } catch (IOException e) {
                e.printStackTrace();
                return script +" process failed to start.";
            }
    }
}
