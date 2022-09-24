package com.example.heroes.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.heroes.Model.HeroeResponse
import com.example.heroes.R
import com.squareup.picasso.Picasso

class MyHeroAdapter(private val context: Context, private val heroList: MutableList<HeroeResponse>):
    RecyclerView.Adapter<MyHeroAdapter.MyViewHolder>() {



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.tvName)
        val image: ImageView = itemView.findViewById(R.id.imgHero)
        val powerstats:TextView = itemView.findViewById(R.id.tvPowerstats)
        val biography: TextView = itemView.findViewById(R.id.tvBiog)
        val appearance: TextView = itemView.findViewById(R.id.tvAppearance)
        val occupation: TextView = itemView.findViewById(R.id.tvOccupation)
        val relatives: TextView = itemView.findViewById(R.id.tvRelatives)


        fun bind(listItem: HeroeResponse) {
            image.setOnClickListener {
                Toast.makeText(it.context, "  ${itemView.findViewById<View>(R.id.imgHero)}",
                    Toast.LENGTH_SHORT).show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "  ${itemView.findViewById<View>(R.id.tvName)}",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent,
            false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = heroList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = heroList[position]
        holder.bind(listItem)

        Picasso.get().load(heroList[position].image).into(holder.image)
        holder.name.text = heroList[position].name
        holder.powerstats.text = heroList[position].powerstats
        holder.biography.text = heroList[position].biography
        holder.appearance.text = heroList[position].appearance
        holder.occupation.text = heroList[position].occupation
        holder.relatives.text = heroList[position].relatives

    }

}