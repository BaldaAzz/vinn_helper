package com.vinnhelper.VinNHelper.repositories;

import com.vinnhelper.VinNHelper.models.UserVinCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVinCheckHistoryRepository extends JpaRepository<UserVinCheckHistory, Long> {
}
