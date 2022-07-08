package edu.miu.firstthymeleafapplication.dto;

import edu.miu.firstthymeleafapplication.model.PrimaryAddress;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author bijayshrestha on 7/7/22
 * @project FirstThymeLeafApplication
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherRequest implements Serializable {

    @NotBlank(message = "Publisher name cannot be null, empty or blank")
    private String name;

    private PrimaryAddress primaryAddress;
}
