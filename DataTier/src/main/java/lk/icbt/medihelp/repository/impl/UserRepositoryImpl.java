package lk.icbt.medihelp.repository.impl;


import lk.icbt.medihelp.dtos.UserDto;
import lk.icbt.medihelp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Repository
@RestController
@RequestMapping("user")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    @PostMapping("/create")
    public boolean createUser(@RequestBody UserDto users) {
        System.out.println("Data Tier");

        Map<String, Object> params = new HashMap<>();

        params.put("username", users.getUsername());
        params.put("password", users.getPassword());

        StringBuilder query = new StringBuilder()
                .append("INSERT INTO user \n")
                .append("VALUES (0,:username, :password)");

        System.out.println(query.toString());


        //return true;
        return namedParameterJdbcTemplate.update(query.toString(), params) > 0;
    }
}
