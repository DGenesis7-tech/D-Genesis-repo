package repository;

import model.SavingsRecord;

import java.util.List;

public interface SavingsRecordRepository {

    void save(SavingsRecord savingsRecord);
    List<SavingsRecord> findAll();

}
