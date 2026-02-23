package nimblix.in.HealthCareHub.request;

import lombok.Data;
import nimblix.in.HealthCareHub.model.RoomStatus;
import nimblix.in.HealthCareHub.model.RoomType;

@Data
public class UpdateRoomStatusRequest {
    private RoomStatus status;
    private RoomType roomType;
}
