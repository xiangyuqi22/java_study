package com.study.userserviceapi.service;

import com.study.userserviceapi.vo.UserVO;

public interface IUserService {

    UserVO findUserById(int id);

}
