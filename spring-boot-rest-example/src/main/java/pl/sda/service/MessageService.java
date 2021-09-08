package pl.sda.service;

import pl.sda.model.Message;
import java.util.List;

public interface MessageService {

    void addMessage(Message message);

    List<Message> getAllMessages();

    void updateMessage(Message message);

    void deleteMessage(Integer id);

    Message getMessageById(Integer id);

}
