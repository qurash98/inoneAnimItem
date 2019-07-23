package uz.anor_system.animcard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.anor_system.animcard.models.ProductData
import android.view.View
import uz.anor_system.animcard.R


class ProductAdapter(context: Context,val data: ArrayList<ProductData>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    private var actionListener: ProductItemActionListener? = null

    fun setActionListener(actionListener: ProductItemActionListener) {
        this.actionListener = actionListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ProductHolder =
        ProductHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_single_item, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProductAdapter.ProductHolder, position: Int) {
        val product = data[position]

        holder.itemIV.setImageResource(product.resourceId)
        holder.itemCopyIV.setImageResource(product.resourceId)

        holder.itemCopyIV.setOnClickListener {
            actionListener?.onItemTap(holder.itemCopyIV)
        }
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var itemIV: ImageView = itemView.findViewById(R.id.itemIV)
        var itemCopyIV: ImageView = itemView.findViewById(R.id.itemCopyIV)

    }


    interface ProductItemActionListener {
        fun onItemTap(imageView: ImageView)
    }
}