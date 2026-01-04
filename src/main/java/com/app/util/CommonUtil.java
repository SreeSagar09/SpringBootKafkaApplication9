package com.app.util;

import java.util.UUID;

public class CommonUtil {
	public static String generateOrderId() {
		return UUID.randomUUID().toString();
	}
}
