package pl.sda.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "pl.sda")
@Component
public class ComponentWithProperty {

    @Value("${pl.sda.example.value}")
    private String propertyValue;


    //musi istnieć setter
    private  String fieldA;
    //musi istnieć setter
    private  Integer fieldB;


    public void printPropertyValue() {
        System.out.println("Wartość z pliku application.properties: " + propertyValue);
        System.out.println("Wartość fieldA: " + fieldA);
        System.out.println("Wartość fieldB: " + fieldB);
    }


    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    public void setFieldB(Integer fieldB) {
        this.fieldB = fieldB;
    }
}
