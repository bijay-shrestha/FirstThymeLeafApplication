package edu.miu.firstthymeleafapplication.controller;

import edu.miu.firstthymeleafapplication.exception.PublisherNotFoundException;
import edu.miu.firstthymeleafapplication.model.Publisher;
import edu.miu.firstthymeleafapplication.service.v1.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author bijayshrestha on 7/6/22
 * @project FirstThymeLeafApplication
 */
@Controller
@RequestMapping("fairfieldlibrary/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/list")
    public ModelAndView listPublisher() {
        var publishers = publisherService.getAllPublishers();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("publishers", publishers);
        modelAndView.setViewName("secured/publisher/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String displayNewPublisherForm(Model model) {
        var newPublisher = new Publisher();
        model.addAttribute("publisher", newPublisher);
        return "/secured/publisher/new";
    }

    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewPublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/publisher/new";
        }
        checkIfContainsPrimaryAddress(publisher);
        publisherService.addNewPublisher(publisher);
        return "redirect:/fairfieldlibrary/publisher/list";
    }

    @GetMapping(value = "/edit/{publisherId}")
    public String editPublisher(Model model, @PathVariable Integer publisherId) throws PublisherNotFoundException {
        var publisher = publisherService.getPublisherById(publisherId);
        if (publisher != null) {
            model.addAttribute("publisher", publisher);
            return "/secured/publisher/edit";
        }
        return "redirect:/fairfieldlibrary/publisher/list";
    }

    @PostMapping(value = "/update")
    public String updatePublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
                                  BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/publisher/edit";
        }
        checkIfContainsPrimaryAddress(publisher);
        publisherService.updatePublisher(publisher);
        return "redirect:/fairfieldlibrary/publisher/list";


    }

    private void checkIfContainsPrimaryAddress(@ModelAttribute("publisher") @Valid Publisher publisher) {
        if (publisher.getPrimaryAddress() != null) {
            if (publisher.getPrimaryAddress().getStreet().equals("")
                    && publisher.getPrimaryAddress().getCity().equals("")
                    && publisher.getPrimaryAddress().getState().equals("")
                    && publisher.getPrimaryAddress().getZipCode().equals("")
            ) {
                publisher.setPrimaryAddress(null);
            }
        }
    }

    @GetMapping(value = "/delete/{publisherId}")
    public String deletePublisher(@PathVariable Integer publisherId){
        publisherService.deletePublisherById(publisherId);
        return "redirect:/fairfieldlibrary/publisher/list";
    }

}
