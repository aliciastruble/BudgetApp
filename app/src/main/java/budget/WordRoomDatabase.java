package budget;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.icu.util.Currency;
import android.icu.util.CurrencyAmount;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;

@Database(entities = {Transaction.class}, version = 1, exportSchema=false)
public abstract class WordRoomDatabase extends RoomDatabase {
    private static WordRoomDatabase INSTANCE;
    public static WordRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    public abstract WordDao wordDao();

    private static RoomDatabase.Callback sRoomDatabaseCallback =
        new RoomDatabase.Callback(){
            @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db){
                super.onOpen(db);
                new PopulateDbAsync(INSTANCE).execute();
            }
        };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteAll();
            mDao.insert(new Transaction(1, new Location("Grocery"),
                    new Bucket("Food", BigDecimal.TEN),
                    new CurrencyAmount(BigDecimal.ONE, Currency.getInstance(Locale.getDefault())),
                    Calendar.getInstance().getTimeInMillis(),""));


            return null;
        }
    }
}
