package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sda.model.Message;
import pl.sda.service.MessageService;

import java.util.List;

@Slf4j
@RestController //@Controller + @ResponseBody
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ResponseStatus(HttpStatus.OK)  //HTTP 200
    @GetMapping(path = "/api/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getAllMessages() {
        log.info("GetAll message requested");
        return messageService.getAllMessages();
    }

    @ResponseStatus(HttpStatus.CREATED) //HTTP 201
    @PostMapping(path = "/api/messages")
    public void createMessage(@RequestBody Message message) {
        log.info("Received message to save: " + message);
        messageService.addMessage(message);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/api/messages/{identifier}")
    public Message getMessageById(@PathVariable Integer identifier ) { //@PathVariable - do tekstu w klamerkach {identifier}
        log.info("Received message identifier: " + identifier);
        return messageService.getMessageById(identifier);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) //HTTP 204
    @PutMapping(path = "/api/messages")
    public void updateMessage(@RequestBody Message message) {
        log.info("Received message update: " + message);
        messageService.updateMessage(message);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/api/messages/{identifier}")
    public void deleteMessageById(@PathVariable Integer identifier) {
        log.info("Received message identifier to delete: " + identifier);
        messageService.deleteMessage(identifier);
    }
}
