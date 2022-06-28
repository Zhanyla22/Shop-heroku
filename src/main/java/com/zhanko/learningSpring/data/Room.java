package com.zhanko.learningSpring.data;

import javax.persistence.*;
//entity class
@Entity
@Table(name="ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private long id;
    @Column(name = "NAME")
    private long name;
    @Column(name = "ROOM_NUMBER")
    private long roomNumber;
    @Column(name = "BED_INFO")
    private long bedInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(long bedInfo) {
        this.bedInfo = bedInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name=" + name +
                ", roomNumber=" + roomNumber +
                ", bedInfo=" + bedInfo +
                '}';
    }
}
