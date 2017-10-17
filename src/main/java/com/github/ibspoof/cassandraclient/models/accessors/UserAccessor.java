package com.github.ibspoof.cassandraclient.models.accessors;


import com.datastax.driver.core.ResultSet;
import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import com.github.ibspoof.cassandraclient.models.User;

import java.util.UUID;

@Accessor
public interface UserAccessor {

    @Query("SELECT * FROM users")
    Result<User> getAll();

    @Query("INSERT INTO users (user_id, name) VALUES (:userId, :name) IF NOT EXISTS")
    ResultSet insertUser(@Param("userId") UUID userId, @Param("name") String name);
}