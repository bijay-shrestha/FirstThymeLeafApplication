package edu.miu.firstthymeleafapplication.service.v2.impl;

import edu.miu.firstthymeleafapplication.dto.PublisherRequest;
import edu.miu.firstthymeleafapplication.exception.PublisherNotFoundException;
import edu.miu.firstthymeleafapplication.model.Publisher;
import edu.miu.firstthymeleafapplication.repository.PublisherRepository;
import edu.miu.firstthymeleafapplication.service.v2.PublisherRestAPIService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherRestAPIServiceImpl implements PublisherRestAPIService {
    private PublisherRepository publisherRepository;

//    @Autowired -- Not needed for SpringBoot v2+
    public PublisherRestAPIServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher addNewPublisher(PublisherRequest publisherRequest) {
        var newPublisher = Publisher.build(null, publisherRequest.getName(), publisherRequest.getPrimaryAddress());
        newPublisher = publisherRepository.save(newPublisher);
        return newPublisher;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        var publishers = publisherRepository.findAll(Sort.by("name"));
        return publishers;
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) throws PublisherNotFoundException {
        return publisherRepository.findById(publisherId)
                .orElseThrow(()-> new PublisherNotFoundException("Publisher with ID " + publisherId +  " Not Found"));
    }

    @Override
    public Publisher updatePublisher(Integer publisherId, PublisherRequest publisherRequest) throws PublisherNotFoundException {
        publisherRepository.findById(publisherId)
                .orElseThrow(()-> new PublisherNotFoundException("Publisher with ID " + publisherId +  " Not Found"));
        var updatedPublisher = Publisher.build(publisherId,
                publisherRequest.getName(), publisherRequest.getPrimaryAddress());
        return publisherRepository.save(updatedPublisher);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
