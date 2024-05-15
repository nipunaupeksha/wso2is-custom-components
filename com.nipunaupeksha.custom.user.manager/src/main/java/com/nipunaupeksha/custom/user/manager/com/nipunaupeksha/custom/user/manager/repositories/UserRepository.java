package com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.repositories;

import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
