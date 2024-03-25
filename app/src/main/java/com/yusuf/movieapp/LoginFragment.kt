package com.yusuf.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.yusuf.movieapp.databinding.FragmentLoginBinding
import java.util.regex.Pattern

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginLoginButton:Button
    private lateinit var loginMailEditText:EditText
    private lateinit var loginPswdEditText:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginMailEditText = binding.loginMailEditText
        loginPswdEditText = binding.loginPswdEditText
        loginLoginButton = binding.loginLoginButton

        loginLoginButton.setOnClickListener {
            val email = loginMailEditText.text.toString().trim()
            val password = loginPswdEditText.text.toString().trim()

            if (email.isEmpty()) {
                showToast("Email adresi boş olamaz")
                return@setOnClickListener
            }

            if (!email.contains("@") || !email.endsWith(".com")) {
                showToast("Geçerli bir e-mail adresi girin")
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                showToast("Parola boş olamaz")
                return@setOnClickListener
            }

            if (!isValidPassword(password)) {
                showToast("Parola büyük küçük harf, noktalama ve sayı içermelidir ve en az 8 karakterden oluşmalıdır")
                return@setOnClickListener
            }

            val login =
                com.yusuf.movieapp.LoginFragmentDirections.actionLoginFragmentToSerchScreenFragment()
            Navigation.findNavController(it).navigate(login)
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val upperCasePattern = Pattern.compile("[A-Z]")
        val lowerCasePattern = Pattern.compile("[a-z]")
        val digitPattern = Pattern.compile("[0-9]")
        val specialCharPattern = Pattern.compile("[^a-zA-Z0-9]")

        return password.length >= 8 &&
                upperCasePattern.matcher(password).find() &&
                lowerCasePattern.matcher(password).find() &&
                digitPattern.matcher(password).find() &&
                specialCharPattern.matcher(password).find()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


}