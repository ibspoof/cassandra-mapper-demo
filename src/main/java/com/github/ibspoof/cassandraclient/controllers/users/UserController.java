package com.github.ibspoof.cassandraclient.controllers.users;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.mapping.Result;
import com.github.ibspoof.cassandraclient.controllers.BaseController;
import com.github.ibspoof.cassandraclient.models.User;
import com.github.ibspoof.cassandraclient.repositories.UserRepository;
import com.github.ibspoof.cassandraclient.services.CassandraService;
import com.github.ibspoof.cassandraclient.views.responses.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static com.datastax.driver.mapping.Mapper.Option.consistencyLevel;
import static com.datastax.driver.mapping.Mapper.Option.ifNotExists;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CassandraService.class.getSimpleName());

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> index() {

        Result<User> rs = userRepository.getAllUsers();
        return rs.all();
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable UUID userId) throws Exception {
        return userRepository.get(userId);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessResponse delete(@PathVariable UUID userId) throws Exception {
        if (!userRepository.delete(userId)) {
            throw new Exception("User not deleted");
        }

        return new SuccessResponse();
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User post(@Valid @RequestBody User user) throws Exception {

        if (!userRepository.save(user)) {
            throw new Exception("User unable to be saved.");
        }

        return user;
    }


}