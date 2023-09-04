package tddmicroexercises.telemetrysystem.solidway.connection;

import tddmicroexercises.telemetrysystem.solidway.ConnectionEventSimulator;

public class DefaultConnectionManager implements ConnectionManager {

	public DefaultConnectionManager(ConnectionEventSimulator connectionEventsSimulator) {
		this.connectionEventsSimulator = connectionEventsSimulator;
	}

//	private final Random connectionEventsSimulator = new Random(42);

	protected final ConnectionEventSimulator connectionEventsSimulator;

	protected boolean onlineStatus;

	public boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void connect(String telemetryServerConnectionString) {
		if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
			throw new IllegalArgumentException();
		}

		// simulate the operation on a real modem
		boolean success = connectionEventsSimulator.nextInt(10) <= 8;

		onlineStatus = success;
	}

	public void disconnect() {
		onlineStatus = false;
	}

}
