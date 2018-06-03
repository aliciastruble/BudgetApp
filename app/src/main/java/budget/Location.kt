package budget

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "location_table")
class Location(@PrimaryKey @ColumnInfo(name = "locationName")var word: String = "NA") {
}