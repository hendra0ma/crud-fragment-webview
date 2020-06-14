package com.corona.sharedpreference

import android.os.Bundle
import android.os.UserManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.google.android.gms.common.SignInButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.real_fragment.*

class realFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.real_fragment,container,false)

        var NameText : EditText = view.findViewById(R.id.name)
        var UmurText : EditText = view.findViewById(R.id.umur)

        var submit : Button = view.findViewById(R.id.submit)
        submit.setOnClickListener {
            val name = NameText.text.toString().trim()
            val umur = UmurText.text.toString().trim()
            when{
                name.isEmpty() -> Toast.makeText(this.context,"nama harus ada",Toast.LENGTH_SHORT).show()
                umur.isEmpty() -> Toast.makeText(this.context,"umur harus ada",Toast.LENGTH_SHORT).show()
            }

            val ref = FirebaseDatabase.getInstance().getReference("heroes")
            var heroid = ref.push().key
            val hero = Hero(heroid!!,name,umur)
            ref.child(heroid).setValue(hero).addOnCompleteListener {
                Toast.makeText(this.context,"sudah tersimpan",Toast.LENGTH_SHORT).show()
            }

        }








        return view
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}