package com.scm.backend.ContactManager.entity.events;

import com.scm.backend.ContactManager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    private Logger log = LoggerFactory.getLogger(UserEventHandler.class);

    @HandleBeforeCreate
    public void handleBeforeCreate(User user){
        log.info("---- Going to create a user ----");
        user.setId(UUID.randomUUID().toString());
    }
}
