package com.example.zemoga.repositories;

import com.example.zemoga.models.Briefcase;
import org.springframework.data.repository.CrudRepository;

public interface BriefcaseRepository extends CrudRepository<Briefcase, Long> {

    Briefcase findById(long id);
}
