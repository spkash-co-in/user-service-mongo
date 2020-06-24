package com.chassis.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("User")
public class User {
    @Id
    private String id;
    private String fName;
    private String lName;
    private Long salary;
}
