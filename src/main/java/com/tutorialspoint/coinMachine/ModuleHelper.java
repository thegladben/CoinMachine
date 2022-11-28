package com.tutorialspoint.coinMachine;

import java.util.Map;

public class ModuleHelper  {
	
	public static final String OPERATOR ="x";	
	
	public static double getTotalMoney(Map<Double, Double> moneyMap) {
		if(!moneyMap.isEmpty()) {
			Double result = 0d;
			for (Map.Entry<Double, Double> entry : moneyMap.entrySet()) {
			    result +=entry.getKey() * entry.getValue() ;
			}
			return result;
		}
		return 0d;
	}
	

	public static void putMonyInside(Map<Double, Double> moneyMap, final String monyInside) {
		if (monyInside.indexOf(OPERATOR)==0){
			return;
		}
		try {
			String[] monyTab = monyInside.split(OPERATOR);
			if(moneyMap.get(Double.valueOf(monyTab[1])) !=null) {
				moneyMap.put(Double.valueOf(monyTab[1]), moneyMap.get(Double.valueOf(monyTab[1]))+Double.valueOf(monyTab[0]))  ;
			} else {
				moneyMap.put(Double.valueOf(monyTab[1]), Double.valueOf(monyTab[0]))  ;
			}
			
		} catch (Exception e) {
			return ;
		}
		
	}
	
	public static double round(double value, int places) {
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	

}
