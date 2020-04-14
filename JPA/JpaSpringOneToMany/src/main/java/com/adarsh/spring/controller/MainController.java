package com.adarsh.spring.controller;

import com.adarsh.spring.domain.Person;
import com.adarsh.spring.dto.PersonDTO;
import com.adarsh.spring.service.CreditCardService;
import com.adarsh.spring.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main/record")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    /**
     * Retrieves the "Records" page
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getRecords(Model model) {
        logger.debug("Received request to show records page");

        // Retrieve all persons
        List<Person> persons = personService.getAll();

        // Prepare model object
        List<PersonDTO> personsDTO = new ArrayList<PersonDTO>();

        for (Person person : persons) {
            // Create new data transfer object
            PersonDTO dto = new PersonDTO();

            dto.setId(person.getId());
            dto.setFirstName(person.getFirstName());
            dto.setLastName(person.getLastName());
            dto.setMoney(person.getMoney());
            dto.setCreditCards(creditCardService.getAll(person.getId()));

            // Add to model list
            personsDTO.add(dto);
        }

        // Add to model
        model.addAttribute("persons", personsDTO);

        // This will resolve to /WEB-INF/jsp/records.jsp
        return "records";
    }

    /**
     * Retrieves the "Add New Record" page
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        logger.debug("Received request to show add page");

        // Create new Person and add to model
        model.addAttribute("personAttribute", new Person());

        // This will resolve to /WEB-INF/jsp/add-record.jsp
        return "add-record";
    }

    /**
     * Adds a new record
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("personAttribute") Person person) {
        logger.debug("Received request to add new record");

        // Delegate to service
        personService.add(person);

        // Redirect to url
        return "redirect:/adarsh/main/record/list";
    }

    /**
     * Deletes a record including all the associated credit cards
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") Integer personId) {
        logger.debug("Received request to delete record");

        // Delete person
        personService.delete(personId);

        // Redirect to url
        return "redirect:/adarsh/main/record/list";
    }

    /**
     * Retrieves the "Edit Existing Record" page
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer personId, Model model) {
        logger.debug("Received request to show edit page");

        // Retrieve person by id
        Person existingPerson = personService.get(personId);

        // Add to model
        model.addAttribute("personAttribute", existingPerson);

        // This will resolve to /WEB-INF/jsp/edit-record.jsp
        return "edit-record";
    }

    /**
     * Edits an existing record
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer personId,
                           @ModelAttribute("personAttribute") Person person) {
        logger.debug("Received request to edit existing person");

        // Assign id
        person.setId(personId);

        // Delegate to service
        personService.edit(person);

        // Redirect to url
        return "redirect:/adarsh/main/record/list";
    }


    @Resource(name = "personService")
    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Resource(name = "creditCardService")
    private CreditCardService creditCardService;

    public void setCreditCardService(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }
}
