package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/testForm")
public class ControllerForm {
  @RequestMapping("/")
  public String toForm(){
    return "form";
  }

  @RequestMapping("/result")
  public String toResult(ModelMap modelMap, @RequestParam("inputName") String inputName){
    System.out.println(inputName);
    return "formResult";
  }
}
