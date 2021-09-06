package pl.sda.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "pl.sda.collections")
@Component
public class ComponentWithPropertyCollections {

    private List<String> strings;

    private Map<String, Integer> map;


    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }


    @Override
    public String toString() {
        return "ComponentWithPropertyCollections{" +
                "strings=" + strings +
                ", map=" + map +
                '}';
    }
}
