package tddmicroexercises.telemetrysystem.solidway.messages;

import java.util.Objects;

import tddmicroexercises.telemetrysystem.solidway.ConnectionEventSimulator;
import tddmicroexercises.telemetrysystem.solidway.constant.TelementryConstants;

public class DefaultMessageExchanger implements MessageExchanger {

	public DefaultMessageExchanger(ConnectionEventSimulator connectionEventSimulator) {
		this.connectionEventsSimulator = connectionEventSimulator;
	}

	private String diagnosticMessageResult = "";
	public static final String DIAGNOSTIC_MESSAGE = TelementryConstants.DIAGNOSTIC_MESSAGE;

//	private final Random connectionEventsSimulator = new Random(42);

	private final ConnectionEventSimulator connectionEventsSimulator;

	public void send(String message) {
		if (message == null || "".equals(message)) {
			throw new IllegalArgumentException();
		}

		if (message == DIAGNOSTIC_MESSAGE) {
			// simulate a status report
			diagnosticMessageResult = "LAST TX rate................ 100 MBPS\r\n"
					+ "HIGHEST TX rate............. 100 MBPS\r\n" + "LAST RX rate................ 100 MBPS\r\n"
					+ "HIGHEST RX rate............. 100 MBPS\r\n" + "BIT RATE.................... 100000000\r\n"
					+ "WORD LEN.................... 16\r\n" + "WORD/FRAME.................. 511\r\n"
					+ "BITS/FRAME.................. 8192\r\n" + "MODULATION TYPE............. PCM/FM\r\n"
					+ "TX Digital Los.............. 0.75\r\n" + "RX Digital Los.............. 0.10\r\n"
					+ "BEP Test.................... -5\r\n" + "Local Rtrn Count............ 00\r\n"
					+ "Remote Rtrn Count........... 00";

			return;
		}

		// here should go the real Send operation (not needed for this exercise)
	}

	public String receive() {
		String message;
		
		// Objects.isNull is more readable format
		// Objects.equals is more readable format
		if (Objects.isNull(diagnosticMessageResult) || Objects.equals("", diagnosticMessageResult)) {
			// simulate a received message (just for illustration - not needed for this
			// exercise)
			message = "";
			int messageLength = connectionEventsSimulator.nextInt(50) + 60;
			for (int i = messageLength; i >= 0; --i) {
				message += (char) connectionEventsSimulator.nextInt(40) + 86;
			}

		} else {
			message = diagnosticMessageResult;
			diagnosticMessageResult = "";
		}

		return message;
	}
}
