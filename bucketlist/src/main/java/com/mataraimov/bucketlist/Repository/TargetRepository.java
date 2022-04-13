package com.mataraimov.bucketlist.Repository;

import com.mataraimov.bucketlist.Entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TargetRepository extends JpaRepository<Target,Long>{

}
