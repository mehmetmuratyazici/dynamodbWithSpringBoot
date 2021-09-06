package io.springlab.dynamodbtuto.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;

import org.slf4j.Logger;
import io.springlab.dynamodbtuto.entitys.customer.Customer;
import io.springlab.dynamodbtuto.entitys.customer.DynamoDbRepository;

import io.springlab.dynamodbtuto.DynamoDbConfig;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    
    @Autowired
    private DynamoDbRepository dynamoDbRepository;

    public boolean setCustomer(Customer customer) {
        try{
            dynamoDbRepository.insertDynamoDb(customer);
        }catch(Exception e){
            logger.debug(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Customer getCustomer(String id) {
        return (Customer) dynamoDbRepository.getObject(Customer.class,id);
    }

    public boolean deleteCustomer(String id) {
        Customer customer = new Customer.CustomerBuilder().setCustomerId(id).build();                
        return dynamoDbRepository.deleteObject(customer);
    }



}
