package tddmicroexercises.telemetrysystem.solidway.connection;

public interface ConnectionManager {
	public void connect(String telemetryServerConnectionString);
	public void disconnect();
	public boolean getOnlineStatus();
}
