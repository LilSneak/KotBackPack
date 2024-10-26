package com.m1ctopt1.agedatabase

import DeleteFragment
import ResultsFragment
import SearchFragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.SurfaceHolder
import android.view.inputmethod.InsertGesture
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.m1ctopt1.agedatabase.databinding.ActivityMainBinding
import InsertFragment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val drawerLayout: DrawerLayout = binding.drawerLayout

        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_insert, R.id.nav_delete, R.id.nav_search, R.id.nav_results
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, binding.appBarMain.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.nav_insert -> {
                val fragment= InsertFragment()
                transaction.replace(R.id.fragmentHolder, fragment)
            }

            R.id.nav_search -> {
                val fragment = SearchFragment()
                transaction.replace(R.id.fragmentHolder, fragment)
            }

            R.id.nav_delete -> {
                val fragment = DeleteFragment()
                transaction.replace(R.id.fragmentHolder, fragment)
            }

            R.id.nav_results -> {
                val fragment = ResultsFragment()
                transaction.replace(R.id.fragmentHolder, fragment)
            }
        }
        transaction.addToBackStack(null)
        transaction.commit()

        //drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}