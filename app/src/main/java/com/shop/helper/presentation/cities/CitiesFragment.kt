package com.shop.helper.presentation.cities

import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.shop.helper.R
import com.shop.helper.presentation.base.BaseActivity
import com.shop.helper.presentation.base.BaseFragment

class CitiesFragment : BaseFragment(), CitiesView {

    private lateinit var recyclerView: RecyclerView

    private var presenter: CitiesPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_cities, null)
        recyclerView = view.findViewById(R.id.recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CitiesPresenter(this, activity as BaseActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        getToolbar()?.title = getString(R.string.choose_your_city)
        getToolbar()?.visibility = View.VISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            activity?.supportFragmentManager?.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_cities, menu)
    }

}