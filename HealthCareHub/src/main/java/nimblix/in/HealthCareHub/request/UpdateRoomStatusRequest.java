package nimblix.in.HealthCareHub.request;

import lombok.Data;

@Data
public class UpdateRoomStatusRequest {
    private Long hospitalId;
    private String roomNumber;
    private String status;
    private String Type;
}
