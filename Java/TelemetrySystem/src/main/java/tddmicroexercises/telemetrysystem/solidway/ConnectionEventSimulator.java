package tddmicroexercises.telemetrysystem.solidway;

import java.util.Random;

public class ConnectionEventSimulator extends Random{
	private final Random connectionEventsSimulator = new Random(42);
	
	public int nextInt(int bound) {
		return connectionEventsSimulator.nextInt(bound);
	}
	
}
