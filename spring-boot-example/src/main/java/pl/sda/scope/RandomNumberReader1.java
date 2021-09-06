package pl.sda.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberReader1 {

    @Autowired
    private RandomNumberProvider provider;

    public void printRandomNumber() {
        System.out.println(provider.getRandomValue());
    }
}
