package com.example.fakestore


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestore.databinding.ListItemViewBinding
import com.example.fakestore.network.FakestoreProducts
import kotlinx.android.synthetic.main.list_item_view.view.*
import java.util.*
import java.util.zip.Inflater
import kotlin.collections.ArrayList

//private const val TAG = "ItemsList"
class ProductGridAdapter(val onClickListener: OnClickListener) : ListAdapter<FakestoreProducts,ProductGridAdapter.FakeStoreProductsViewHolder>(DiffCallback) {
 /*   var productFilterList = ArrayList<FakestoreProducts>()
    init {
        productFilterList = currentList as ArrayList<FakestoreProducts>
    } */


    
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductGridAdapter.FakeStoreProductsViewHolder {
        return FakeStoreProductsViewHolder(ListItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: ProductGridAdapter.FakeStoreProductsViewHolder,
        position: Int
    ) {
        val fakeStoreProducts = getItem(position)
        holder.itemView.button.setOnClickListener {
            onClickListener.onClick(fakeStoreProducts)
        }

        holder.bind(fakeStoreProducts)
    }




    class FakeStoreProductsViewHolder(private var binding:ListItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind (fakeStoreProducts:FakestoreProducts){
            binding.product = fakeStoreProducts

              //  binding.button.setOnClickListener {
                  //  DetailFragmentBinding.inflate(LayoutInflater.from(this,))
               //     it.findNavController().navigate(R.id.action_itemsList_to_detailFragment) }

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FakestoreProducts>(){
        override fun areItemsTheSame(
            oldItem: FakestoreProducts,
            newItem: FakestoreProducts
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: FakestoreProducts,
            newItem: FakestoreProducts
        ): Boolean {
            return oldItem.image == newItem.image
        }

    }

    class OnClickListener(val clickListener: (fakestoreProducts:FakestoreProducts) -> Unit) {
        fun onClick(fakeStoreProducts: FakestoreProducts) = clickListener(fakeStoreProducts)
    }

   /* override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    var fakeStoreProducts:ArrayList<FakestoreProducts>
                    productFilterList = currentList as ArrayList<FakestoreProducts>
                } else {
                    val resultList = ArrayList<FakestoreProducts>()
                    for (row in currentList) {
                        if (row.title.contains(charSearch)) {
                            resultList.add(row)
                        }
                    }
                    productFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = productFilterList
                return filterResults
            }
            @Suppress("UNCHECKED_CAST")

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                productFilterList = results?.values as ArrayList<FakestoreProducts>
                notifyDataSetChanged()
            } */




}