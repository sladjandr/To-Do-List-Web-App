package todolist.web.app.ToDoListWebApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todolist.web.app.ToDoListWebApp.models.ToDoItem;
import todolist.web.app.ToDoListWebApp.repository.ToDoItemRepository;

@Service
public class ToDoItemService {
	
	@Autowired
	ToDoItemRepository toDoItemRepository;
	
	public List<ToDoItem> findAll() {
		return toDoItemRepository.findAll();
	}
	
	public Optional<ToDoItem> findOne(Long id) {
		return toDoItemRepository.findById(id);
	}
	
	public ToDoItem saveOne(ToDoItem item) {
		return toDoItemRepository.save(item);
	}
	
	public void deleteOne(Long id) {
		toDoItemRepository.deleteById(id);
	}

}
