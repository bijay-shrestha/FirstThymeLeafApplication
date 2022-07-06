package edu.miu.firstthymeleafapplication.controller;

import edu.miu.firstthymeleafapplication.model.Publisher;
import edu.miu.firstthymeleafapplication.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView listPublisher(){
        var publishers = publisherService.getAllPublishers();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("publishers", publishers);
        modelAndView.setViewName("secured/publisher/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String displayNewPublisherForm(Model model){
        var newPublisher = new Publisher();
        model.addAttribute("publisher", newPublisher);
        return "/secured/publisher/new";
    }

    @PostMapping(value = {"/new"})
    public String addNewPublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/publisher/new";
        }
        publisherService.addNewPublisher(publisher);
        return "redirect:/fairfieldlibrary/publisher/list";
    }

}
