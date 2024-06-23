package com.example.wigellssushi.controller;

import com.example.wigellssushi.model.Room;
import com.example.wigellssushi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PutMapping("/updateroom/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room roomDetails) {
        return roomService.updateRoom(id, roomDetails);
    }

    @GetMapping("/rooms/{id}")
    @PreAuthorize("hasRole('USER')")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }
}
