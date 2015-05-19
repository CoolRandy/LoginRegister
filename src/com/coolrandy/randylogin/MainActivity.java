package com.coolrandy.randylogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coolrandy.db.AccountbaseHelper;


@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener{
	
	
	//
	private LoginFragment loginFragment;
	private RegisterFragment registerFragment;
	//
	private View loginLayout;
	private View registerLayout;
	//在Tab布局上显示login图标的控件
	private ImageView loginImage;
	//在Tab布局上显示register图标的控件
	private ImageView registerImage;
	//
	private TextView loginText;
	private TextView registerText;
	
	private FragmentManager fm ;
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.activity_main);
		
		initViews();
		fm = getFragmentManager();
		 // 第一次启动时选中第0个tab  
        setTabSelection(0);      
       
	}



	private void setTabSelection(int index) {
		// 
		// 每次选中之前先清楚掉上次的选中状态  
        clearSelection();  
        // 开启一个Fragment事务  
        FragmentTransaction transaction = fm.beginTransaction();  
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况  
        hideFragments(transaction);  
        switch (index) {  
        case 0:  
            // 当点击了消息tab时，改变控件的图片和文字颜色  
            loginImage.setImageResource(R.drawable.login);  
            loginText.setTextColor(Color.WHITE);  
            if (loginFragment == null) {  
                // 如果MessageFragment为空，则创建一个并添加到界面上  
            	loginFragment = new LoginFragment();  
                transaction.add(R.id.content, loginFragment);  
            } else {  
                // 如果MessageFragment不为空，则直接将它显示出来  
                transaction.show(loginFragment);  
            }  
            break;  
        case 1:  
            // 当点击了联系人tab时，改变控件的图片和文字颜色  
            registerImage.setImageResource(R.drawable.register);  
            registerText.setTextColor(Color.WHITE);  
            if (registerFragment == null) {  
                // 如果ContactsFragment为空，则创建一个并添加到界面上  
            	registerFragment = new RegisterFragment();  
                transaction.add(R.id.content, registerFragment);  
            } else {  
                // 如果ContactsFragment不为空，则直接将它显示出来  
                transaction.show(registerFragment);  
            }  
            break;  
        }
        transaction.commit();
	}



	private void clearSelection() {
		// 
		loginImage.setImageResource(R.drawable.unselect_login);  
        loginText.setTextColor(Color.parseColor("#82858b")); 
        registerImage.setImageResource(R.drawable.unselect_register);  
        registerText.setTextColor(Color.parseColor("#82858b")); 		
	}



	private void hideFragments(FragmentTransaction transaction) {
		// 
		if(loginFragment != null)
		{
			transaction.hide(loginFragment);
		}	
		if(registerFragment != null)
		{
			transaction.hide(registerFragment);
		}	
	}



	private void initViews() {
		// 
		loginLayout = findViewById(R.id.login_layout);
		registerLayout = findViewById(R.id.register_layout);
		
		loginImage = (ImageView) findViewById(R.id.login_image);
		registerImage = (ImageView) findViewById(R.id.register_image);
		
		loginText = (TextView) findViewById(R.id.login_text);
		registerText = (TextView) findViewById(R.id.register_text);
		
		loginLayout.setOnClickListener(this);
		registerLayout.setOnClickListener(this);
		
	}



	@Override
	public void onClick(View v) {
		// 
		switch(v.getId())
		{
		case R.id.login_layout:
			setTabSelection(0);
			break;
		case R.id.register_layout:
			setTabSelection(1);
			break;
		default:
			break;
		}
	}
	
	

}
