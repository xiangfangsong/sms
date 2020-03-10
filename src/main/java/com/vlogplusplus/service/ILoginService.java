package com.vlogplusplus.service;

import com.vlogplusplus.entity.Login;

public interface ILoginService {
    Login login(String username, String password);
}
