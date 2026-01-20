package com.scm.backend.ContactManager.projection;

import com.scm.backend.ContactManager.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user-projection", types = {User.class})
public interface UserProjection {
    String getName();
    String getEmail();
    String getAbout();
}
