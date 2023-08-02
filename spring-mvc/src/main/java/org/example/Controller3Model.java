package org.example;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/testModel")
public class Controller3Model {
  // pre-processing sample
  @InitBinder
  public void initBinder(WebDataBinder dataBinder){
    // System.out.println('asd');
    // string trimmer
    StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true); //true = if only white space -> null

    // add trimmer as filter
    dataBinder.registerCustomEditor(String.class, trimmerEditor); //return result, filter obj
  }

  @RequestMapping("/")
  public String toForm(ModelMap modelMap){
    modelMap.addAttribute("student", new ModelStudent());
    return "modelForm";
  }

  @RequestMapping("/result")
  public String toResult(@ModelAttribute("student") ModelStudent student){
    System.out.println(">> Result only");
    System.out.println(student);
    return "modelResult";
  }

  @RequestMapping("/resultWithValidate")
  public String toResultWithValidate(@Valid @ModelAttribute("student") ModelStudent student,
                                     BindingResult bindingResult) {
    System.out.println(">> Result + validate");
    System.out.println(student);
    if (bindingResult.hasErrors()) {
      return "modelForm";
    } else {
      return "modelResult";
    }
  }
}
