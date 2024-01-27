package com.crud.customquery.eg.controller;

import com.crud.customquery.eg.services.CrudService;
import com.crud.customquery.eg.entity.Employee;
import com.crud.customquery.eg.pojo.EmployeeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JSPController {

    @Autowired
    CrudService crudService;

    @GetMapping("/welcome1")
    public String welcomePage1(HttpServletRequest request) {
        request.setAttribute("name", "Sreerekha");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("sname", "and Aventhika");
        return "welcome";
    }

    @GetMapping("/welcome")
    public ModelAndView welcomePage(EmployeeDTO employeeDTO) {
        // Using ModelandView instead of request or session obj
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        modelAndView.addObject("employeeDTO", employeeDTO);
        return modelAndView;
    }

    // DB Interaction
    @GetMapping("/Input")
    public String inputView(ModelMap map) {
        return "adddataTodb";
    }

    @GetMapping(value = "/addtoDB")
    public String addtoDB(EmployeeDTO employeeDTO) {
        // System.out.println("Name is entered adding to DB " +employeeDTO.getName());
        crudService.addEmpToDb(employeeDTO);
        //  map.addAttribute("employee", employee);
        return "redirect:/jsp/displayAllEmp";
        //return  mv;
    }

    @GetMapping("/displayAllEmp")
    public ModelAndView displayAllEmp() {
        ModelAndView mv = new ModelAndView();
        //  List<EmployeeDTO> employeeList = crudService.getAllEmp();
        System.out.println("Emp Size: " + crudService.getAllEmp().size());
        for (EmployeeDTO e : crudService.getAllEmp()) {
            System.out.println(e.toString());
        }
        mv.addObject("employeeList", crudService.getAllEmp());
        mv.setViewName("displayAllEmp");
        return mv;
    }


}
