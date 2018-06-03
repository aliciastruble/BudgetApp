package budget

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.icu.util.Calendar
import android.icu.util.Currency
import android.icu.util.CurrencyAmount
import java.math.BigDecimal
import java.util.*

@Entity(tableName = "transaction_table")
data class Transaction(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "location")var location: Location,
        @ColumnInfo(name = "bucket")val bucket: Bucket,
        @ColumnInfo(name = "amount")var amount: CurrencyAmount = CurrencyAmount(BigDecimal(0), Currency.getInstance(Locale.getDefault())),
        @ColumnInfo(name = "date")var date: Long = Calendar.getInstance().timeInMillis,
        @ColumnInfo(name = "note")var note: String?
)