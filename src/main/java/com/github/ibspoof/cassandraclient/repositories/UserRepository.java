package com.github.ibspoof.cassandraclient.repositories;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.Result;
import com.github.ibspoof.cassandraclient.exceptions.NotFoundException;
import com.github.ibspoof.cassandraclient.models.User;
import com.github.ibspoof.cassandraclient.models.accessors.UserAccessor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.datastax.driver.mapping.Mapper.Option.consistencyLevel;
import static com.datastax.driver.mapping.Mapper.Option.ifNotExists;

@Repository
public class UserRepository extends AbstractRepository {

    private static UserAccessor userAccessor;
    private static Mapper<User> userMapper;

    UserRepository() {
        if (userAccessor == null) {
            userAccessor = mappingManager.createAccessor(UserAccessor.class);
        }
        if (userMapper == null) {
            userMapper = mappingManager.mapper(User.class);
        }
    }

    public boolean delete(UUID userId) throws Exception {

        get(userId);

        try {
            userMapper.delete(userId);
        } catch (Exception e) {
            throw new Exception("User " + userId.toString() + " not deleted.");
        }
        return true;
    }


    public boolean save(User user) {
        try {
            userMapper.save(user, ifNotExists(true), consistencyLevel(ConsistencyLevel.LOCAL_QUORUM));
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public User get(UUID userId) throws Exception {
        User user;

        try {
            user = userMapper.get(userId);
        } catch (Exception e) {
            throw new Exception("User " + userId.toString() + " not found");
        }

        if (user == null) {
            throw new NotFoundException("User " + userId.toString() + " not found");
        }

        return user;
    }


    public Result<User> getAllUsers() {
        return userAccessor.getAll();
    }


}
