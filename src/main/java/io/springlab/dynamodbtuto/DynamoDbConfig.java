package io.springlab.dynamodbtuto;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.springlab.dynamodbtuto.entitys.customer.DynamoDbRepository;

@Configuration
public class DynamoDbConfig {
   
    @Value("${amazon.access.key}")
    private String awsAccessKey;

    @Value("${amazon.access.secret-key}")
    private String awsSecretKey;

    @Value("${amazon.region}")
    private String awsRegion;

    @Value("${amazon.end-point.url}")
    private String awsDynamodbEndPoint;

    @Bean
    public DynamoDBMapper mapper(){

        return new DynamoDBMapper(amazonDynamoDbConfig());
    }

    public AmazonDynamoDB amazonDynamoDbConfig(){
        System.out.println(awsAccessKey + " "+ awsSecretKey);
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamodbEndPoint, awsRegion))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build();
                

    }

}
