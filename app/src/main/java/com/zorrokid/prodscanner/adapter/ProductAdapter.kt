package com.zorrokid.prodscanner.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zorrokid.prodscanner.R
import com.zorrokid.prodscanner.model.Product

class ProductAdapter (
    private val dataset: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
{
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val barcodeView: TextView = view.findViewById(R.id.product_barcode)
        val nameView: TextView = view.findViewById(R.id.product_name)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductViewHolder {
        // Create a new view
        // LayoutInflater instantiates a layout XML file into its corresponding View objects
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_product, viewGroup, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = dataset[position]
        Log.d("ProductAdapter", "Dataset size. " + dataset.size)
        holder.barcodeView.text = item.barcode
        holder.nameView.text = item.name
    }

    override fun getItemCount() = dataset.size
}