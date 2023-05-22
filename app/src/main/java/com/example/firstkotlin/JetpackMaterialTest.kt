package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstkotlin.databinding.ActivityJetpackMaterialTestBinding
import com.google.android.material.tabs.TabLayoutMediator

class JetpackMaterialTest : AppCompatActivity() {
    lateinit var drawerToggle: ActionBarDrawerToggle

    class ViewPagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
        val fragments : List<Fragment>
        init {
            fragments = listOf(Fragment1(), Fragment2(), Fragment3())
        }
        override fun getItemCount(): Int = fragments.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityJetpackMaterialTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)
        drawerToggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 토글 버튼으로 사용할 아이콘 출력
        drawerToggle.syncState() // 토글 버튼을 햄버거 아이콘으로

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // TabLayout과 ViewPager2 연동
        TabLayoutMediator(binding.tabs, binding.viewPager)
        { tab, position -> tab.text = "Tab${(position + 1)}"}.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        // MenuItem 객체를 얻고 그 안에 포함된 ActionView 객체 획득
        val menuItem = menu.findItem(R.id.search)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 키보드의 검색 버튼을 클릭한 순간의 이벤트
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                // 검색어 변경 이벤트
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}