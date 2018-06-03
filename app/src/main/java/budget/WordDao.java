package budget;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(Transaction transaction);

    @Query("DELETE FROM transaction_table")
    void deleteAll();

    @Query("SELECT * FROM transaction_table ORDER BY date ASC")
    LiveData<List<Transaction>> getAllWords();


}
