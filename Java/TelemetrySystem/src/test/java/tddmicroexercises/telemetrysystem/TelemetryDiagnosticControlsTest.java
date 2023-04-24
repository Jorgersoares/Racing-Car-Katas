package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TelemetryDiagnosticControlsTest
{

    TelemetryClient telemetryClient;
    @BeforeEach
    public void init() {
        telemetryClient = mock(TelemetryClient.class);
    }

    @Test
    public void Should_throw_exception_after_retry_failed_attempts() {
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
        assertThrows(Exception.class, telemetryDiagnosticControls::checkTransmission);
    }

	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        doReturn(true).when(telemetryClient).getOnlineStatus();
        doReturn("Teste").when(telemetryClient).receive();
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
        telemetryDiagnosticControls.checkTransmission();
        assertFalse(telemetryDiagnosticControls.getDiagnosticInfo().isEmpty());
    }

    @Test
    public void Should_retry_connection() throws Exception {
        doReturn(false).when(telemetryClient).getOnlineStatus();
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
        try {
            telemetryDiagnosticControls.checkTransmission();
        } catch (Exception ignored) {}
        verify(telemetryClient, Mockito.times(4)).connect(Mockito.anyString());
    }




}
