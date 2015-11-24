package com.adarsh.spring.controller;

import com.adarsh.spring.domain.CreditCard;
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

@Controller
@RequestMapping("/main/creditcard")
public class CreditCardController {

    protected static Logger logger = Logger.getLogger("controller");


    /**
     * Retrieves the "Add New Credit Card" page
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(@RequestParam("id") Integer personId, Model model) {
        logger.debug("Received request to show add page");
        // Prepare model object
        CreditCard creditCard = new CreditCard();
        creditCard.setPerson(personService.get(personId));
        // Add to model
        model.addAttribute("creditCardAttribute", creditCard);
        // This will resolve to /WEB-INF/jsp/add-credit-card.jsp
        return "add-credit-card";
    }

    /**
     * Adds a new credit card
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@RequestParam("pid") Integer personId,
                          @ModelAttribute("creditCardAttribute") CreditCard creditCard) {
        logger.debug("Received request to add new credit card");
        // Delegate to service
        creditCardService.add(personId, creditCard);
        // Redirect to url
        return "redirect:/adarsh/main/record/list";
    }


    /**
     * Deletes a credit card
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") Integer creditCardId) {
        logger.debug("Received request to delete credit card");
        // Delegate to service
        creditCardService.delete(creditCardId);
        // Redirect to url
        return "redirect:/adarsh/main/record/list";
    }

    /**
     * Retrieves the "Edit Existing Credit Card" page
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer creditCardId, Model model) {
        logger.debug("Received request to show edit page");
        // Retrieve credit card by id
        CreditCard existingCreditCard = creditCardService.get(creditCardId);
        // Add to model
        model.addAttribute("creditCardAttribute", existingCreditCard);
        // This will resolve to /WEB-INF/jsp/edit-credit-card.jsp
        return "edit-credit-card";
    }

    /**
     * Edits an existing credit card
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer creditCardId,
                           @ModelAttribute("creditCardAttribute") CreditCard creditCard) {
        logger.debug("Received request to add new credit card");
        // Assign id
        creditCard.setId(creditCardId);
        // Delegate to service
        creditCardService.edit(creditCard);
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
