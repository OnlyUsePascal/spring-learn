package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerHome {
  @RequestMapping("/")
  public String toHome(ModelMap modelMap){
    modelMap.addAttribute("name", "Joun");
    return "home";
  }
}
