package tddmicroexercises.telemetrysystem.solidway.messages;

public interface MessageExchanger {
	public void send(String message);
	
	public String receive();
}
