package com.example.fakestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.fakestore.databinding.FragmentItemsListBinding
import com.example.fakestore.network.FakestoreProducts
import kotlinx.android.synthetic.main.fragment_items_list.*


/**
 * A simple [Fragment] subclass.
 * Use the [ItemsList.newInstance] factory method to
 * create an instance of this fragment. 
 */
class   ItemsList : Fragment() {
    private val binding:FragmentItemsListBinding? = null


    private val viewModel: ItemsListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_items_list, container, false)

        val binding = FragmentItemsListBinding.inflate(inflater) // Inflating layout through data binding
        binding.lifecycleOwner = this // Setting lifecycle owner to current fragment
        binding.viewModel = viewModel
        /*binding.searchText.setOnQueryTextListener(object: SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.productsGrid.adapter.filter().filter(newText)
                return false
            }

        }) */
        binding.productsGrid.adapter = ProductGridAdapter(ProductGridAdapter.OnClickListener{
          //  description ->
          //  findNavController().navigate(ItemsListDirections.actionItemsListToDetailFragment())
        //    Toast.makeText(context, "${description}", Toast.LENGTH_LONG).show()

            viewModel.displayProductDetails(it)
        })
        viewModel.navigateToSelectedProduct.observe(this, Observer { fakestoreProducts ->
            if (null != fakestoreProducts){
                findNavController().navigate(ItemsListDirections.actionItemsListToDetailFragment(fakestoreProducts))
                viewModel.displayProductDetailsComplete()
            }
        })





        return binding.root

      //  binding.productsGrid.setOnClickListener {  findNavController().navigate(R.id.action_itemsList_to_detailFragment) }


    }


}