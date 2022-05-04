package cat.tomasgis.examples.persistenceexamplekotlin.persitence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao // Data access object, indica que es una interface que va a ser un objeto de aceso a la BBDD
interface UserDao {
    @Query("SELECT * FROM user") // Query: Defineixes les funcions que farà a la BBDD
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User


    @Insert
    fun insertAll(vararg users: User) //vararg: puedo entrarle un user suelto o una lista de users

    @Delete
    fun delete(user: User)

    @Query ("DELETE FROM user")
    fun deleteAll()
}