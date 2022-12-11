package project.st991591950.dhruvparthtapasvi

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import project.st991591950.dhruvparthtapasvi.databinding.ActivityMainBinding
import project.st991591950.dhruvparthtapasvi.myAppointments.MyAppointmentsFragment
import project.st991591950.dhruvparthtapasvi.specialist.SpecialistFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            finish()
            startActivity(intent)
        }
//        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNav)
//        bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_home -> {
//                    loadFragment(HomeFragment())
//
//                }
//                R.id.nav_specialists -> {
//                    loadFragment(SpecialistFragment())
//
//                }
//                R.id.nav_myappointments -> {
//                    loadFragment(MyAppointmentsFragment())
//
//                }
//            }
//            true
//        }

    }
//    private  fun loadFragment(fragment: Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container,fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        switch (item.getItemId()) {
//            case R.id.item1:
//            UES Uy ae

        var id = item.itemId

       // val activity = view.context as AppCompatActivity

        if (id == R.id.action_help){
            //findNavController().navigate(R.id.action_specialistFragment_to_bookAppointmentFragment)
            return true
        }
        else if (id == R.id.action_aboutUs){
            return true
        }
        else
            return super.onOptionsItemSelected(item)

//            return when (item.itemId) {
//                R.id.action_aboutUs -> true
//                R.id.action_help -> true
//            else -> super.onOptionsItemSelected(item)
//        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}