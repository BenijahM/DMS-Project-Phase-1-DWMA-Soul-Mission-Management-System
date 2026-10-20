/**
 * Be'Nijah Mitchell
 * CEN 3024-13038 - Software Development 1
 * October 17, 2026
 * Class: RecordManager
 * Objective:This class manages the collection of records in the DMS.
 * It stores record objects in an ArrayList and provides methods for adding,
 * locating, removing, displaying, and updating records. It also prevents
 * duplicate record IDs from being added to the collection.
 */
import java.util.ArrayList;
import java.util.List;
public class RecordManager {
    private List<SoulMissionRecord> records;

    // Constructor
    public RecordManager() {
        records = new ArrayList<>();
    }

    /**
     * Method: addRecord
     * Purpose: Adds a record to the collection if no other record has the same ID.
     * Arguments: record (the record object to be added to the collection).
     * Return: true if the record was successfully added, false if the record
     * with the same ID already exists.
     */
    public boolean addRecord(SoulMissionRecord record) {
        if (findById(record.getRecordId()) != null) {
            return false;
        }
        if (record == null) {
            return false;
        }
        if (record.getRecordId() <= 0) {
            return false;
        }
        records.add(record);
        return true;
    }

    /**
     * Method: deleteRecord
     * Purpose: Removes a record from the collection using the record's ID.
     * Arguments: record ID (the ID entered by the user).
     * Return: true if the record was found and removed; false if no record
     * with the specified ID exists.
     */
    public boolean deleteRecord(int recordId) {
        SoulMissionRecord record = findById(recordId);

        if (record != null) {
            records.remove(record);
            return true;
        }
        return false;
    }

    /**
     * Method: updateRecord
     * Purpose: Updates the information of an existing record.
     * Arguments: record (the record containing the updated information).
     * Return: true if the record was updated; false if the record
     * does not exist or the supplied record is null.
     */
    public boolean updateRecord(SoulMissionRecord updatedRecord) {
        if (updatedRecord == null) {
            return false;
        }

        SoulMissionRecord existingRecord =
                findById(updatedRecord.getRecordId());

        if (existingRecord == null) {
            return false;
        }

        existingRecord.setTeamName(updatedRecord.getTeamName());
        existingRecord.setPartnerType(updatedRecord.getPartnerType());
        existingRecord.setKishinSoulsCollected(
                updatedRecord.getKishinSoulsCollected());
        existingRecord.setWitchSoulsCollected(
                updatedRecord.getWitchSoulsCollected());
        existingRecord.setTrainingLevel(updatedRecord.getTrainingLevel());
        existingRecord.setActiveStatus(updatedRecord.isActiveStatus());
        existingRecord.setLastMissionDate(updatedRecord.getLastMissionDate());

        return true;
    }

    /**
     * Method: findById
     * Purpose: Searches the collection for a record with the specified ID.
     * Arguments: record ID (the ID entered by the user).
     * Return: The record object with the matching ID, or null if no matching
     * record is found.
     */
    public SoulMissionRecord findById(int recordId) {
        for (SoulMissionRecord record : records) {
            if (record.getRecordId() == recordId) {
                return record;
            }
        }
        return null;
    }

    /**
     * Method: findByTeamName
     * Purpose: Searches the collection for a record with the specified team name.
     * Arguments: team name (the team name entered by the user).
     * Return: The record object with the matching team name, or null if no matching
     * record is found.
     */
    public SoulMissionRecord findByTeamName(String teamName) {
        for (SoulMissionRecord record : records) {
            if (record.getTeamName().equalsIgnoreCase(teamName)) {
                return record;
            }
        }
        return null;
    }


    /**
     * Method: getAllRecords
     * Purpose: Displays the information for every record currently stored
     * in the collection. If no records are currently stored, a message is
     * displayed.
     * Arguments: None.
     * Return: This method displays the record information directly
     * to the console.
     */
    public void getAllRecords() {
        for (SoulMissionRecord record : records) {
            System.out.println(record);
        }
        if (records.isEmpty()) {
            System.out.println("There are currently no records in the system.");
            return;
        }
    }

    /**
     * Method: containsId
     * Purpose: Checks whether a record with the specified ID exists.
     * Arguments: recordId (the ID entered by the user).
     * Return: true if the record exists; otherwise, false.
     */
    public boolean containsId(int recordId) {
        return findById(recordId) != null;
    }

    /**
     * Method: getRecordCount
     * Purpose: Returns the number of records currently stored.
     * Arguments: None.
     * Return: The number of records in the collection.
     */
    public int getRecordCount() {
        return records.size();
    }
}


