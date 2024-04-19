package com.yusuf.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.yusuf.movieapp.R
import com.yusuf.movieapp.databinding.FragmentSingUpBinding


private lateinit var binding: FragmentSingUpBinding
private lateinit var singUpNavController: NavController
private lateinit var singupGoBackToLoginButton:Button
private lateinit var singupEmailEditText: EditText
private lateinit var singupSingupButton: Button
private lateinit var singupPasswordEditText: EditText
private lateinit var singupPasswordControlEditText: EditText
private lateinit var singupAuth: FirebaseAuth



class SingUpFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingUpBinding.inflate(inflater,container,false)
        singupGoBackToLoginButton = binding.singupGoBackToLoginButton
        singupSingupButton = binding.singupSingupButton
        singupEmailEditText = binding.singupEmailEditText
        singupPasswordEditText = binding.singupPasswordEditText
        singupPasswordControlEditText = binding.singupPasswordControlEditText


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        singupGoBackToLoginButton.setOnClickListener {
            val goLoginPage = SingUpFragmentDirections.actionSingUpFragmentToLoginFragment()
            Navigation.findNavController(it).navigate(goLoginPage)
        }
        singupInit(view)
        registerEvent()
    }
    private fun singupInit(view: View) {
        singUpNavController = Navigation.findNavController(view)
        singupAuth = FirebaseAuth.getInstance()
    }

    private fun registerEvent() {


        singupSingupButton.setOnClickListener {
            val singupEmail = singupEmailEditText.text.toString()
            val singupPassword = singupPasswordEditText.text.toString()
            val singupControlPassowrd = singupPasswordControlEditText.text.toString()

            if (singupEmail.isNotEmpty() && singupPassword.isNotEmpty() && singupControlPassowrd.isNotEmpty()) {
                if (singupPassword == singupControlPassowrd) {
                    singupAuth.createUserWithEmailAndPassword(singupEmail, singupPassword).addOnCompleteListener(
                        OnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(context,"Kayıt Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show()
                                singUpNavController.navigate(R.id.action_singUpFragment_to_serchScreenFragment)
                            } else {
                                Toast.makeText(
                                    context,it.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    )

                }

            }
        }

    }



}