package cat.tomasgis.examples.persistenceexamplekotlin.persitence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Scooter(
    @PrimaryKey val uuid: Int,
    @ColumnInfo(name = "identifier") val firstName: String
)