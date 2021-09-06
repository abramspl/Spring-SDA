package pl.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.component.ClassWithDependencies;
import pl.sda.component.ComponentWithProperty;
import pl.sda.component.ComponentWithPropertyCollections;
import pl.sda.cyclicdependency.ClassAThatRequiresB;
import pl.sda.profile.ProfileProvider;
import pl.sda.scope.RandomNumberReader1;
import pl.sda.scope.RandomNumberReader2;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private ClassWithDependencies classWithDependencies;

    @Autowired
    private ComponentWithProperty componentWithProperty;

    @Autowired
    private ComponentWithPropertyCollections componentWithPropertyCollections;


    @Autowired
    private RandomNumberReader1 reader1;
    @Autowired
    private RandomNumberReader2 reader2;


    @Autowired
    private ProfileProvider profileProvider;


    @Autowired
    private ClassAThatRequiresB classAThatRequiresB;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello World!");

        componentWithProperty.printPropertyValue();

        System.out.println(componentWithPropertyCollections);

        reader1.printRandomNumber();
        reader2.printRandomNumber();

        System.out.println(profileProvider.getProfileName());
    }
}
