package com.vinnhelper.VinNHelper.repositories;

import com.vinnhelper.VinNHelper.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
