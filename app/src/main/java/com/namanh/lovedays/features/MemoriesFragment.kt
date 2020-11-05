package com.namanh.lovedays.features

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.namanh.lovedays.R
import com.namanh.lovedays.core.base.BaseFragment
import com.namanh.lovedays.core.extension.viewModel
import com.namanh.lovedays.core.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_memories.*
import javax.inject.Inject

class MemoriesFragment : BaseFragment() {
    @Inject
    lateinit var navigator: Navigator
    @Inject
    lateinit var memoriesAdapter: MemoriesAdapter
    private lateinit var memoriesViewModel: MemoriesViewModel

    override fun layoutId() = R.layout.fragment_memories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        appComponent.inject(this)

//        memoriesViewModel = viewModel(viewModelFactory) {
//
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadMoviesList()
    }

    private fun initializeView() {
        memoriesAdapter = MemoriesAdapter()
        memoriesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        memoriesList.adapter = memoriesAdapter
    }

    private fun loadMoviesList() {
        memoriesList.visibility = View.VISIBLE
        memoriesAdapter.collection = listOf(
            MemoryView(0, "Love song", "Song from a secret garden", 1, 1, 2020),
            MemoryView(1, "Love mail", "Song from a secret garden", 1, 1, 2020),
            MemoryView(2, "Love dance", "Sexy dance", 1, 1, 2020),
            MemoryView(3, "Love message", "Song from a secret garden", 1, 1, 2020),
            MemoryView(4, "Love book", "A book about love", 1, 1, 2020),
            MemoryView(5, "Love film", "A film about love", 1, 1, 2020)
        )
    }
}