package edu.miu.firstthymeleafapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bijayshrestha on 7/6/22
 * @project FirstThymeLeafApplication
 */
@Controller
@RequestMapping("fairfieldlibrary/publisher")
public class PublisherController {

    @GetMapping(value = "/list")
    public String listPublisher(){
        return "secure/publisher/list";
    }

}
