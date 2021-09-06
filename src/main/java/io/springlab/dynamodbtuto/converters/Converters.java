package io.springlab.dynamodbtuto.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDateTime;
public class Converters {
    public static class LocalDateTimeConverter implements DynamoDBTypeConverter<String , LocalDateTime> {

        @Override
        public String convert(LocalDateTime arg0) {
            // TODO Auto-generated method stub
            return arg0.toString();
        }

        @Override
        public LocalDateTime unconvert(String arg0) {
            // TODO Auto-generated method stub
            return LocalDateTime.parse(arg0);
        }
        
    }
}
