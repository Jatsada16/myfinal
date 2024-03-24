package th.ac.kku.cis.myfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import th.ac.kku.cis.myfinal.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.uploadName.text.toString().trim()
            val operator = binding.uploadOperator.text.toString().trim()
            val location = binding.uploadLocation.text.toString().trim()
            val phone = binding.uploadPhone.text.toString().trim()

            if (name.isEmpty() || operator.isEmpty() || location.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            database = FirebaseDatabase.getInstance().reference.child("Student ID")
            val users = User(name, operator, location, phone)
            database.child(phone).setValue(users)
                .addOnSuccessListener {
                    binding.uploadName.text.clear()
                    binding.uploadOperator.text.clear()
                    binding.uploadLocation.text.clear()
                    binding.uploadPhone.text.clear()
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@UploadActivity, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
