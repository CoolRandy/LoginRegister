package com.coolrandy.randylogin;

import com.coolrandy.db.AccountbaseHelper;
import com.coolrandy.domin.PwdAccount;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


@SuppressLint("NewApi")
public class RegisterFragment extends Fragment{
	
	EditText username;
	EditText password;
	EditText rePassword;
	Button register;
	private AccountbaseHelper dbHelper;
	public boolean register(PwdAccount accounter){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into account(username,password) values(?,?)";
		Object obj[]={accounter.getUsername(),accounter.getPassword()};
		sdb.execSQL(sql, obj);	
		return true;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 
		
		super.onCreate(savedInstanceState);
	}
		


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 
		View v = inflater.inflate(R.layout.register_layout, container, false);
		findViews(v);
		
		dbHelper = new AccountbaseHelper(this.getActivity());
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=username.getText().toString().trim();
				String pass=password.getText().toString().trim();
				String rePass = rePassword.getText().toString().trim();
				
	//			PwdAccountService pwdService = new PwdAccountService(RegisterActivity.this);
				if(rePass.equals(pass))
				{
					PwdAccount accounter=new PwdAccount();
					accounter.setUsername(name);
					accounter.setPassword(pass);
					register(accounter);
					Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_LONG).show();
				}else if(name.equals("")){
					Toast.makeText(getActivity(), "用户名不能为空", Toast.LENGTH_LONG).show();
				}else if(pass.equals("")){
					Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_LONG).show();
				}else if(!(rePass.equals(pass))){
					Toast.makeText(getActivity(), "两次密码输入不一致", Toast.LENGTH_LONG).show();
				}
				
			}
		});
	
		return v;
	}
	
	private void findViews(View v) {
		username=(EditText) v.findViewById(R.id.accountRegister);
		password=(EditText) v.findViewById(R.id.passwordRegister);
		rePassword = (EditText) v.findViewById(R.id.passwordConfirm);
		register=(Button) v.findViewById(R.id.Register);
	}
	
}

