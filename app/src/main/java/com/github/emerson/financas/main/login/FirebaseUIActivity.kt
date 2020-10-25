package com.github.emerson.financas.main.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.github.emerson.financas.BuildConfig
import com.github.emerson.financas.R
import com.github.emerson.financas.databinding.ActivityFirebaseUiBinding
import com.github.emerson.financas.main.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * Demonstrate authentication using the FirebaseUI-Android library. This activity demonstrates
 * using FirebaseUI for basic email/password sign in.
 *
 * For more information, visit https://github.com/firebase/firebaseui-android
 */
class FirebaseUIActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityFirebaseUiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseUiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.signInButton.setOnClickListener(this)
        binding.signOutButton.setOnClickListener(this)
        binding.continueButton.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        updateUI(auth.currentUser)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == Activity.RESULT_OK) {
                // Sign in succeeded
                checkUserStatus()
                nextStep()
            } else {
                // Sign in failed
                Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
    }

    private fun checkUserStatus() {
        viewModel.registerUser()
    }

    private fun startSignIn() {
        // Build FirebaseUI sign in intent. For documentation on this operation and all
        // possible customization see: https://github.com/firebase/firebaseui-android
        val intent = AuthUI.getInstance().createSignInIntentBuilder()
            .setIsSmartLockEnabled(!BuildConfig.DEBUG)
            .setAvailableProviders(
                listOf(
                    AuthUI.IdpConfig.EmailBuilder().build(),
                    AuthUI.IdpConfig.FacebookBuilder().build(),
                    AuthUI.IdpConfig.GoogleBuilder().build()
                )
            )
            .setLogo(R.mipmap.ic_launcher)
            .build()

        startActivityForResult(intent,
            RC_SIGN_IN
        )
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // Signed in
            binding.status.text = getString(R.string.firebaseui_status_fmt, user.email)
            binding.detail.text = getString(R.string.id_fmt, user.uid)

            binding.signInButton.visibility = View.GONE
            binding.signOutButton.visibility = View.VISIBLE
        } else {
            // Signed out
            binding.status.setText(R.string.signed_out)
            binding.detail.text = null

            binding.signInButton.visibility = View.VISIBLE
            binding.signOutButton.visibility = View.GONE
        }
        binding.continueButton.visibility = binding.signOutButton.visibility
    }

    private fun signOut() {
        AuthUI.getInstance().signOut(this)
        updateUI(null)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.signInButton -> startSignIn()
            R.id.signOutButton -> signOut()
            R.id.continueButton -> nextStep()
        }
    }

    fun nextStep() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
    companion object {
        private const val RC_SIGN_IN = 9001
    }
}
