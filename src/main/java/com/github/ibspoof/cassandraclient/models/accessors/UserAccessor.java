package com.github.ibspoof.cassandraclient.models.accessors;


import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.datastax.driver.mapping.annotations.QueryParameters;
import com.github.ibspoof.cassandraclient.models.User;

@Accessor
public interface UserAccessor {

    @Query("SELECT * FROM users")
    @QueryParameters(consistency="LOCAL_ONE")
    Result<User> getAll();
}