package com.github.ibspoof.cassandraclient.models.accessors;


import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.github.ibspoof.cassandraclient.models.User;

@Accessor
public interface UserAccessor {

    @Query("SELECT * FROM users")
    Result<User> getAll();
}