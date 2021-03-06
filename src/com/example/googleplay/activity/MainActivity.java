package com.example.googleplay.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.googleplay.R;
import com.example.googleplay.base.BaseActivity;
import com.example.googleplay.fragment.Fragment1;
import com.example.googleplay.view.MyButton;


public class MainActivity extends BaseActivity {

	private ActionBar mActionBar;
	private DrawerLayout mDrawerLayout; // 抽屉
	private ActionBarDrawerToggle mDrawerToggle; // 抽屉开关
	private FrameLayout fl_left;
	private List<View> list;
	private ViewPager mViewPager;
	private PagerSlidingTabStrip mTabStrip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findView();
		// 初始化数据
		 initData();
		// 初始化actionbar
		initView();
	}

	private void initData() {
		// TODO Auto-generated method stub
		list = new ArrayList<View>();
		LayoutInflater inflater = getLayoutInflater();
		View tv1 = inflater.inflate(R.layout.left_item, null);
		MyButton btn1 = (MyButton) tv1.findViewById(R.id.btn);
		btn1.setText("btn1");
		View tv2 = inflater.inflate(R.layout.left_item, null);
		MyButton btn2 = (MyButton) tv2.findViewById(R.id.btn);
		btn2.setText("btn2");
		View tv3 = inflater.inflate(R.layout.left_item, null);
		MyButton btn3 = (MyButton) tv3.findViewById(R.id.btn);
		btn3.setText("btn3");
		View tv4 = inflater.inflate(R.layout.left_item, null);
		MyButton btn4 = (MyButton) tv4.findViewById(R.id.btn);
		btn4.setText("btn4");
		list.add(tv4);
		list.add(tv3);
		list.add(tv2);
		list.add(tv1);
	}
	
	private void initView() {
		// TODO Auto-generated method stub
		initActionBar();
		initContent();
	}
	private void initContent() {
		// TODO Auto-generated method stub
		mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		mTabStrip.setViewPager(mViewPager);
	}
	
	private void findView() {
		// TODO Auto-generated method stub
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mTabStrip = (PagerSlidingTabStrip) findViewById(R.id.pager_sliding);
		fl_left = (FrameLayout) findViewById(R.id.fl_left);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	}
	
	private void initActionBar() {
		LayoutInflater inflater = getLayoutInflater();
		FrameLayout left_fragment = (FrameLayout) inflater.inflate(R.layout.left_fragment, null);
		ListView lv = (ListView) left_fragment.findViewById(R.id.lv);
		lv.setAdapter(new MyAdapter(list));
		fl_left.addView(left_fragment);
		
		mActionBar = getSupportActionBar();
		mActionBar.setTitle("GooglePlay");
		//mActionBar.setSubtitle("鍓爣棰�");
		mActionBar.setIcon(R.drawable.ic_launcher);
		mActionBar.setLogo(R.drawable.ic_drawer_am);

		mActionBar.setDisplayShowTitleEnabled(true);// 璁剧疆鑿滃崟 鏍囬鏄惁鍙*/	
		mActionBar.setDisplayShowHomeEnabled(true);// 璁剧疆搴旂敤鍥炬爣鏄惁
		mActionBar.setDisplayUseLogoEnabled(false);// 璁剧疆鏄惁鏄剧ずLogo浼樺厛
		mActionBar.setDisplayHomeAsUpEnabled(true);// 璁剧疆back鎸夐挳鏄惁鍙

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer_am, R.string.drawer_des_open,
				R.string.drawer_des_close);
		// 设置drawerlayout的监听
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// 同步
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// 打开或关闭抽屉
			boolean selected = mDrawerToggle.onOptionsItemSelected(item);
			if (selected) {
				return true;
			}
			break;

		default:
			break;
		}return super.onOptionsItemSelected(item);
	}
	
	class MyPagerAdapter extends FragmentPagerAdapter  {
		
		String[] title = { "项目一", "项目二", "项目三", "项目四" };
		Fragment1 fragment1;
		Fragment1 fragment2;
		Fragment1 fragment3;
		Fragment1 fragment4;
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		/*@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView(list.get(position));
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(list.get(position));
			return list.get(position);
		}
		
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}*/

		@Override
		public CharSequence getPageTitle(int position) {
			return title[position];
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			switch (arg0) {
			case 0:
				fragment1 = new Fragment1();
				return fragment1;
			case 1:
				fragment1 = new Fragment1();
				return fragment1;
			case 2:
				fragment1 = new Fragment1();
				return fragment1;
			case 3:
				fragment1 = new Fragment1();
				return fragment1;
			default:
				break;
			}
			return null;
		}
	}
	
	class MyAdapter extends BaseAdapter{

		List<View> list;
		public MyAdapter(List<View> list) {
			// TODO Auto-generated constructor stub
			this.list = list;
		}
		
		
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return list.get(position);
		}
		
	}
}
