package com.butchjgo.simplecas.repository;

import com.butchjgo.simplecas.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "delete from user_profile where user_id= :userId")
    void removeByUserId(@Param("userId") long userId);
}
