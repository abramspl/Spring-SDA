package pl.sda.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.model.Message;
import pl.sda.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private List<Message> messages = new ArrayList<>();

    public MessageServiceImpl() {
        messages.add(new Message(1, "message-1"));
    }

    @Override
    public void addMessage(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messages;
    }

    @Override
    public void updateMessage(Message message) {
        int index = getIndexById(message.getId());
        if (index != -1) {
            messages.get(index).setText(message.getText());
        }
    }

    @Override
    public void deleteMessage(Integer id) {
        Message message = getMessageById(id);
        if (message != null) {
            messages.remove(message);
        }
    }

    @Override
    public Message getMessageById(Integer id) {
        for (Message message : messages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }
        return null;
    }

    private int getIndexById(Integer id) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}