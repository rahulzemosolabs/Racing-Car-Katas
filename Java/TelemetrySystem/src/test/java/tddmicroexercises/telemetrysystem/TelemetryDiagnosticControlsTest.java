package tddmicroexercises.telemetrysystem;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tddmicroexercises.telemetrysystem.solidway.ConnectionEventSimulator;
import tddmicroexercises.telemetrysystem.solidway.connection.ConnectionManager;
import tddmicroexercises.telemetrysystem.solidway.connection.DefaultConnectionManager;
import tddmicroexercises.telemetrysystem.solidway.diagnostics.DiagnosticsControlImpl;
import tddmicroexercises.telemetrysystem.solidway.diagnostics.DiagnosticsControls;
import tddmicroexercises.telemetrysystem.solidway.dto.DiagnosticInfo;
import tddmicroexercises.telemetrysystem.solidway.messages.DefaultMessageExchanger;
import tddmicroexercises.telemetrysystem.solidway.messages.MessageExchanger;

public class TelemetryDiagnosticControlsTest
{
    
	@Test
	public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() {
		DiagnosticInfo diagnosticInfo = new DiagnosticInfo();
		ConnectionEventSimulator connEventSimulator = new ConnectionEventSimulator();
		
		ConnectionManager connectionManager = new DefaultConnectionManager(connEventSimulator);
		MessageExchanger messageExchanger = new DefaultMessageExchanger(connEventSimulator);
		
		DiagnosticsControls diagnosticsControls = new DiagnosticsControlImpl(connectionManager, messageExchanger, diagnosticInfo);
		
		
		try {
			diagnosticsControls.checkTransmission();
		} catch (Exception e) {
			fail();
		}
		
		Assertions.assertNotNull(diagnosticInfo.getDiagnosticInfo(), "Diagnostic info not available");
		
	}

}
