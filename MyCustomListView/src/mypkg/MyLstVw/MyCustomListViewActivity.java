package mypkg.MyLstVw;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyCustomListViewActivity extends ListActivity {
	  private EfficientAdapter adap;
	  private static String[] data = new String[] { "0", "1", "2", "3", "4","5","6","7","8","9","10" };
	  int mCurCheckPosition=0;
	  ListView mylistview;

	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.main);
	    List<MyClass> list = new ArrayList<MyClass>();
	    for (int i = 1; i <= 30; i++){
	    	list.add(get("Item " + Integer.toString(i)));	
	    } 
	
	    adap = new EfficientAdapter(this,list);
	    setListAdapter(adap);
	   
	    adap.notifyDataSetChanged();
	  

	    
	    if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
          
            Log.d("MyLog", "onActivityCreated--mCurCheckPosition=" + mCurCheckPosition);
        }
	    mylistview=getListView();
	    mylistview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	    mylistview.setItemsCanFocus(true);
	  
	    
	    
	  }

	  
	  private MyClass get(String s) {
			return new MyClass(s);
		}
	  @Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("curChoice", mCurCheckPosition);
		Log.d("MyLog", "onSaveInstanceState--mCurCheckPosition=" + mCurCheckPosition);
	}

	@Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    // TODO Auto-generated method stub
	    super.onListItemClick(l, v, position, id);
	    Toast.makeText(this, "Click-" + String.valueOf(position), Toast.LENGTH_SHORT).show();
	    Log.d("MyLog", "onListItemClick--mCurCheckPosition=" + mCurCheckPosition);
	    Log.d("MyLog", "onListItemClick--position=" + position);
	  }

	  public static class EfficientAdapter extends ArrayAdapter<MyClass> {
		  
		  private final List<MyClass> list;
			private final Activity context;
			
		  public EfficientAdapter(Activity context, List<MyClass> list) {
			  super(context, R.layout.adaptor_content, list);
				this.context = context;
				this.list = list;
		
			// TODO Auto-generated constructor stub
		}
		  
		  @Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			  View view = null;
			  if (convertView == null) {
					LayoutInflater inflator = context.getLayoutInflater();
					view = inflator.inflate(R.layout.adaptor_content, null);
					final ViewHolder viewHolder = new ViewHolder();
					viewHolder.text = (TextView) view.findViewById(R.id.textLine);
					viewHolder.checkbox = (CheckBox) view.findViewById(R.id.checkBox1);
					viewHolder.btn=(Button)view.findViewById(R.id.buttonLine);
					
					
					view.setTag(viewHolder);
					viewHolder.checkbox.setTag(list.get(position));
					viewHolder.btn.setTag(list.get(position));
					viewHolder.text.setTag(list.get(position));
					
					//Log.d("MyLog", "viewHolder.checkbox.setTag="+ viewHolder.checkbox.getTag(position));
					viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
							MyClass element = (MyClass) viewHolder.checkbox.getTag();
							element.setSelected(buttonView.isChecked());
							if (element.isSelected() == true){
								
							Toast.makeText(context, "CheckBox element position =" + element.getName() + " Is checked",Toast.LENGTH_SHORT).show();
							}
							Log.d("MyLog", "onCheckedChanged="+ element.getName());

						}
					});
					
					viewHolder.btn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							
							MyClass element = (MyClass) viewHolder.btn.getTag();
							
							Toast.makeText(context, "Button element position =" + element.getName(),Toast.LENGTH_SHORT).show();
							
						}
					});
					
				
				} else {
					view = convertView;
					((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
					//((ViewHolder) view.getTag()).text.setTag(list.get(position));
				}
				ViewHolder holder = (ViewHolder) view.getTag();
				holder.text.setText(list.get(position).getName());
				holder.checkbox.setChecked(list.get(position).isSelected());
		
			
			        
			       
				
				
				return view;
			
		}

		static class ViewHolder {
				protected TextView text;
				protected CheckBox checkbox;
				protected Button btn;
			}

			
	  }

}