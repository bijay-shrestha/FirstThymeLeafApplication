package edu.miu.firstthymeleafapplication.service.v1;

import edu.miu.firstthymeleafapplication.exception.PublisherNotFoundException;
import edu.miu.firstthymeleafapplication.model.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher addNewPublisher(Publisher publisher);

     List<Publisher> getAllPublishers();

   Publisher getPublisherById(Integer publisherId) throws PublisherNotFoundException;

    Publisher updatePublisher(Publisher updatedPublisher);

    void deletePublisherById(Integer publisherId);

}
