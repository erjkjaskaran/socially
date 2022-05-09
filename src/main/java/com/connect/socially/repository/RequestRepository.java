package com.connect.socially.repository;

import com.connect.socially.model.Requests;
import com.connect.socially.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Requests, Long> {

    Requests save(Requests requests);

    Long deleteByUseridAndRequestingid(User user, User requestingid);

    @Query("select r.userid from Requests r where r.requestingid= ?1 ")
    List<User> getUseridByRequestingId(User user);

}
