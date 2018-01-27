package com.almi.samples.bootwithdatabase.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Almi on 27-Jan-18.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findAllByLockedTrue();

    @Query("select (count(u) > 0) from User u where u.email=:mail")
    boolean hasUsersWithMail(@Param("mail") String email);
}
