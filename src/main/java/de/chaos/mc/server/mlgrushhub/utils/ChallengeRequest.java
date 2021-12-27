package de.chaos.mc.server.mlgrushhub.utils;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ChallengeRequest {
    public UUID byUUID;
    public UUID toUUID;
}
