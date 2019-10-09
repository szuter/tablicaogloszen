package pl.coderslab.app.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.dto.SendMessageDTO;
import pl.coderslab.app.model.Message;
import pl.coderslab.app.repositories.MessageRepository;
import pl.coderslab.app.repositories.UserRepository;

import java.util.List;

@Transactional
@Service
public class MessageService {


    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public void sendMessage(SendMessageDTO data,String email){
        Message message = new Message();
        message.setMessage(data.getMessage());
        message.setTitle(data.getTitle());
        message.setSender(userRepository.findByEmail(email));
        message.setRecipient(userRepository.findOne(data.getRecipient()));
        messageRepository.save(message);
    }


    public List<Message> getInbox(String email){
        return messageRepository.findAllByRecipientOrderByCreatedDesc(userRepository.findByEmail(email));
    }

    public List<Message> getOutBox(String email){

        return messageRepository.findAllBySenderOrderByCreatedDesc(userRepository.findByEmail(email));
    }

}
