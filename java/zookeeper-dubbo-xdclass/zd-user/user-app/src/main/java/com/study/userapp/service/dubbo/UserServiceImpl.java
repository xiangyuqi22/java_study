package com.study.userapp.service.dubbo;

import com.study.userapp.domain.TUser;
import com.study.userapp.mapper.TUserMapper;
import com.study.userserviceapi.service.IUserService;
import com.study.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO 这里的@service 是dubbo的注解 不是spring的
 * @Author xiangning
 * @Date 2019/12/3
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Value("${server.port}")
    private String port;

    @Override
    public UserVO findUserById(int id) {
        TUser tUser = tUserMapper.selectByPrimaryKey(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(tUser,userVO);
        userVO.setRemark(userVO.getRemark() + " --> from " + port);
        return userVO;
    }


}
