package pl.sda.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class RandomNumberProvider {

    private final int randomValue = new Random().nextInt();

    public int getRandomValue() {
        return randomValue;
    }

}
