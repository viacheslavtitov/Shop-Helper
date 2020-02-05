package com.shop.helper.presentation.cities.add

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shop.helper.R
import com.shop.helper.ShopHelperApplication
import com.shop.helper.data.network.places.entities.Predictions
import com.shop.helper.presentation.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject


class AddNewCityFragment @Inject constructor() : BaseFragment(), AddNewCityView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    private var adapter: AddNewCityAdapter? = null
    @Inject lateinit var presenter: AddNewCityPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as ShopHelperApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_add_new_city, null)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.attachView(this, getBaseActivity())
    }

    override fun onDestroyView() {
        presenter?.detachView()
        super.onDestroyView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        getToolbar()?.title = getString(R.string.add_new_city)
        getToolbar()?.visibility = View.VISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            activity?.supportFragmentManager?.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_city, menu)
        val searchItem = menu.findItem(R.id.action_search)
        if (searchItem != null) {
            searchView = searchItem.actionView as SearchView
        }
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                Timber.d(s)
                if (s.length > 2) {
                    presenter?.searchCity(s)
                }
                return false
            }
        })
    }

    override fun displayCities(cities: List<Predictions>?) {
        adapter = if (cities != null) {
            AddNewCityAdapter(cities)
        } else {
            null
        }
        recyclerView.adapter = adapter
    }
}