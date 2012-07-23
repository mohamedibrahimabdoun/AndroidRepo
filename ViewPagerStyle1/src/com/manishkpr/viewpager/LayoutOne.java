
package com.manishkpr.viewpager;



import java.util.ArrayList;
import java.util.List;





import com.CustomClasses.Restaurants;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LayoutOne extends ListFragment {

	  private EfficientAdapter adap;
	  private static String[] data = new String[] { "0", "1", "2", "3", "4","5","6","7","8","9","10" };
	  int mCurCheckPosition=0;
	  ListView mylistview;
	   
	  private static LayoutInflater mInflater;

		public static Fragment newInstance(Context context) {
			LayoutOne f = new LayoutOne();	
			
			return f;
		}

	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	   
	  
	    List<Restaurants> list = new ArrayList<Restaurants>();
	    for (int i = 1; i <= 20; i++){
	    	Restaurants rest=new Restaurants();
	    	rest.setREST_ID(i);
	    	rest.setREST_IMAGE_NAME("rEST_IMAGE_NAME" + Integer.toString(i));
	    	rest.setREST_EMAIL("rEST_EMAIL" + Integer.toString(i) +"@x.com" );
	    	rest.setREST_PATH("rEST_PATH" +Integer.toString(i));
	    	rest.setREST_WEBSITE("rEST_WEBSITE" + Integer.toString(i));
	    	rest.setREST_NAME("rEST_NAME"+Integer.toString(i));
	    	list.add(rest);	
	    	
	    } 
	
	    adap = new EfficientAdapter(this.getActivity(),list);
	    setListAdapter(adap);
	    Log.d("MylistSize=" ,Integer.toString(list.size()));
	    Log.d("Mylistadap=" ,Integer.toString(adap.getCount()));
	   // Log.d("MygetREST_NAME=" ,list.get(5).getREST_NAME());

	    
	   
	
	  
	    
	    
	  }

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			//adap = new EfficientAdapter(getActivity(),list);
			// setListAdapter(adap);
		
		}
	  
	  private Restaurants get(String s) {
			return  new Restaurants();
		}
	
	  public static class EfficientAdapter extends ArrayAdapter<Restaurants> {
		  
		  private final List<Restaurants> locallist;
			private final Activity context;
			
		  public EfficientAdapter(Activity context, List<Restaurants> list) {
		
			  super(context, R.layout.adaptor_content, list);
				this.context = context;
				this.locallist = list;
				
				   mInflater = LayoutInflater.from(context);
			
		
			// TODO Auto-generated constructor stub
		}
		  
		  @Override
		public View getView(int position, View convertView, ViewGroup parent) {
		      // A ViewHolder keeps references to children views to avoid
		      // unneccessary calls
		      // to findViewById() on each row.
		      final ViewHolder holder;

		      // When convertView is not null, we can reuse it directly, there is
		      // no need
		      // to reinflate it. We only inflate a new View when the convertView
		      // supplied
		      // by ListView is null.
		      if (convertView == null) {
		        convertView = mInflater.inflate(R.layout.adaptor_content, null);

		        // Creates a ViewHolder and store references to the two children
		        // views
		        // we want to bind data to.
		        holder = new ViewHolder();
		        holder.textLine = (TextView) convertView.findViewById(R.id.textLine);
		        holder.textLine2 = (TextView) convertView.findViewById(R.id.textLine2);
		        holder.buttonLine = (Button) convertView.findViewById(R.id.buttonLine);
		        holder.editline=(EditText ) convertView.findViewById(R.id.editLine);
		       holder.mycheckbox=(CheckBox ) convertView.findViewById(R.id.checkBox1);
		       
					
		       convertView.setTag(holder);
		        holder.textLine.setTag(locallist.get(position));
		        holder.textLine2.setTag(locallist.get(position));
		        holder.mycheckbox.setTag(locallist.get(position));
		        
		        holder.mycheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					
					public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
						// TODO Auto-generated method stub
						Restaurants element = (Restaurants) holder.mycheckbox.getTag();
						element.setSelected(buttonView.isChecked());
						if (element.isSelected() == true){
							
						Toast.makeText(context, "CheckBox element position =" + element.getREST_ID() + " Is checked",Toast.LENGTH_SHORT).show();
						}
					

						
					}
				});
			
					
					
				
				} else {
				    holder = (ViewHolder) convertView.getTag();
					((ViewHolder) convertView.getTag()).mycheckbox.setTag(locallist.get(position));
					//((ViewHolder) view.getTag()).text.setTag(list.get(position));
				}
		      
		      
		     
		      
		      ViewHolder  Myholder  = (ViewHolder) convertView.getTag();
		      Myholder.textLine.setText(locallist.get(position).getREST_EMAIL());
		      Myholder.textLine2.setText(locallist.get(position).getREST_WEBSITE());
		      Myholder.mycheckbox.setChecked(locallist.get(position).isSelected());
		
			
			        
			       
				
				
				return convertView;
			
		}

		static class ViewHolder {
		     TextView textLine;
		      TextView textLine2;
		      ImageView iconLine;
		      Button buttonLine;
		      EditText editline;
		      CheckBox mycheckbox;
			}

			
	  }

	  

}
