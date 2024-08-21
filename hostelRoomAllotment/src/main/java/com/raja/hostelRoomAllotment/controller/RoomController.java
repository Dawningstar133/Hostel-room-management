package com.raja.hostelRoomAllotment.controller;



import com.raja.hostelRoomAllotment.model.Room;
import com.raja.hostelRoomAllotment.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        room.setId(id);  // Ensure the ID is set correctly
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

    @PutMapping("/allot")
    public Room allotRoomToNewPerson() {
        return roomService.allotRoomToNewPerson();
    }

    @PutMapping("/vacant/{id}")
    public void markRoomAsVacant(@PathVariable Long id) {
        roomService.markRoomAsVacant(id);
    }
}
