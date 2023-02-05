package org.example.transfer.controller;

import java.util.List;
import java.util.Map;
import org.example.transfer.model.Carrier;
import org.example.transfer.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarrierController {

    @Autowired
    @Qualifier("carrierService")
    private CarrierService _service;

    @GetMapping("/")
    public ModelAndView CarrierForm() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("carriers", _service.findAll());
        return model;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String filter) {
        List<Carrier> result = _service.findAll(filter);
        ModelAndView model = new ModelAndView("index");
        model.addObject("carriers", result);
        return model;
    }

    @GetMapping("/new")
    public String newCarrier(Map<String, Object> model) {
        Carrier carriers = new Carrier();
        model.put("carrier", carriers);
        return "/new_carrier";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("carrier") Carrier carriers) {
        _service.save(carriers);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam Long id) {
        ModelAndView model = new ModelAndView("edit_carrier");
        Carrier carrier = _service.findById(id);
        model.addObject("carrier", carrier);
        return model;
    }

    @GetMapping("/delete")
    public String deleteCustomerForm(@RequestParam Long id) {
        _service.delete(id);
        return "redirect:/";
    }
}
