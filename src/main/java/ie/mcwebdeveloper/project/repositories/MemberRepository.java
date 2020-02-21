package ie.mcwebdeveloper.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.mcwebdeveloper.project.models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    
}