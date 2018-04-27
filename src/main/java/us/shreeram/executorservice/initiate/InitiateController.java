package us.shreeram.executorservice.initiate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitiateController {
    @RequestMapping("/start")
    public String initiateScript() {

        Process p;
        try {
                List<String> cmdList = new ArrayList<String>();
                cmdList.add(InitiateController.class.getResource("/script.bat").getPath());
                ProcessBuilder pb = new ProcessBuilder(cmdList);
                p = pb.start();
                BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while((line = reader.readLine()) != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    Date date = new Date();
                    System.out.println(formatter.format(date)+"   "+line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "Started the backend process.";
    }
}
