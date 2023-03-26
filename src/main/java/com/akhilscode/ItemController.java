package com.akhilscode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("api/v1/items")
public class ItemController {
    @Autowired
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAllItems(){
        log.info("Fetching all existing items in the database");
        return itemRepository.findAll();
    }

    @GetMapping("{id}")
    public Item getItemByID(@PathVariable Integer id) throws Exception {
        Optional optItem = itemRepository.findById(id);
        if(optItem.isPresent()) {
            return (Item) optItem.get();
        }else {
            throw new Exception("Student not found with id " + id);
        }
    }

    @PostMapping
    public void addItem(@RequestBody Item item){
        log.info("Adding new item into the database");
        itemRepository.save(item);
    }

    @PutMapping("{itemId}")
    public Item updateStudent(@PathVariable("itemId") Integer id,
                                 @RequestBody Item itemUpdated) throws Exception {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(itemUpdated.getName());
                    item.setCategory(itemUpdated.getCategory());
                    return itemRepository.save(item);
                }).orElseThrow(() ->  new Exception("Student not found with id " + id));
    }

    @DeleteMapping("{itemId}")
    public String deleteStudent(@PathVariable("itemId")  Integer id) throws Exception {
        return itemRepository.findById(id)
                .map(item -> {
                    itemRepository.delete(item);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new Exception("Student not found with id " + id));
    }
}
