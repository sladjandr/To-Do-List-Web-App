package todolist.web.app.ToDoListWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.web.app.ToDoListWebApp.models.ToDoItem;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}
