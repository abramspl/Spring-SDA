package pl.sda.profile;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MainProfileProvider implements ProfileProvider{

    @Override
    public String getProfileName() {
        return "Active profile is main";
    }
}
