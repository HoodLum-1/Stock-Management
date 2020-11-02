package za.co.sithole.clinicapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.sithole.clinicapp.service.ClinicService;

@Controller
@RequestMapping({"", "/clinic"})
public class ClinicController {

  private final ClinicService clinicService;

  @Autowired
  public ClinicController(ClinicService clinicService) {
    this.clinicService = clinicService;
  }

  @GetMapping
  public String main(Model model) {
    model.addAttribute("clinics", clinicService.getAllClinics());
    return "pages/index";
  }

  @GetMapping(name = "edit", value = "/edit/{id}")
  public String edit(Model model, @PathVariable final Long id) {
    model.addAttribute("clinic", clinicService.getClinicById(id));

    return "pages/edit";
  }

  @GetMapping(name = "order", value = "/order/{id}")
  public String order(Model model, @PathVariable final Long id) {
    model.addAttribute("clinic", clinicService.getClinicById(id));
    return "pages/order";
  }

  @GetMapping(name = "add-clinic", value = "/add-clinic")
  public String addClinic(Model model) {
    return "pages/add-clinic";
  }
}
