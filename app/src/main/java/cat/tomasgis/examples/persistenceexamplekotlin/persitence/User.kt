package cat.tomasgis.examples.persistenceexamplekotlin.persitence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // Avisa que es una entidad, qualsevol taula o objecte que representa un volum es diu entitat
data class User(
    @PrimaryKey val uid: Int, // Clau primària: Clau o dades que no es repeteixen i ha d'haver-hi una (única)
    @ColumnInfo(name = "first_name") val firstName: String?, // columnas de la tabla
    @ColumnInfo(name = "last_name") val lastName: String?
)
