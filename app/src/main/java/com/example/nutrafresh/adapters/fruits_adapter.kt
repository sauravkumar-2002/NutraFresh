package com.example.nutrafresh.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.nutrafresh.R
import com.example.nutrafresh.models.url_model


class fruits_adapter(var context: Context) :
    RecyclerView.Adapter<fruits_adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ft1Name = itemView.findViewById<TextView>(R.id.ft1_name)
        val ft2Name = itemView.findViewById<TextView>(R.id.ft2_name)
        val ft2 = itemView.findViewById<CardView>(R.id.ft2)
        val ft1 = itemView.findViewById<CardView>(R.id.ft1)
    }
    private var url_list = mutableListOf<url_model>()
    fun seturllist(url_list: List<url_model>) {
        this.url_list = url_list as MutableList<url_model>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_advertisement, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ft1Name.text = url_list[position].ft1_name
        holder.ft2Name.text = url_list[position].ft2_name
        holder.ft1.setOnClickListener {
            setDialog(context,url_list[position].ft1_name,url_list[position].ft1_desc,url_list[position].ft1_image)
        }
        holder.ft2.setOnClickListener {
            setDialog(context,url_list[position].ft2_name,url_list[position].ft2_desc,url_list[position].ft2_image)
        }
    }

    override fun getItemCount(): Int {
        return url_list.size
    }
}
fun setDialog(context: Context, ft1Name: String, ft1Desc: String, ft1Image: String) {
    val alertadd = AlertDialog.Builder(context)
    val factory = LayoutInflater.from(context)
    val view1: View = factory.inflate(R.layout.activity_details_page, null)
    var ft_img=view1.findViewById<ImageView>(R.id.ft_img)
    var ft_name=view1.findViewById<TextView>(R.id.ft_name)
    var ft_desc=view1.findViewById<TextView>(R.id.ft_desc)
    ft_img.setImageResource(R.drawable.baseline_menu_24)
    ft_name.text=ft1Name
    ft_desc.text=ft1Desc
    alertadd.setView(view1)
    alertadd.setNegativeButton("OK", DialogInterface.OnClickListener { dialog, which ->
        dialog.dismiss()
    })
    alertadd.show()

}