package com.tempatpelayanankesehatan.tpk.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tempatpelayanankesehatan.tpk.R
import com.tempatpelayanankesehatan.tpk.util.Session
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.EasyPermissions

/**
 * Created by Azhar Rivaldi on 22-12-2019.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!EasyPermissions.hasPermissions(this, android.Manifest.permission.ACCESS_FINE_LOCATION) || !EasyPermissions.hasPermissions(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {

            EasyPermissions.requestPermissions(this, "Aplikasi membutuhkan lokasi mu", 991, android.Manifest.permission.ACCESS_FINE_LOCATION)
            EasyPermissions.requestPermissions(this, "Aplikasi membutuhkan lokasi mu", 992, android.Manifest.permission.ACCESS_COARSE_LOCATION)

        }

        Toast.makeText(this, "${Session.bearer}", Toast.LENGTH_SHORT).show()

        layoutHospitalMain.setOnClickListener {
            startActivity(Intent(applicationContext, ClinicActivity::class.java))
        }
        layoutDrugStoreMain.setOnClickListener {
            startActivity(Intent(applicationContext, DrugsStoreActivity::class.java))
        }
        layoutRumahSakit.setOnClickListener {
            startActivity(Intent(applicationContext, HospitalActivity::class.java))
        }
        layoutPuskesmas.setOnClickListener {
            startActivity(Intent(applicationContext, PuskesmasActivity::class.java))
        }
        layoutAboutMain.setOnClickListener {
            startActivity(Intent(applicationContext, AboutActivity::class.java))
        }
        layoutHelpMain.setOnClickListener {
            startActivity(Intent(applicationContext, HelpActivity::class.java))
        }

    }
}
