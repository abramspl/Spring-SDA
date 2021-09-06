package pl.sda.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DevProfileProvider implements ProfileProvider{

    @Override
    public String getProfileName() {
        return "Active profile is dev";
    }
}
