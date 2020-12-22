package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	@Modifying  
	@Transactional
	@Query(value = "update todo m set m.completed=:completed ", nativeQuery=true)
	void checkAll(@Param("completed") Boolean completed);

	@Modifying  
	@Transactional
	@Query(value = "delete from todo where id in (select t.id from (select m.id from todo m where m.completed = 1) as t)", nativeQuery=true)
	void clearCompleted();

}
