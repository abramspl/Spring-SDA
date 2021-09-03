package pl.sda.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassWithDependencies {

    @Autowired
    private DependencyA dependencyA;

    @Autowired
    private DependencyB dependencyB;

}
