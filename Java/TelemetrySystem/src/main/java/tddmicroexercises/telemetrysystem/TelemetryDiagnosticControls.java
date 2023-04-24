package tddmicroexercises.telemetrysystem;


public class TelemetryDiagnosticControls {
    private final String DiagnosticChannelConnectionString = "*111#";

    private final TelemetryClient telemetryClient;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    /*
       SRP: The Single Responsibility Principle violated fix,
       checkTransmission method was responsible to connect, retry and receive the diagnostic from telemetry client
    */
    public void checkTransmission() throws Exception {
        diagnosticInfo = "";
        connectToTelemetryService();
        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }

    private void connectToTelemetryService() throws Exception {
        telemetryClient.connect(DiagnosticChannelConnectionString);
        if (!telemetryClient.getOnlineStatus()) {
            retryConnectionToTelemetryService();
        }
        if (!telemetryClient.getOnlineStatus()) {
            throw new Exception("Unable to connect.");
        }
    }

    private void retryConnectionToTelemetryService() {
        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }
    }
}
