package com.akhilscode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/items")
public class MoneyConroller {
    @Autowired
    private MoneyRepository moneyRepository;

    @Autowired
    private final ItemRepository itemRepository;

    public MoneyConroller(MoneyRepository moneyRepository, ItemRepository itemRepository) {
        this.moneyRepository = moneyRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/prices")
    public List getAllPrices(){
        log.info("Fetching all the prices");
        return moneyRepository.findAll();
    }
    @GetMapping("/{itemId}/prices")
    public Money getCostByItemId(@PathVariable Integer itemId) throws Exception {

        if(!itemRepository.existsById(itemId)) {
            throw new Exception("Item not found!");
        }

        List prices = moneyRepository.findByItemId(itemId);
        if(prices.size() > 0) {
            log.info("Fetching the price for given itemid" +itemId);
            return (Money) prices.get(0);
        }else {
            throw new Exception("Price not found!");
        }
    }

    @PostMapping("/{itemId}/prices")
    public Money addPriceforItem(@PathVariable Integer itemId,
                               @RequestBody Money money) throws Exception {
        return (Money) itemRepository.findById(itemId)
                .map(student -> {
                    money.setItem(student);
                    return moneyRepository.save(money);
                }).orElseThrow(() -> new Exception("Item not found!"));
    }

    @PutMapping("/prices/{priceId}")
    public Money updatePrice(@PathVariable("priceId") Integer priceId,
                                  @RequestBody Money priceUpdated) throws Exception {
        return moneyRepository.findById(priceId)
                .map(money -> {
                    money.setCurrency_Type(priceUpdated.getCurrency_Type());
                    money.setCurrency_Value(priceUpdated.getCurrency_Value());
                    return moneyRepository.save(money);
                }).orElseThrow(() -> new Exception("Price not found!"));
    }

    @DeleteMapping("/prices/{priceId}")
    public String deleteItemCost(@PathVariable Integer priceId) throws Throwable {
        return (String) moneyRepository.findById(priceId)
                .map(money -> {
                    moneyRepository.delete(money);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new Exception("Price not found!"));
    }
}
