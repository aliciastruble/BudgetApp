package budget

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "bucket_table")
class Bucket(@PrimaryKey @ColumnInfo(name = "name")var word: String = "FirstBucket",
             @ColumnInfo(name = "amount")var amount: BigDecimal = BigDecimal(0)) {
}