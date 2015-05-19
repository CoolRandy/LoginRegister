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
	//��Tab��������ʾloginͼ��Ŀؼ�
	private ImageView loginImage;
	//��Tab��������ʾregisterͼ��Ŀؼ�
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
		 // ��һ������ʱѡ�е�0��tab  
        setTabSelection(0);      
       
	}



	private void setTabSelection(int index) {
		// 
		// ÿ��ѡ��֮ǰ��������ϴε�ѡ��״̬  
        clearSelection();  
        // ����һ��Fragment����  
        FragmentTransaction transaction = fm.beginTransaction();  
        // �����ص����е�Fragment���Է�ֹ�ж��Fragment��ʾ�ڽ����ϵ����  
        hideFragments(transaction);  
        switch (index) {  
        case 0:  
            // ���������Ϣtabʱ���ı�ؼ���ͼƬ��������ɫ  
            loginImage.setImageResource(R.drawable.login);  
            loginText.setTextColor(Color.WHITE);  
            if (loginFragment == null) {  
                // ���MessageFragmentΪ�գ��򴴽�һ������ӵ�������  
            	loginFragment = new LoginFragment();  
                transaction.add(R.id.content, loginFragment);  
            } else {  
                // ���MessageFragment��Ϊ�գ���ֱ�ӽ�����ʾ����  
                transaction.show(loginFragment);  
            }  
            break;  
        case 1:  
            // ���������ϵ��tabʱ���ı�ؼ���ͼƬ��������ɫ  
            registerImage.setImageResource(R.drawable.register);  
            registerText.setTextColor(Color.WHITE);  
            if (registerFragment == null) {  
                // ���ContactsFragmentΪ�գ��򴴽�һ������ӵ�������  
            	registerFragment = new RegisterFragment();  
                transaction.add(R.id.content, registerFragment);  
            } else {  
                // ���ContactsFragment��Ϊ�գ���ֱ�ӽ�����ʾ����  
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
