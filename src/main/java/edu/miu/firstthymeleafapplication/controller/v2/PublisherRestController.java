package edu.miu.firstthymeleafapplication.controller.v2;

import edu.miu.firstthymeleafapplication.dto.PublisherRequest;
import edu.miu.firstthymeleafapplication.exception.PublisherNotFoundException;
import edu.miu.firstthymeleafapplication.model.Publisher;
import edu.miu.firstthymeleafapplication.service.v2.PublisherRestAPIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project FirstThymeLeafApplication
 */
@RestController
@RequestMapping("/api/v2/fairfieldlibrary/publisher")
public class PublisherRestController {

    private final PublisherRestAPIService publisherRestAPIService;

    public PublisherRestController(PublisherRestAPIService publisherRestAPIService) {
        this.publisherRestAPIService = publisherRestAPIService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<Publisher>> listPublishers(){
        return ResponseEntity.ok(publisherRestAPIService.getAllPublishers());
    }

    @GetMapping(value = "/{publisherId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer publisherId) throws PublisherNotFoundException {
        return ResponseEntity.ok(publisherRestAPIService.getPublisherById(publisherId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Publisher> addNewPublisher(@Valid @RequestBody PublisherRequest publisherRequest){
        return new ResponseEntity<>(publisherRestAPIService.addNewPublisher(publisherRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{publisherId}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Integer publisherId,
                                                     @Valid @RequestBody PublisherRequest publisherRequest)
            throws PublisherNotFoundException{
        return new ResponseEntity<>(publisherRestAPIService.updatePublisher(publisherId, publisherRequest),HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{publisherId}")
    public ResponseEntity.HeadersBuilder<ResponseEntity.BodyBuilder> deletePublisher(@PathVariable Integer publisherId){
        publisherRestAPIService.deletePublisherById(publisherId);
        return ResponseEntity.status(HttpStatus.OK);
    }

}
