package com.zensar.forex;
/**
 * @author ARIB Anwar
 * @creation_Date: 21st Oct 2019 15:50
 * @modification_Date:21st Oct 2019 15:50
 * @version:1.0
 * Description: Entity class
 * 				This is an interface.
 */
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
