package yte.proje.obs.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageResponse {
    private final String message;
    private final MessageType messageType;

    public boolean hasError() {
        return messageType.equals(MessageType.ERROR);
    }
}
