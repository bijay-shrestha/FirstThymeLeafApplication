package edu.miu.firstthymeleafapplication.controller.v2;

import edu.miu.firstthymeleafapplication.model.Publisher;
import edu.miu.firstthymeleafapplication.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project FirstThymeLeafApplication
 */
@RestController
@RequestMapping("/api/v2/fairfieldlibrary/publisher")
public class PublisherRestController {

    private final PublisherService publisherService;

    public PublisherRestController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<Publisher>> listPublishers(){
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    @GetMapping(value = "/{publisherId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer publisherId){
        return ResponseEntity.ok(publisherService.getPublisherById(publisherId));
    }

}
