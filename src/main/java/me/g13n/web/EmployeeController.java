package me.g13n.web;

import java.util.concurrent.Callable;
import me.g13n.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

  @RequestMapping("/")
  public Callable<String> list(Model model) {
    return new Callable<String>() {
      @Override
      public String call() throws Exception {
        model.addAttribute("employees", employeeService.list());
        return "employeeList";
      }
    };
  }

  @Autowired
  private EmployeeService employeeService;
}
