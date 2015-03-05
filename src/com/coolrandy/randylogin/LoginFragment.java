package com.coolrandy.randylogin;

import com.coolrandy.db.AccountbaseHelper;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


@SuppressLint("NewApi")
public class LoginFragment extends Fragment{
	
	private Button mLoginButton;
//	private Button mRegisterButton;
	private EditText mUsername;
	private EditText mPassword;
	
	private AccountbaseHelper dbHelper;
	public boolean login(String username,String password){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="select * from account where username=? and password=?";
		Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});		
		if(cursor.moveToFirst()==true){
			cursor.close();
			return true;
		}
		return false;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 
		View v = inflater.inflate(R.layout.login_layout, container, false);
		
		dbHelper = new AccountbaseHelper(this.getActivity());
		
		mUsername = (EditText) v.findViewById(R.id.account);
		mPassword = (EditText) v.findViewById(R.id.password);
		
		
		
		mLoginButton = (Button) v.findViewById(R.id.Login);
		mLoginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 
				//Toast.makeText(MainActivity.this, R.string.corrent_toast, Toast.LENGTH_SHORT).show();
				String name = mUsername.getText().toString();
				String pwd = mPassword.getText().toString();
//				PwdAccountService pwdService = new PwdAccountService(MainActivity.this);
//				boolean flag=pwdService.login(name, pwd);
				if(login(name, pwd)){
					Log.i("TAG","µÇÂ¼³É¹¦");
					Toast.makeText(getActivity(), "µÇÂ¼³É¹¦", Toast.LENGTH_LONG).show();
				}else{
					Log.i("TAG","µÇÂ¼Ê§°Ü");
					Toast.makeText(getActivity(), "µÇÂ¼Ê§°Ü", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		return v;
	}
	
}
