package rafa.paba.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var btnTambah: Button
    private lateinit var btnHapus: Button
    private lateinit var adapter: ArrayAdapter<String>
    private var data = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv1)
        btnTambah = findViewById(R.id.btnTambah)
        btnHapus = findViewById(R.id.btnHapus)

        // Tambahkan data awal ke dalam list
        data.addAll(listOf("Item 1", "Item 2", "Item 3"))

        // Buat adapter dan hubungkan dengan ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        listView.adapter = adapter

        // Tambah data ke ListView saat button tambah ditekan
        btnTambah.setOnClickListener {
            val newItem = "Item ${data.size + 1}"
            data.add(newItem)
            adapter.notifyDataSetChanged()
        }

        // Hapus data pertama dari ListView saat button hapus ditekan
        btnHapus.setOnClickListener {
            if (data.isNotEmpty()) {
                data.removeFirst()
                adapter.notifyDataSetChanged()
            }
        }

        // Menampilkan item yang diklik menggunakan Toast
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = data[position]
            Toast.makeText(this, "Anda memilih: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}