package com.vlogplusplus.service.impl;

import com.vlogplusplus.dao.ILoginDao;
import com.vlogplusplus.entity.Login;
import com.vlogplusplus.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private ILoginDao iLoginDao;

    @Override
    public Login login(String username, String password) {
        return iLoginDao.login(username, password);
    }
}
