package com.koshurboii.AutoStartPermissionHelper;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private AutoStartPermissionHelper autoStartPermissionHelper;
	
	private LinearLayout linear1;
	private TextView textview1;
	private TextView textview2;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
	}
	
	private void initializeLogic() {
		       
		       autoStartPermissionHelper = AutoStartPermissionHelper.getInstance();
		
		        // Check if the auto-start permission is available on the device
		        boolean isAutoStartPermissionAvailable = autoStartPermissionHelper.isAutoStartPermissionAvailable(this, false);
		
		        // Display a toast message indicating whether the permission is available or not
		        Toast.makeText(this, "Auto-start permission is " + (isAutoStartPermissionAvailable ? "available" : "not available"), Toast.LENGTH_SHORT).show();
		
		        // If the permission is available, request it
		        if (isAutoStartPermissionAvailable) {
			            boolean granted = autoStartPermissionHelper.getAutoStartPermission(this, true, false);
			
			            // Display a toast message indicating whether the permission was granted or not  (It won't work but  because Android doesn't to provide any API for that ,I added it anyway.)
			            Toast.makeText(this, "Auto-start permission " + (granted ? "granted" : "denied"), Toast.LENGTH_SHORT).show();
			        }
		    
		
		
		        
	}
	
}
