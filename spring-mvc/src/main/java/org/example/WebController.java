package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class WebController {
  // redirect
  @RequestMapping("/")
  public RedirectView defaultPage() {
    return new RedirectView("home");
  }


  @RequestMapping("/home")
  public String pageHome(ModelMap modelMap, @RequestParam(required = false, defaultValue = "what") String name) {
    System.out.println(name);
    modelMap.addAttribute("name", "joun");
    return "home";
  }

  @RequestMapping("/form")
  public String pageForm() {
    return "form";
  }
}
