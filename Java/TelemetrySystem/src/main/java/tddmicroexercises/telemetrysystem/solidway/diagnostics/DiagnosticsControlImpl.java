package tddmicroexercises.telemetrysystem.solidway.diagnostics;

import tddmicroexercises.telemetrysystem.TelemetryClient;
import tddmicroexercises.telemetrysystem.solidway.connection.ConnectionManager;
import tddmicroexercises.telemetrysystem.solidway.dto.DiagnosticInfo;
import tddmicroexercises.telemetrysystem.solidway.messages.MessageExchanger;

public class DiagnosticsControlImpl implements DiagnosticsControls, DiagnosticInfoAware{
	
	private final String DiagnosticChannelConnectionString = "*111#";
	
	private ConnectionManager connectionManager;
	private MessageExchanger messageExchanger;
	private DiagnosticInfo diagnosticInfo;
	
	public DiagnosticsControlImpl(ConnectionManager connectionManager, MessageExchanger messageExchanger, DiagnosticInfo diagnosticInfo) {
		this.connectionManager = connectionManager;
		this.messageExchanger = messageExchanger;
		this.diagnosticInfo = diagnosticInfo;
	}
	
	@Override
	public void checkTransmission() throws Exception {
		diagnosticInfo.setDiagnosticInfo("");

        connectionManager.disconnect();

        int retryLeft = 3;
        while (connectionManager.getOnlineStatus() == false && retryLeft > 0)
        {
            connectionManager.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }
         
        if(connectionManager.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        messageExchanger.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo.setDiagnosticInfo(messageExchanger.receive());
		
	}

	@Override
	public String getDiagnosticInfo() {
		return diagnosticInfo.getDiagnosticInfo();
	}

	@Override
	public void setDiagnosticInfo(String diagnosticInfo) {
		this.diagnosticInfo.setDiagnosticInfo(diagnosticInfo);
	}
	
}
