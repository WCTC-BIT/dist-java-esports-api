package edu.wctc.distjavaesportsapi.repository;

import edu.wctc.distjavaesportsapi.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
