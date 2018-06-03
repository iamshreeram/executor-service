package us.shreeram.applications.executorservice.business;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScriptExecutor {

    public String executeScript(List cmdList) {

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
            return "Started the backend" +  cmdList +" process.";
        } catch (IOException e) {
            e.printStackTrace();
            return cmdList +" process failed to start.";
        }

    }

}
