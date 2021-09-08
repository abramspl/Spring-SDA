package pl.sda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.model.Message;
import pl.sda.service.MessageService;

import java.util.List;

@RestController //@Controller + @ResponseBody
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ResponseStatus(HttpStatus.OK)  //HTTP 200
    @GetMapping(path = "/api/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

}
