package co.goho.qingxu.kq.service.impl;

import co.goho.qingxu.kq.dao.UserRepository;
import co.goho.qingxu.kq.entity.User;
import co.goho.qingxu.kq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean login(String qq, String pwd) {
        User user = userRepository.findById(qq).get();
        if(user!=null){
            if(user.getPwd().equals(pwd)){
                return true;
            }
        }
        return false;
    }
}
