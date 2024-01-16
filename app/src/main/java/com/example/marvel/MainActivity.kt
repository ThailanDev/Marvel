package com.example.marvel

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.marvel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            setContentView(this.root)
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
            val navController = navHostFragment.navController
            navigation.setupWithNavController(navController)


            val shortcut = ShortcutInfoCompat.Builder(this@MainActivity, "id1")
                .setShortLabel("Website")
                .setLongLabel("Open the website")
                .setIcon(IconCompat.createWithResource(this@MainActivity, com.example.core_android.R.drawable.compose_icon))
                .setIntent(
                    Intent(Intent.ACTION_VIEW,
                    Uri.parse("myapp://delaio-details"))
                )
                .build()

            ShortcutManagerCompat.pushDynamicShortcut(this@MainActivity, shortcut)
        }
    }

}