package com.thrall.service;

import com.thrall.domain.User;

import javax.jws.soap.SOAPBinding;

public interface LoginService {
    User login(User user);

    int register(User user);
}
