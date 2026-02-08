package club.manager.common_library.parentDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayloadDTO {
    private Object payload;

    public <T> T getPayload(Class<T> className) {
        return className.cast(payload);
    }

    public <T> List<T> getPayloadAsList(Class<T> className) {
        ObjectMapper mapper = new ObjectMapper();
        if (payload instanceof List<?>) {
            return ((List<?>) payload).stream()
                    .map(item -> mapper.convertValue(item, className)).toList();
        }
        throw new IllegalStateException("Payload is not a List");
    }
}
