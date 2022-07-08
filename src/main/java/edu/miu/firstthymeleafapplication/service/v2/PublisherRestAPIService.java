package edu.miu.firstthymeleafapplication.service.v2;

import edu.miu.firstthymeleafapplication.dto.PublisherRequest;
import edu.miu.firstthymeleafapplication.exception.PublisherNotFoundException;
import edu.miu.firstthymeleafapplication.model.Publisher;

import java.util.List;

public interface PublisherRestAPIService {

    Publisher addNewPublisher(PublisherRequest publisherRequest);

     List<Publisher> getAllPublishers();

   Publisher getPublisherById(Integer publisherId) throws PublisherNotFoundException;

    Publisher updatePublisher(Integer publisherId, PublisherRequest publisherRequest) throws PublisherNotFoundException;

    void deletePublisherById(Integer publisherId);

}
