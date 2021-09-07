package pl.sda.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!dev")
@Component
public class MainProfileProvider implements ProfileProvider{

    @Override
    public String getProfileName() {
        return "Active profile is main";
    }
}
