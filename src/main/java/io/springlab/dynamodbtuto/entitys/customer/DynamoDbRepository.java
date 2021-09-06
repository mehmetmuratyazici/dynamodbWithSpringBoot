package io.springlab.dynamodbtuto.entitys.customer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import org.slf4j.Logger;

@Repository
public class DynamoDbRepository {
    private static final Logger logger = LoggerFactory.getLogger(DynamoDbRepository.class);


    @Autowired
    private DynamoDBMapper mapper;

    

    public void insertDynamoDb(Object obj){
        mapper.save(obj);
    }

    public Object getObject( Class cObj,Object hashKey){
        return mapper.load(cObj,hashKey);
    }

    public boolean deleteObject(Object customer){
        try{
            mapper.delete(customer);
        }catch(Exception ex){
            logger.debug(ex.getMessage());
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
