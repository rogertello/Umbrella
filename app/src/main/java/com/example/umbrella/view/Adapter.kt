package com.example.umbrella.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umbrella.R

class Adapter(val activity:MainActivity) : RecyclerView.Adapter<Adapter.AdapterViewHolder> (){


 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
 //return AdapterViewHolder(LayoutInflater.from(activity).inflate(R.layout.))
  TODO("Not yet implemented")
 }

 override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
  TODO("Not yet implemented")
 }

 override fun getItemCount(): Int {
  TODO("Not yet implemented")
 }

 class AdapterViewHolder(v: View):RecyclerView.ViewHolder(v)
 {

 }
}