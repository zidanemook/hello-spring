package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository ->  PagingAndSortingRepository -> CrudRepository (CRUD 구현 되어있다)
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository
{
    //select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
