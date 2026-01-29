package FuramaManagement.repository;

import FuramaManagement.entity.Facility;
import FuramaManagement.entity.Room;
import FuramaManagement.entity.Villa;
import FuramaManagement.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static final String VILLA_PATH = "src/FuramaManagement/data/Villa.csv";
    private static final String ROOM_PATH = "src/FuramaManagement/data/Room.csv";

    @Override
    public Map<Facility, Integer> getFacilityMap() {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

        List<String> villaLines = ReadAndWriteFile.readFile(VILLA_PATH);
        for (String line : villaLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length >= 9) {
                Villa villa = new Villa(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5]),
                        parts[6],
                        Double.parseDouble(parts[7]),
                        Integer.parseInt(parts[8])
                );
                facilityMap.put(villa, 0);
            }
        }

        List<String> roomLines = ReadAndWriteFile.readFile(ROOM_PATH);
        for (String line : roomLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");

            if (parts.length >= 7) {
                Room room = new Room(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5]),
                        parts[6]
                );
                facilityMap.put(room, 0);
            }
        }

        return facilityMap;
    }

    @Override
    public List<Facility> findAll() {
        return new ArrayList<>(getFacilityMap().keySet());
    }

    @Override
    public void add(Facility facility) {
        if (facility instanceof Villa) {
            List<Villa> list = new ArrayList<>();
            list.add((Villa) facility);
            ReadAndWriteFile.writeToFile(VILLA_PATH, list, true);
        } else if (facility instanceof Room) {
            List<Room> list = new ArrayList<>();
            list.add((Room) facility);
            ReadAndWriteFile.writeToFile(ROOM_PATH, list, true);
        }
    }

    @Override
    public void update(Facility facility) {
        if (facility instanceof Villa) {
            updateVilla((Villa) facility);
        } else if (facility instanceof Room) {
            updateRoom((Room) facility);
        }
    }

    @Override
    public void delete(String id) {
        boolean deletedInVilla = deleteFromVillaFile(id);
        if (!deletedInVilla) {
            deleteFromRoomFile(id);
        }
    }

    private void updateVilla(Villa newVilla) {
        List<Facility> allFacilities = new ArrayList<>(getFacilityMap().keySet());
        List<Villa> villaList = new ArrayList<>();

        for (Facility f : allFacilities) {
            if (f instanceof Villa) villaList.add((Villa) f);
        }

        boolean found = false;
        for (int i = 0; i < villaList.size(); i++) {
            if (villaList.get(i).getService_id().equals(newVilla.getService_id())) {
                villaList.set(i, newVilla);
                found = true;
                break;
            }
        }

        if (found) {
            ReadAndWriteFile.writeToFile(VILLA_PATH, villaList, false);
        }
    }

    private void updateRoom(Room newRoom) {
        List<Facility> allFacilities = new ArrayList<>(getFacilityMap().keySet());
        List<Room> roomList = new ArrayList<>();

        for (Facility f : allFacilities) {
            if (f instanceof Room) roomList.add((Room) f);
        }

        boolean found = false;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getService_id().equals(newRoom.getService_id())) {
                roomList.set(i, newRoom);
                found = true;
                break;
            }
        }

        if (found) {
            ReadAndWriteFile.writeToFile(ROOM_PATH, roomList, false);
        }
    }

    private boolean deleteFromVillaFile(String id) {
        List<String> lines = ReadAndWriteFile.readFile(VILLA_PATH);
        List<Villa> villas = new ArrayList<>();
        boolean isRemoved = false;

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts[0].equals(id)) {
                isRemoved = true;
                continue;
            }
            if (parts.length >= 9) {
                villas.add(new Villa(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], Double.parseDouble(parts[7]), Integer.parseInt(parts[8])));
            }
        }

        if (isRemoved) {
            ReadAndWriteFile.writeToFile(VILLA_PATH, villas, false);
        }
        return isRemoved;
    }

    private void deleteFromRoomFile(String id) {
        List<String> lines = ReadAndWriteFile.readFile(ROOM_PATH);
        List<Room> rooms = new ArrayList<>();
        boolean isRemoved = false;

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts[0].equals(id)) {
                isRemoved = true;
                continue;
            }
            if (parts.length >= 7) {
                rooms.add(new Room(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6]));
            }
        }

        if (isRemoved) {
            ReadAndWriteFile.writeToFile(ROOM_PATH, rooms, false);
        }
    }
}