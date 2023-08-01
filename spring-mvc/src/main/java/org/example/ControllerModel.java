package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testModel")
public class ControllerModel {
  @RequestMapping("/form")
  public String toForm(ModelMap modelMap){
    modelMap.addAttribute("student", new ModelStudent());
    return "modelForm";
  }

  @RequestMapping("/result")
  public String toResult(@ModelAttribute("student") ModelStudent student){
    System.out.println(student);
    return "modelResult";
  }
}
