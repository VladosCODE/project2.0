package ru.Vladislav.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Vladislav.project2.model.Book;
import ru.Vladislav.project2.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person findPersonByBookListContains(Book book);
    Person findPersonByFio(String fio);
}
