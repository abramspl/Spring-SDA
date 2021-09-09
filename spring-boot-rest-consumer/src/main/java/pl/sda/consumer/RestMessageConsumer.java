package pl.sda.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.model.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class RestMessageConsumer implements CommandLineRunner {

    private RestTemplate restTemplate = new RestTemplate();

    private ObjectMapper objectMapper = new ObjectMapper();

    private void invokeRestGetAllMessages() throws JsonProcessingException {
        final String getAllUrl = "http://localhost:8080/api/messages";
        final String json = restTemplate.getForObject(getAllUrl, String.class);
        log.info("Received JSON with all messages: " + json);

        final List<Message> messages =
                objectMapper.readValue(json, objectMapper
                        .getTypeFactory()
                        .constructCollectionType(List.class, Message.class));

        messages.forEach(m -> log.info(m.toString()));
    }

    private void invokeRestMessageById(Integer id) {
        final String gestMessageUrl = "http://localhost:8080/api/messages/{identifier}";
        Map<String, Integer> params = new HashMap<>();
        params.put("identifier", id);

        Message message = restTemplate.getForObject(gestMessageUrl, Message.class, params);
        log.info("Received message " + message);
    }

    //zadanie - dodać metody: dodawania, usuwania, aktualizacji, patch

    @Override
    public void run(String... args) throws Exception {

// przykład działania aplikacji co 5s
//        while (true) {
//            invokeRestGetAllMessages();
//            Thread.sleep(5000); //5s
//        }

        invokeRestGetAllMessages();
        invokeRestMessageById(8);
    }
}
