package pl.sda.cyclicdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassAThatRequiresB {

    private ClassCommon classCommon;

    public ClassAThatRequiresB(ClassCommon classCommon) {
        this.classCommon = classCommon;
    }
}
