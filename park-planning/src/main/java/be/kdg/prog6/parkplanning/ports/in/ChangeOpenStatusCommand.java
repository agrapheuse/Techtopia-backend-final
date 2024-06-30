package be.kdg.prog6.parkplanning.ports.in;

import java.util.UUID;

public record ChangeOpenStatusCommand(UUID uuid, boolean open) {
}
