package com.zensar.currency.conversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @author ARIB Anwar
 * @creation_Date: 21st Oct 2019 17:46
 * @modification_Date:21st Oct 2019 17:46
 * @version:1.0
 * Description: Controller class
 * 				This is a RESTFull WebService
 */
@RestController
public class CurrencyConversionController {

	//private logger logger= LoggerFactory.getLogger(this.getClass());
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariable= new HashMap<>();
		
		uriVariable.put("from", from);
		uriVariable.put("to", to);
	
		//How one web service can call another web service.
		ResponseEntity<CurrencyConversionBean> responseEntity = 
				new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class,
				uriVariable);
				
				CurrencyConversionBean response = responseEntity.getBody();
				
		return new CurrencyConversionBean(response.getId(), from, to,
				response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()),
				response.getPort());
	
	}
}
