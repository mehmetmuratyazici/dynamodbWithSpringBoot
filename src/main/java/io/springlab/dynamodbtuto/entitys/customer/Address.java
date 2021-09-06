package io.springlab.dynamodbtuto.entitys.customer;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class Address {
    @DynamoDBAttribute
    private String country;
    @DynamoDBAttribute
    private String city;
    @DynamoDBAttribute
    private String zipCode;
    
    
}
