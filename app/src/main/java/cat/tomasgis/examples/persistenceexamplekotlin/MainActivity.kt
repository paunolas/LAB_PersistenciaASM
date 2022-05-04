package cat.tomasgis.examples.persistenceexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room
import cat.tomasgis.examples.persistenceexamplekotlin.developing.DevUtils
import cat.tomasgis.examples.persistenceexamplekotlin.persitence.AppDatabase
import cat.tomasgis.examples.persistenceexamplekotlin.persitence.UserDao

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val view: TextView = this.findViewById<TextView>(R.id.name)

        // First database
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        // Second database
        val dbSecondary = AppDatabase.getInstance(this)

        val userDao: UserDao = db.userDao()
        val userDatabaseSecondary: UserDao = dbSecondary.userDao()

        databasePrimary(userDao)
        databaseSecondary(userDatabaseSecondary, view)

    }

    // Esto no hay que hacerlo en la práctica
    fun databasePrimary(userDao: UserDao){
        DevUtils.deleteFakeData(userDao)
        DevUtils.insertFakeData(userDao)
        DevUtils.plotDBUsers(userDao)
    }

    fun databaseSecondary(userDao: UserDao, view:TextView){
        DevUtils.deleteFakeData(userDao)
        DevUtils.insertFakeData(userDao)
        DevUtils.plotDBUsers(userDao)
        DevUtils.updateView(userDao, view)
    }

}