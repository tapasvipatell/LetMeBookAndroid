package project.st991591950.dhruvparthtapasvi.specialist

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_specialist.*
import kotlinx.android.synthetic.main.specialist_item.*
import project.st991591950.dhruvparthtapasvi.R
import project.st991591950.dhruvparthtapasvi.bookappointment.BookAppointmentFragment
import project.st991591950.dhruvparthtapasvi.databinding.FragmentHomeBinding
import project.st991591950.dhruvparthtapasvi.databinding.FragmentSpecialistBinding

class SpecialistFragment : Fragment() {

//    private var layoutManager: RecyclerView.LayoutManager? = null
//    private var adapter: RecyclerView.Adapter<MyRecycleView.MyViewHolder>? = null
    private lateinit var myAdapter : MyRecycleView
    private lateinit var recycleView: RecyclerView
    private  lateinit var list: ArrayList<SpecialistList>
    private var  fireStoreDatabase = FirebaseFirestore.getInstance()

    private var _binding: FragmentSpecialistBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      //  val ourList = generateDummyList(6)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_specialist, container, false)

        _binding = FragmentSpecialistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recycleView = binding.recycleView
        recycleView.layoutManager = LinearLayoutManager(SpecialistFragment().context)
        recycleView.setHasFixedSize(true)

        list = arrayListOf()

        myAdapter = MyRecycleView(list)
        recycleView.adapter = myAdapter

        EventChangeListner()

        return root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycleView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            //adapter = MyRecycleView(generateDummyList(6))
        }
//        binding.buttonBook.setOnClickListener{
//
//            findNavController().navigate(R.id.action_specialistFragment_to_bookAppointmentFragment)
//        }


    }

    private  fun EventChangeListner( )
    {
        fireStoreDatabase.collection("Doctors").addSnapshotListener(object: EventListener<QuerySnapshot>{
            override  fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ){
                if(error != null){
                    Log.e("Firestore error", error.message.toString())
                       return
                }
                for (dc: DocumentChange in value?.documentChanges!!){
                    if (dc.type == DocumentChange.Type.ADDED){
                        list.add(dc.document.toObject(SpecialistList::class.java))
                    }
                }
                myAdapter.notifyDataSetChanged()
            }
        })
    }

//    private fun generateDummyList(size: Int): List<SpecialistList> {
//
////        for (i in 0 until size) {
////            val drawable = when (i%6){
////                0 -> R.drawable.doctorimage
////                1 -> R.drawable.doctorimage
////                2 -> R.drawable.doctorimage
////                3 -> R.drawable.doctorimage
////                4 -> R.drawable.doctorimage
////                5 -> R.drawable.doctorimage
////                else -> R.drawable.ic_launcher_foreground
////            }
////            val specialistname = arrayOf("Tapasvi", "Parth", "Dhruv", "John", "Morgan", "Stella")
////            val speciality = arrayOf("Dentist", "Hygienist", "Hygienist", "Dentist", "Dentist", "Dentist")
////            val clinicname = arrayOf("AppleCare", "AppleCare", "Nirvana", "Civic", "Civic", "Civic")
////
////            val item = SpecialistList(drawable, specialistname[i], speciality[i], clinicname[i])
////            list += item
////        }
////        return list
////        fireStoreDatabase.collection("Doctors")
////            .addSnapshotListener(object : EventListener<QuerySnapshot> {
////                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
////                    if (error != null)
////                    {
////                        Log.e("Firestore error", error.message.toString())
////                        return
////                    }
////
////                    for (dc: DocumentChange in value?.documentChanges!!){
////                        if (dc.type == DocumentChange.Type.ADDED){
////                            list.add(dc.document.toObject(SpecialistList::class.java))
////                        }
////                    }
////                    adapter?.notifyDataSetChanged()
////
////                }
////            })
////
////        return list
// val dName = arrayOf("")
//        val dSpeciality = arrayOf("")
//        val clinicName = arrayOf("")
//        fireStoreDatabase.collection("Doctors")
//            .get()
//            .addOnCompleteListener {
//                val result: StringBuffer = StringBuffer()
//                if(it.isSuccessful) {
//                    for(document in it.result!!) {
//                        result.appent(document.data.values)
//
//                    }
//                    list += result
//                }
//            }
//
//    }

   }

