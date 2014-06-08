package com.sharpersharp.tomylove;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class CreateActivity extends Activity {

	private static final int SELECT_PICTURE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create, menu);
		return true;
	}
	
	public void uploadImage(View view){
		
		      //  Toast.makeText(CreateActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
		    //    Intent intent = new Intent();
            ////    intent.setType("image/*");
             //   intent.setAction(Intent.ACTION_GET_CONTENT);
              //  intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
              //  startActivityForResult(Intent.createChooser(intent,
                //        "Select Picture"), SELECT_PICTURE);
                
                Intent intentCreate = new Intent(this, CustomeGalleryActivity.class);
    	    	startActivity(intentCreate);
		
		    }
	
	public void uploadSong(View view){
		
        Toast.makeText(CreateActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();

    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK
				&& null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			Toast.makeText(CreateActivity.this, picturePath, Toast.LENGTH_SHORT)
					.show();

			// String picturePath contains the path of selected Image
		}

	}
}
