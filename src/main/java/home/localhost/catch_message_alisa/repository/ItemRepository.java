package home.localhost.catch_message_alisa.repository;

import home.localhost.catch_message_alisa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    //void create(Item item);
}
