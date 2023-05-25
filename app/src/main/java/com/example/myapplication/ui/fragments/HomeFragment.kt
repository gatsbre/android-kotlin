package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.MyAdapter
import com.example.myapplication.data.model.Recipe
import com.google.firebase.database.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {
    private lateinit var dbref: DatabaseReference
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var recipeArrayList: ArrayList<Recipe>
    private lateinit var searchBarView: SearchView
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recipeRecyclerView = view.findViewById(R.id.recipe_list)
        recipeRecyclerView.layoutManager = LinearLayoutManager(activity)
        recipeRecyclerView.setHasFixedSize(true)
        recipeArrayList = arrayListOf<Recipe>()
        recipeRecyclerView.adapter = MyAdapter(recipeArrayList)
        getRecipeData()

        return view
    }


    
    private fun getRecipeData() {
        dbref = FirebaseDatabase.getInstance().getReference("recipes")
        dbref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                recipeArrayList.clear()
                if (snapshot.exists()) {
                    for (recipeSnapshot in snapshot.children) {
                        val recipe = recipeSnapshot.getValue(Recipe::class.java)
                        recipeArrayList.add(recipe!!)
                    }
                    recipeRecyclerView.adapter?.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Not implemented yet
            }
        })
    }

}