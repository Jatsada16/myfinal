package th.ac.kku.cis.myfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import th.ac.kku.cis.myfinal.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // สามารถใช้ binding ในการอ้างอิง View ใน XML layout ได้โดยตรง
        binding.mainUpload.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }

        binding.mainUpdate.setOnClickListener {
            val intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        }

        binding.mainDelete.setOnClickListener {
            val intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }

        // เพิ่ม onClickListener สำหรับปุ่มกลับไปยัง MainActivity
        binding.mainView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
