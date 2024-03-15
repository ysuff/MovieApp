package com.yusuf.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yusuf.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fragmentContainerView: FragmentContainerView
    private var navHostFragment: NavHostFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*


        bottomNavigationView=binding.bottomNavigationView
        fragmentContainerView=binding.fragmentContainerView
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment!!.navController)
        */
    }
}




/*

<?xml version="1.0" encoding="utf-8"?>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".WatchlistFragment">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:textSize="30sp"
        android:textStyle="bold"
        android:textColor="@color/end"
        android:text="@string/watclist"
        />

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="hint" />

</FrameLayout>

 */















/*
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background_color"
    android:orientation="vertical"
    tools:context=".LoginFragment">

    <LinearLayout
        android:layout_marginTop="10dp"
        android:id="@+id/linearLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <ImageView

            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:background="@drawable/cuki" />

        <TextView
            android:id="@+id/TextMovie"
            android:layout_width="200dp"
            android:textAlignment="center"
            android:layout_height="wrap_content"
            android:textStyle="bold"
            android:layout_gravity="center"
            android:text="WELCOME"
            android:textSize="35sp"


            />

    </LinearLayout>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="412dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/linearLayout">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:layout_marginTop="10dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">


            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:text="The Movie Manager"
                android:textColor="@color/black"
                android:textSize="20sp"
                android:textStyle="bold" />

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="15dp"
                android:layout_marginRight="15dp"
                android:layout_marginBottom="10dp"
                android:hint="Email"
                android:textSize="20sp"
                android:textStyle="italic" />

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="15dp"
                android:layout_marginRight="15dp"
                android:hint="Password"
                android:layout_marginBottom="10dp"
                android:textSize="20sp"
                android:textStyle="italic" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@drawable/button_edit"
                android:gravity="center"
                android:text="Login"
                android:layout_marginLeft="15dp"
                android:layout_marginRight="15dp"
                android:textColor="@color/white"
                android:textStyle="italic" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginTop="10dp"
                android:layout_marginBottom="10dp"
                android:text="OR"
                android:textAlignment="center"
                android:textSize="20sp"
                android:textStyle="italic" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@drawable/button_edit"
                android:gravity="center"
                android:text="Login via Website"
                android:layout_marginLeft="15dp"
                android:layout_marginRight="15dp"
                android:textColor="@color/white"
                android:textStyle="italic" />


        </LinearLayout>
    </androidx.constraintlayout.widget.ConstraintLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
 */

/*
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background_color"
    >

    <LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <ImageView
            android:id="@+id/loginImg"
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:layout_marginTop="10dp"
            android:background="@drawable/cuki" />

        <TextView
            android:id="@+id/loginText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:text="The Movie Manager"
            android:textSize="35sp"
            android:textStyle="bold" />


        <EditText
            android:id="@+id/loginEmail"
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:layout_marginLeft="20dp"
            android:layout_marginTop="5dp"
            android:layout_marginRight="20dp"
            android:hint="Email"
            android:inputType="textEmailAddress" />


        <EditText
            android:id="@+id/loginPswd"
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:layout_marginLeft="20dp"
            android:layout_marginTop="5dp"
            android:layout_marginRight="20dp"
            android:hint="Password"
            android:inputType="textPassword" />


        <Button
            android:id="@+id/loginLoginButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="20dp"
            android:layout_marginTop="5dp"
            android:layout_marginRight="20dp"
            android:background="@drawable/button_edit"
            android:text="Login"
            android:textAlignment="center" />

        <TextView
            android:id="@+id/loginOrText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginLeft="20dp"
            android:layout_marginTop="5dp"
            android:layout_marginRight="20dp"
            android:text="OR"
            android:textSize="20sp"
            android:textStyle="bold" />

        <Button
            android:id="@+id/loginWebButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="20dp"
            android:layout_marginTop="5dp"
            android:layout_marginRight="20dp"
            android:background="@drawable/button_edit"
            android:text="Login via Website"
            android:textAlignment="center" />

    </LinearLayout>


</androidx.constraintlayout.widget.ConstraintLayout>
 */