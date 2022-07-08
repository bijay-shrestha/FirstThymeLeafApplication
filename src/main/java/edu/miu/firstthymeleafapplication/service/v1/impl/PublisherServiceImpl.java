package edu.miu.firstthymeleafapplication.service.v1.impl;

import edu.miu.firstthymeleafapplication.exception.PublisherNotFoundException;
import edu.miu.firstthymeleafapplication.model.Publisher;
import edu.miu.firstthymeleafapplication.repository.PublisherRepository;
import edu.miu.firstthymeleafapplication.service.v1.PublisherService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    private PublisherRepository publisherRepository;

//    @Autowired -- Not needed for SpringBoot v2+
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher addNewPublisher(Publisher publisher) {
        var newPublisher = publisherRepository.save(publisher);
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
    public Publisher updatePublisher(Publisher updatedPublisher) {
        return publisherRepository.save(updatedPublisher);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
