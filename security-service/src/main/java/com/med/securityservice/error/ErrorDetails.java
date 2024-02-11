package com.med.securityservice.error;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.security.Timestamp;
import java.time.Instant;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ErrorDetails {
    private String message ;
    private String url;
    private Instant timeStamp ;
}
