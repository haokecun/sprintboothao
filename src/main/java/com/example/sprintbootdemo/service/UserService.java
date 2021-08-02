package com.example.sprintbootdemo.service;

import com.example.sprintbootdemo.VO.UserVO;
import com.example.sprintbootdemo.entity.User;
import com.example.sprintbootdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    public void createUser(User user){
        userMapper.insertSelective(user);
    }

    public void createUserValidated(UserVO user){
//        userMapper.insertSelective(user);
    }

    public void updateUser(User user){
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void findExample() {

        log.info("---------------按照主键查询:where id = 100 ---------------");
        User user = userMapper.selectByPrimaryKey(100);
        log.info(user.toString());
        log.info(user.getUsername());

        log.info("---------------按照性别查询:where sex = 1 ---------------");
        User sex = new User();
        sex.setSex((byte)1);
        List<User> sexUsers = userMapper.select(sex);
        log.info("查询性别为1的记录共：{}条",sexUsers.size());

        log.info("---------------按照姓名和密码查询:where username = ? & password = ?  ---------------");
        User namePwd = new User();
        namePwd.setUsername("update1");
        namePwd.setPassword("update1");
        User findUser = userMapper.selectOne(namePwd);
        log.info(findUser.toString());

        /**
         * 复杂查询用Example.Criteria
         */
        log.info("----------------Example.Criteria查询： where username=? and password=?----------------");
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username","update1");
        criteria.andEqualTo("password","update1");
        List<User> userCri = userMapper.selectByExample(example);
        log.info("Example.Criteria的查询结果：{}",userCri.toString());

        log.info("----------------Example.Criteria模糊查询： where username like ?----------------");
        example = new Example(User.class);
        criteria.andLike("username","%10%");
        List<User> userlike = userMapper.selectByExample(example);
        log.info("Example.Criteria的模糊查询结果：{}",userlike.toString());

        log.info("----------------Example.Criteria模糊查询： where username like ? order by id desc----------------");
        example = new Example(User.class);
        example.setOrderByClause("id desc ");
        criteria.andLike("username","%10%");
         userlike = userMapper.selectByExample(example);
        log.info("Example.Criteria的模糊查询结果：{}",userlike.toString());

        log.info("----------------Example.Criteria in 查询： where id  in (1,2) ----------------");
        example = new Example(User.class);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        criteria.andIn("id",list);
        List<User> userAndIn = userMapper.selectByExample(example);
        log.info("Example.Criteria的In查询结果：{}",userAndIn.toString());

        log.info("----------------分页查询1----------------");
        User sexUser = new User();
        sexUser.setSex((byte)1);
        int count = userMapper.selectCount(sexUser);
        log.info("分页例子1：总条数{}",count);
        List<User> obj1 = userMapper.selectByRowBounds(sexUser,new RowBounds(0,10));
        for(User u:obj1){
            log.info("分页查询第一页：{}",u.toString());
        }

        log.info("----------------Example.Criteria分页查询2----------------");
        example = new Example(User.class);
        criteria = example.createCriteria();
        criteria.andEqualTo("sex",1);
        int count2 = userMapper.selectCountByExample(example);
        log.info("分页例子2：总条数{}",count2);
        List<User> obj2 = userMapper.selectByExampleAndRowBounds(example,new RowBounds(0,10));
        for(User u:obj2){
            log.info("分页查询第一页：{}",u.toString());
        }
    }
}
