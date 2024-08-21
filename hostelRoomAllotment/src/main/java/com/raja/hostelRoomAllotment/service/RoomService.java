package com.raja.hostelRoomAllotment.service;




import com.raja.hostelRoomAllotment.model.Room;
import com.raja.hostelRoomAllotment.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room allotRoomToNewPerson() {
        List<Room> vacantRooms = roomRepository.findByIsVacant(true);
        if (vacantRooms.isEmpty()) {
            return null;
        }

        Random random = new Random();
        Room roomToAllot = vacantRooms.get(random.nextInt(vacantRooms.size()));
        roomToAllot.setVacant(false);
        return roomRepository.save(roomToAllot);
    }

    public void markRoomAsVacant(Long id) {
        Room room = getRoomById(id);
        if (room != null) {
            room.setVacant(true);
            roomRepository.save(room);
        }
    }
}

