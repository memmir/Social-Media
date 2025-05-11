package org.microservice.repository;


import org.microservice.entity.Auth;

public interface AuthRepository extends MyGenericRepo<Auth, Long> {
    Boolean existsByUserNameAndPassword(String userName, String password);
}
