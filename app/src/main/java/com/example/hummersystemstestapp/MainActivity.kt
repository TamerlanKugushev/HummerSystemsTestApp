package com.example.hummersystemstestapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import kotlinx.android.synthetic.main.toolbar_menu.*

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.fragmentContainer)
    private val navigatorHolder = BaseApplication.instance.navigatorHolder
    private val router: Router = BaseApplication.instance.router

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
                router.newRootScreen(Screens.ProductsScreen())
            }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}