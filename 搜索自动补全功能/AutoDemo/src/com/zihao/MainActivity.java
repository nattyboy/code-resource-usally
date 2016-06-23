package com.zihao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.zihao.adapter.MyAdapter;
import com.zihao.db.DatabaseAdapter;
import com.zihao.utils.PinYin;

/**
 * 主界面
 * 
 * @author zihao
 * 
 */
public class MainActivity extends Activity {

	private EditText editText;
	private ListView mListView;
	private List<String> testArray = new ArrayList<String>();
	private MyAdapter adapter;

	/**
	 * 数组
	 */
	private String[] items = { "ab", "abc", "abcd", "ba", "bac", "bacd", "ca",
			"cb", "cab", "da", "dwe", "ee", "dfe", "fa", "fe", "ft", "gif",
			"hy", "in", "jack", "jie", "kol", "kfc", "lem", "lol", "me", "my",
			"north", "option", "pin", "qq", "row", "still", "there", "un",
			"visibility", "women", "xx", "yifu", "zihao", "你好", "紫豪", "你好啊",
			"东西", "玖哥", "修东", "DevStore" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		initView();

		// 每次进入前清空一下
		DatabaseAdapter.getIntance(this).deleteAll();

		// 向数据库中插入指定数据
		DatabaseAdapter.getIntance(this).inserInfo(getListArray(items));
	}

	/**
	 * 初始化视图
	 */
	private void initView() {

		editText = (EditText) findViewById(R.id.input_edit);
		mListView = (ListView) findViewById(R.id.auto_list);
		adapter = new MyAdapter(this, testArray);
		mListView.setAdapter(adapter);// 设置Adapter，初始值为空

		mListView.setOnItemClickListener(new OnItemClickListener() {// listView点击事件

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						editText.setText(adapter.getItem(position));
						mListView.setVisibility(View.GONE);
					}
				});

		editText.addTextChangedListener(new TextWatcher() {// EditText变化监听

			/**
			 * 正在输入
			 */
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				testArray = new ArrayList<String>();// 每次输入的时候，重新初始化数据列表

				if (!TextUtils.isEmpty(editText.getText().toString())) {// 判断输入内容是否为空，为空则跳过

					// 查询相似数据--传入一个转换为拼音的字符串
					testArray = DatabaseAdapter.getIntance(MainActivity.this)
							.queryInfo(
									PinYin.getPinYin(editText.getText()
											.toString()));
				}

				adapter.refreshData(testArray);// Adapter刷新数据
				mListView.setVisibility(View.VISIBLE);
			}

			/**
			 * 输入之前
			 */
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			/**
			 * 输入之后
			 */
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * 获取ArrayList数组
	 * 
	 * @param array
	 * @return
	 */
	private List<String> getListArray(String[] array) {
		List<String> titleArray = new ArrayList<String>();
		for (String title : array) {
			titleArray.add(title);
		}
		return titleArray;
	}

}