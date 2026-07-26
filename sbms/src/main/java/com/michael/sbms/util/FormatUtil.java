package com.michael.sbms.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class FormatUtil{
	
	public static String formatMoney(BigDecimal amount) {
		return NumberFormat.getCurrencyInstance(new Locale("en", "PH")).format(amount);
	}
}