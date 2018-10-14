package us.shreeram.applications.executorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import us.shreeram.applications.executorservice.business.ScriptExecutor;

@RestController
public class InitiateController {

    @Autowired
    private ScriptExecutor se;

  /**
   * This handler initiates the execution of a script given the path and scriptname.
   * 
   * @param scriptName name of the script
   * @param path path of the script.
   * @return Status message.
   */
    @RequestMapping("/start")
  public String initiateScript(@RequestParam("scriptname") String scriptName, @RequestHeader("path") String path) {
        final List<String> cmdList = new ArrayList<String>();
        final String script;
        script = path+scriptName;
        cmdList.add(script);
        String status = se.executeScript(cmdList);
        return status;
    }
}
