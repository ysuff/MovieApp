package com.yusuf.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.yusuf.movieapp.R
import com.yusuf.movieapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginLoginButton: Button
    private lateinit var loginMailEditText: EditText
    private lateinit var loginPswdEditText: EditText
    private lateinit var loginSingUpButton: Button
    private lateinit var loginAuth: FirebaseAuth
    private lateinit var loginNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginMailEditText = binding.loginMailEditText
        loginPswdEditText = binding.loginPswdEditText
        loginLoginButton = binding.loginLoginButton
        loginSingUpButton = binding.loginSingUpButton

        loginSingUpButton.setOnClickListener {
            val goSingUpPage = LoginFragmentDirections.actionLoginFragmentToSingUpFragment()
            Navigation.findNavController(it).navigate(goSingUpPage)

        }
        loginInit(view)
        loginEvent()
    }

    private fun loginInit(view: View) {
        loginNavController = Navigation.findNavController(view)
        loginAuth = FirebaseAuth.getInstance()
    }


    private fun loginEvent() {
        loginMailEditText = binding.loginMailEditText
        loginPswdEditText = binding.loginPswdEditText
        loginLoginButton = binding.loginLoginButton
        loginLoginButton.setOnClickListener {
            val loginEmail = loginMailEditText.text.toString()
            val loginPassword = loginPswdEditText.text.toString()

            if (loginEmail.isNotEmpty() && loginPassword.isNotEmpty()) {

                loginAuth.signInWithEmailAndPassword(loginEmail, loginPassword)
                    .addOnCompleteListener(
                        OnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(
                                    context,
                                    "Başarıyla Giriş Yapıldı",
                                    Toast.LENGTH_SHORT
                                ).show()
                                loginNavController.navigate(R.id.action_loginFragment_to_mainActivity2)
                            } else {
                                Toast.makeText(context, it.exception?.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    )


            }

        }
    }


}