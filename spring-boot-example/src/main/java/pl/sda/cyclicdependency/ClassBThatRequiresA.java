package pl.sda.cyclicdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassBThatRequiresA {

    private ClassCommon classCommon;

    public ClassBThatRequiresA(ClassCommon classCommon) {
        this.classCommon = classCommon;
    }
}
