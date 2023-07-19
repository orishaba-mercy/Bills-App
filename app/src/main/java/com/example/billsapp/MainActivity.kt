package com.example.billsapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import com.example.billsapp.databinding.ActivityMainBinding
import com.example.billsapp.models.RegisterRequest
import com.example.billsapp.viewmodels.UserViewModels


class MainActivity : AppCompatActivity() {
    val userViewModel:UserViewModels by  viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnsignup.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        binding.btnsignup.setOnClickListener{
            clearErrors()
            validateSignup()
        }
        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this,regResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,MainActivity2::class.java))
            binding.Pbregester.visibility=View.GONE
        })
        userViewModel.regLiveData.observe(this, Observer { err ->
            Toast.makeText(this,err.message,Toast.LENGTH_LONG).show()
            binding.Pbregester.visibility= View.GONE
        })
        binding.btnsignup.setOnClickListener {
           startActivity(Intent(this,MainActivity2::class.java))
        }
    }


    fun validateSignup() {
//        var error=false
        val firstname = binding.tilFirstname.textAlignment.toString()
        val lastname = binding.tilLastName.text.toString()


        val email = binding.tilemail.text.toString()
        val password = binding.tilPassword.text.toString()
        var error = false


        if (lastname.isBlank()) {
            binding.tilLastName.error = "Enter your username"
            error = true
        }
        if (firstname.isBlank()) {
            binding.tilFirstname.error = "Enter your username"
        }

        if (email.isBlank()) {
            binding.tilemail.error = "Enter your email"
            error = true
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "enter your password"
            error = true
        }
//        if (!error) {
//            val registerRequest = RegisterRequest(
//                lastName = lastName,
//                email = email,
//                phonenumber = phoneNumber,
//                password = password,
//            )
//            userViewModel.registerUser(registerRequest)
//            Toast.makeText(
//                this, "Registration of $firstName" +
//                        " was sucessful",
//                Toast.LENGTH_LONG
//            ).show()
//        }


    }

    fun clearErrors(){
        binding.tilFirstname.error=null
        binding.tilLastName.error=null
        binding.tilemail.error =null
        binding.tilPassword.error= null

    }
}


//class MainActivity : AppCompatActivity() {
//    val userViewModel: UserViewModels by viewModels()
//    lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//    override fun onResume() {
//        super.onResume()
//        binding.btnsignup.setOnClickListener {
//            val intent = Intent(this, MainActivity2::class.java)
//            startActivity(intent)
//        }
//        binding.btnsignup.setOnClickListener{
//            clearErrors()
//            validateSignUp()
//        }
//        userViewModel.regLiveData.observe(this, Observer { regResponse ->
//            Toast.makeText(this,regResponse.message,Toast.LENGTH_LONG).show()
//            startActivity(Intent(this,MainActivity2::class.java))
//            binding.pbRegister.visibility=View.GONE
//        })
//        userViewModel.regLiveData.observe(this, Observer { err ->
//            Toast.makeText(this,err.message,Toast.LENGTH_LONG).show()
//            binding.pbRegister.visibility=View.GONE
//        })
//        binding.tvLogin.setOnClickListener {
//            startActivity(Intent(this,Login::class.java))
//        }
//    }
//
//    fun validateSignUp() {
//        val LastName=binding.tilLastName.text.toString()
//        val FirstName=binding.tilFirstname.text.toString()
//        val phoneNumber=binding.etPhonenumber.text.toString()
//        val email = binding.etEmail.text.toString()
//        val password = binding.etPassword.text.toString()
//        val confirm=binding.etConfirmpassword.text.toString()
//        var error = false
//
//        if (firstName.isBlank()) {
//            error = true
//            binding.tilFirstName.error = "First name is required"
//        }
//        if (lastName.isBlank()) {
//            binding.tilFirstName.error = "First name is required"
//            error = true
//        }
//        if (email.isBlank()) {
//            binding.tilEmail.error = "Email is required"
//            error = true
//        }
//        if (password.isBlank()) {
//            binding.tilPassword.error = "Password is required"
//            error = true
//        }
//        if (phoneNumber.isBlank()) {
//            binding.tilPhonenumber.error = "Your phone number is required"
//            error = true
//        }
//        if(!error){
//            val registerRequest=RegisterRequest(
//                firstName =firstName,
//                lastName = lastName,
//                email=email,
//                phonenumber = phoneNumber,
//                password = password,
//            )
//            userViewModel.registerUser(registerRequest)
//            Toast.makeText(this,"Registration of $firstName" +
//                    " was sucessful",
//                Toast.LENGTH_LONG).show()
//        }
//    }
//
//    fun clearErrors() {
//        binding.tilFirstName.error = null
//        binding.tilLastName
//        binding.tilEmail.error = null
//        binding.tilPassword.error = null
//        binding.tilPhonenumber.error = null
//        binding.tilConfirmpassword.error=null
//    }
//}
