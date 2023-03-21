package com.akhilscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/items")
public class WalmartInterviewPracticeApplication {

	private final ItemRepository itemRepository;

	public WalmartInterviewPracticeApplication(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public static void main(String[] args) {
		System.out.println("Hello World");

		SpringApplication.run(WalmartInterviewPracticeApplication.class, args);
	}

	@GetMapping
	public List<Item> getItems(){
		return itemRepository.findAll();
	}

	record NewItemRequest(
			String name,
			String category,
			Integer cost
	){

	}

	@PostMapping
	public void addItem(@RequestBody NewItemRequest request){
		Item item= new Item();
		item.setName(request.name());
		item.setCategory(request.category());
		item.setCost(request.cost());
		itemRepository.save(item);
	}

	@DeleteMapping("{itemId}")
	public void deleteItem(@PathVariable("itemId") Integer id)
	{
		itemRepository.deleteById(id);
	}

	@GetMapping("/greet")
	public GreetResponse greet()
	{
		return new GreetResponse("Hello", List.of("Java", "Python", "Golang"), new Person("Alex", 25, 6000));
	}

	record Person(String name, int age, double savings){}

	record GreetResponse(String greet, List<String> favProgrammingLanguges, Person person)
	{

	}

}
