package home.localhost.catch_message_alisa.service;


import home.localhost.catch_message_alisa.model.Item;
import home.localhost.catch_message_alisa.repository.ItemRepository;
import home.localhost.catch_message_alisa.service.interf.ItemService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public String extractItem(String command) {
        if (command == null) return "Ч т о?";
        String[] prefixes = {
                "добавить в корзину",
                "добавь в корзину",
                "добавь"
        };
        String matchedPrefix = null;
        for (String prefix : prefixes) {
            if (command.startsWith(prefix)) {
                matchedPrefix = prefix;
                break;
            }
        }
        String result = null;
        if (matchedPrefix != null) {
            result = command.substring(matchedPrefix.length()).trim();
        } else {
            result = command;
        }
        if (result.isEmpty()) {
            return "Что добавить?";
        }
        Item item = new Item();
        item.setName(result);
        item.setCreate_date(LocalDateTime.now());
        item.setStatus(1);
        itemRepository.save(item);
        return "Добавила " + result;

        //return "Что такое " + command;
    }
}
