package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.model.Room;
import nimblix.in.HealthCareHub.model.RoomStatus;
import nimblix.in.HealthCareHub.model.RoomType;
import nimblix.in.HealthCareHub.repository.HospitalRepository;
import nimblix.in.HealthCareHub.repository.RoomRepository;
import nimblix.in.HealthCareHub.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private RoomRepository roomRepository;


    //updating room status with hospital id and room number
    public Room updateRoomStatus(Long hospitalId, String roomNumber, RoomStatus status, RoomType roomType) {
        Room room = roomRepository.findByHospital_IdAndRoomNumber(hospitalId, roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        if (status != null) room.setStatus(status);
        if (roomType != null) room.setRoomType(roomType);

        return roomRepository.save(room);
    }
}
