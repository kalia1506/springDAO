package kcp.spring.dao;

import java.util.Random;

public class GeneratePNR {
	public static int getPNRno() {
		return new Random().nextInt(999999999);

	}
}
