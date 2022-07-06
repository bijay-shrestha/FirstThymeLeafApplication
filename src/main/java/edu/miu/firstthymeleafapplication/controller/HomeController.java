package edu.miu.firstthymeleafapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author bijayshrestha on 7/6/22
 * @project FirstThymeLeafApplication
 */
@Controller
public class HomeController {

    @GetMapping(value={"/", "/home", "fairfieldlibrary/home"})
    public String displayHomepage(){
        return "public/index";
    }
}
