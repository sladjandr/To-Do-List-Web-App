package todolist.web.app.ToDoListWebApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import todolist.web.app.ToDoListWebApp.models.ToDoItem;
import todolist.web.app.ToDoListWebApp.service.ToDoItemService;

@Controller
@RequestMapping(value = "api/item")
public class ToDoItemController {
	
	@Autowired
	ToDoItemService toDoItemService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ToDoItem>> findAll(){
		List<ToDoItem> items = toDoItemService.findAll();
		return new ResponseEntity<List<ToDoItem>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<ToDoItem> findOne(@PathVariable Long id){
		Optional<ToDoItem> optionalItem = toDoItemService.findOne(id);
		if(optionalItem.isPresent()) {
			ToDoItem item = optionalItem.get();
			return new ResponseEntity<ToDoItem>(item, HttpStatus.OK);
		}else {
			return new ResponseEntity<ToDoItem>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ToDoItem> saveOne(@RequestBody ToDoItem item){
		if(item != null) {
			ToDoItem savedItem = toDoItemService.saveOne(item);
			return new ResponseEntity<ToDoItem>(savedItem, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<ToDoItem>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<ToDoItem> editOne(@PathVariable Long id, @RequestBody ToDoItem editedItem){
		Optional<ToDoItem> optionalItem = toDoItemService.findOne(id);
		if(optionalItem.isPresent()) {
			editedItem.setId(optionalItem.get().getId());
			ToDoItem savedItem = toDoItemService.saveOne(editedItem);
			return new ResponseEntity<ToDoItem>(savedItem, HttpStatus.OK);
		}else {
			return new ResponseEntity<ToDoItem>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ToDoItem> deleteOne(@PathVariable Long id){
		Optional<ToDoItem> optionalItem = toDoItemService.findOne(id);
		if(optionalItem.isPresent()) {
			toDoItemService.deleteOne(id);
			return new ResponseEntity<ToDoItem>(HttpStatus.OK);
		}else {
			return new ResponseEntity<ToDoItem>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
