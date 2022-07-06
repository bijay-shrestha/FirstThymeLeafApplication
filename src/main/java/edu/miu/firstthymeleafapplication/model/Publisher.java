package edu.miu.firstthymeleafapplication.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    @Column(name = "publisher_name", nullable = false)
//    @NotNull(message = "Publisher Name cannot be null")
//    @NotEmpty(message = "Publisher Name cannot be empty")// name = "";
    @NotBlank(message = "Publisher Name cannot be null or empty or blank spaces")// name="   "
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="primary_addr_id", nullable = true)
    private PrimaryAddress primaryAddress;

    public Publisher() {
        this(null, null);
    }

    public Publisher(Integer publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrimaryAddress getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(PrimaryAddress primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        return String.format("{PublisherID: %d, PublisherName: %s, PrimaryAddr: %s}\n",
                publisherId, name, primaryAddress);
    }
}
