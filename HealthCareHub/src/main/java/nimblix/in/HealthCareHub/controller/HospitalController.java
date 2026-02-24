package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.model.Room;
import nimblix.in.HealthCareHub.request.UpdateRoomStatusRequest;
import nimblix.in.HealthCareHub.serviceImpl.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/hospital")
public class HospitalController {
    @Autowired
    private HospitalServiceImpl hospitalServiceImpl;

    // UPDATE ROOM STATUS
    @PatchMapping("/{hospitalId}/rooms/{roomNumber}/status")
    public ResponseEntity<Room> updateRoomStatus(@PathVariable Long hospitalId, @PathVariable String roomNumber, @RequestBody UpdateRoomStatusRequest request) {
        Room updatedRoom = hospitalServiceImpl.updateRoomStatus(
                hospitalId,
                roomNumber,
                request.getStatus(),
                request.getRoomType()
        );

        return ResponseEntity.ok(updatedRoom);
    }


}
