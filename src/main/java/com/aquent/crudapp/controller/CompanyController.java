package com.aquent.crudapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aquent.crudapp.domain.Company;
import com.aquent.crudapp.service.CompanyService;
import com.aquent.crudapp.service.PersonService;

@Controller
@RequestMapping("company")
public class CompanyController {

  public static final String COMMAND_DELETE = "Delete";

  @Inject private CompanyService companyService;
  @Inject private PersonService personService;

//  The user should be able to create, edit, delete and list Clients.

  /**
   * Renders the listing page.
   *
   * @return list view populated with the current list of people
   */
  @RequestMapping(value = "list", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView modelAndView = new ModelAndView("company/list");
    modelAndView.addObject("companies", companyService.listCompanies());
    return modelAndView;
  }

  /**
   * Renders an empty form used to create a new company record.
   *
   * @return create view populated with an empty company
   */
  @RequestMapping(value = "create", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView modelAndView = new ModelAndView("company/create");
    modelAndView.addObject("company", new Company());
    modelAndView.addObject("errors", new ArrayList<String>());
    return modelAndView;
  }

  /**
   * Validates and saves a new company.
   * On success, the user is redirected to the listing page.
   * On failure, the form is redisplayed with the validation errors.
   *
   * @param company populated form bean for the company
   * @return redirect, or create view with errors
   */
  @RequestMapping(value = "create", method = RequestMethod.POST)
  public ModelAndView create(Company company) {
    List<String> errors = companyService.validateCompany(company);
    if (errors.isEmpty()) {
      companyService.createCompany(company);
      return new ModelAndView("redirect:/company/list");
    } else {
      ModelAndView modelAndView = new ModelAndView("company/create");
      modelAndView.addObject("company", company);
      modelAndView.addObject("errors", errors);
      return modelAndView;
    }
  }

  /**
   * Renders an edit form for an existing company record.
   *
   * @param companyId the ID of the company to edit
   * @return edit view populated from the company record
   */
  @RequestMapping(value = "edit/{companyId}", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable Integer companyId) {
    ModelAndView modelAndView = new ModelAndView("company/edit");
    modelAndView.addObject("company", companyService.readCompany(companyId));
    modelAndView.addObject("people", personService.listPeople());
    modelAndView.addObject("errors", new ArrayList<String>());
    return modelAndView;
  }

  /**
   * Validates and saves an edited company.
   * On success, the user is redirected to the listing page.
   * On failure, the form is redisplayed with the validation errors.
   *
   * @param company populated form bean for the company
   * @return redirect, or edit view with errors
   */
  @RequestMapping(value = "edit", method = RequestMethod.POST)
  public ModelAndView edit(Company company) {
    List<String> errors = companyService.validateCompany(company);
    if (errors.isEmpty()) {
      companyService.updateCompany(company);
      return new ModelAndView("redirect:/company/list");
    } else {
      ModelAndView modelAndView = new ModelAndView("company/edit");
      modelAndView.addObject("company", company);
      modelAndView.addObject("errors", errors);
      return modelAndView;
    }
  }

  /**
   * Renders the deletion confirmation page.
   *
   * @param companyId the ID of the company to be deleted
   * @return delete view populated from the company record
   */
  @RequestMapping(value = "delete/{companyId}", method = RequestMethod.GET)
  public ModelAndView delete(@PathVariable Integer companyId) {
    ModelAndView modelAndView = new ModelAndView("company/delete");
    modelAndView.addObject("company", companyService.readCompany(companyId));
    return modelAndView;
  }

  /**
   * Handles company deletion or cancellation, redirecting to the listing page in either case.
   *
   * @param command the command field from the form
   * @param companyId the ID of the company to be deleted
   * @return redirect to the listing page
   */
  @RequestMapping(value = "delete", method = RequestMethod.POST)
  public String delete(@RequestParam String command, @RequestParam Integer companyId) {
    if (COMMAND_DELETE.equals(command)) {
      companyService.deleteCompany(companyId);
    }
    return "redirect:/company/list";
  }

}
