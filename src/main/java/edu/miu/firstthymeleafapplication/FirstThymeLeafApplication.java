package edu.miu.firstthymeleafapplication;

import edu.miu.firstthymeleafapplication.exception.PublisherNotFoundException;
import edu.miu.firstthymeleafapplication.model.PrimaryAddress;
import edu.miu.firstthymeleafapplication.model.Publisher;
import edu.miu.firstthymeleafapplication.service.v1.PrimaryAddressService;
import edu.miu.firstthymeleafapplication.service.v1.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstThymeLeafApplication implements CommandLineRunner {
    //    @Autowired // Field Injection
    private PublisherService publisherService;
    private PrimaryAddressService primaryAddressService;

    //    @Autowired
    public FirstThymeLeafApplication(PublisherService publisherService,
                                             PrimaryAddressService primaryAddressService) {
        this.publisherService = publisherService;
        this.primaryAddressService = primaryAddressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstThymeLeafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World SpringBoot!!!");
        Publisher mcg = new Publisher("McGraw-Hill",
                new PrimaryAddress("1000N Fouth Street", "Fairfield", "Iowa", "52557"));
        System.out.println(createNewPublisher(mcg));
        Publisher wiley = new Publisher(null, "John Wiley and Sons");
        System.out.println(createNewPublisher(wiley));
        printAllPublishers();
        printPublisherById(1);
        printPublisherById(2);
        updateAndPrintPublisherById(1);
//        deletePublisherById(3);
        System.out.println("Finished execution");
    }

    private Publisher createNewPublisher(Publisher publisher) { // C: Create
        return publisherService.addNewPublisher(publisher);
    }

    private void printAllPublishers() { // R: Read
        var publishers = publisherService.getAllPublishers();
        publishers.forEach(System.out::println);
    }

    private void printPublisherById(Integer publisherId) throws PublisherNotFoundException {
        var publisher = publisherService.getPublisherById(publisherId);
        if(publisher != null) {
            System.out.println(publisher);
        } else {
            System.out.printf("Publisher with PublisherId: %d is not found!\n", publisherId);
        }
    }

    private void updateAndPrintPublisherById(Integer publisherId) throws PublisherNotFoundException { // U: Update
        var publisher = publisherService.getPublisherById(publisherId);
        publisher.setName("McGraw-Hill, Inc.");
        var mcgAddr = new PrimaryAddress(null, "1000 N Court Street", "Cleveland",
                "OH", "52335-0001", publisher);

        publisher.setPrimaryAddress(mcgAddr);

        var newMcGrawHillAddr = primaryAddressService.addNewPrimaryAddress(mcgAddr);
        publisher.setPrimaryAddress(newMcGrawHillAddr);

        var updatedPublisher = publisherService.updatePublisher(publisher);
        System.out.println(updatedPublisher);
    }

    private void deletePublisherById(Integer publisherId) { // D: Delete
        publisherService.deletePublisherById(publisherId);
    }


}
