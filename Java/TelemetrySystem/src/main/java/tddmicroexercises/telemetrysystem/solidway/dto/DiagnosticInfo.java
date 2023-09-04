package tddmicroexercises.telemetrysystem.solidway.dto;

import java.io.Serializable;

public class DiagnosticInfo implements Serializable{
	private static final long serialVersionUID = 7310698544802632108L;
	private String diagnosticInfo;

	public String getDiagnosticInfo() {
		return diagnosticInfo;
	}

	public void setDiagnosticInfo(String diagnosticInfo) {
		this.diagnosticInfo = diagnosticInfo;
	}
	
	
}
