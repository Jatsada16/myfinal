package th.ac.kku.cis.myfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import th.ac.kku.cis.myfinal.databinding.ActivityDeleteBinding

class DeleteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeleteBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.deleteButton.setOnClickListener {
            val phone = binding.deletePhone.text.toString()
            if (phone.isNotEmpty())
                deleteData(phone)
            else
                Toast.makeText(this, "Please enter the phone number", Toast.LENGTH_SHORT).show()
        }
    }
    private fun deleteData(phone: String){
        database = FirebaseDatabase.getInstance().getReference("Student ID")
        database.child(phone).removeValue().addOnSuccessListener {
            binding.deletePhone.text.clear()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Unable to delete", Toast.LENGTH_SHORT).show()
        }
    }
}