package com.tutorialspoint.coinMachine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class CoinMachine implements ICoinCalculator
{
	
	
	private Map<Double, Double> moneyMap;
	
	public CoinMachine() {
		this.moneyMap = new HashMap<>();
	}
	
	@Override
	public double totalMoney() {
		return ModuleHelper.getTotalMoney(moneyMap);
	}
	
	public void putMoneyInside(String monyInside) {
		ModuleHelper.putMonyInside(moneyMap,monyInside);
	}


	
	public void getMoney(double money) {
		if(!this.moneyMap.isEmpty() && money > 0) {
			/**trier map*/
			moneyMap = moneyMap.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
					(oldValue, newValue) -> oldValue, LinkedHashMap::new));
			
			for(Entry<Double, Double> entry: moneyMap.entrySet()) {
				if(money%entry.getKey()>0) {
					entry.setValue(entry.getValue() - (int)(money/entry.getKey()));
					money = money%entry.getKey();
				} else if(money%entry.getKey()==0) {
					entry.setValue(entry.getValue() - (int)money/entry.getKey());
					break;
				}
			}
		}
		
	}

	public double check(double value) {
		if(!this.moneyMap.isEmpty()) {
			return this.moneyMap.get(value);
		}
		return 0d;
	}
	
	

	

}
