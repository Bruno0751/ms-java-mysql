package com.dev.ms_java_mysql.clients;

import com.dev.ms_java_mysql.dtos.general.EmailDto;
import com.dev.ms_java_mysql.models.FreguesModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailClient {

    final RabbitTemplate rabbitTemplate;
    @Value("${broker.queue.email.name}")
    private String routtingKey;

    public EmailClient(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMenssageEmail (FreguesModel freguesModel) {
        var emailDto = new EmailDto();

        emailDto.setId(freguesModel.getIdFregues());
        emailDto.setEmailTo(freguesModel.getEmail());
        emailDto.setSubject("API MySQL");
        emailDto.setText("Ola " + freguesModel.getName());

        rabbitTemplate.convertAndSend("", routtingKey, emailDto);
    }

}
