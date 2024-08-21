package com.raja.hostelRoomAllotment.repository;



import com.raja.hostelRoomAllotment.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIsVacant(boolean isVacant);
}
