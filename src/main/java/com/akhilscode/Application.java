package com.akhilscode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RestController
@Slf4j
@RequestMapping("api/v1/items")
public class Application {
	private final ItemRepository itemRepository;
	public Application(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	record NewItemRequest(
//			String name,
//			String category,
//			Money cost
//	){}
//	record NewItemUpdateRequest(
//
//			String name,
//			String category,
//			Money cost
//	){}
//	@GetMapping
//	public List<Item> getItems(){
//		log.info("Fetching all existing items in the database");
//		return itemRepository.findAll();
//	}
//	@PostMapping
//	public void addItem(@RequestBody Item item){
////		Item item= new Item();
////		item.setName(request.name());
////		item.setCategory(request.category());
////		item.setCost(request.cost());
//		log.info("Adding new item into the database");
//		itemRepository.save(item);
//	}

//	@PostMapping("/{itemid}/cost")
//	public Money addContact(@PathVariable Integer itemid,
//							  @RequestBody Money money) {
//		Item id1=itemRepository.findById(itemid).get();
//		id1.

//		return itemRepository.findById(itemid)
//
//				.map(item -> {
//					money.setItem(item);
//					return ItemRepository.save(money);
//				}).orElseThrow(() -> new ChangeSetPersister.NotFoundException("Item not found!"));
	}
//	@DeleteMapping("{itemId}")
//	public void deleteItem(@PathVariable("itemId") Integer id)
//	{
//		log.info("Deleting an item in the Database");
//		itemRepository.deleteById(id);
//	}
//	@PutMapping("{itemId}")
//	public void updateItem(@PathVariable("itemId") Integer id, @RequestBody NewItemUpdateRequest request)
//	{
//		Item id1=itemRepository.findById(id).get();
//		id1.setName(request.name());
//		id1.setCategory(request.category());
////		id1.setCost(request.cost());
//		log.info("Updating existing item in the Database");
//		itemRepository.save(id1);
//	}

