package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.peer.LabelPeer;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public  String indel(Model model)
    {
        Employee employee = new Employee();
        employee.setName("shabnma");
        employee.setSsn("555-222-5532");

        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("latitute xl");

        employee.setLaptop(laptop);
        employeeRepository.save(employee);

        model.addAttribute("employees" , employeeRepository.findAll());
        return "index";
    }
}
