import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fa_abhilash_c0880745_android.R;
import com.example.fa_abhilash_c0880745_android.Updateprod;

import java.util.ArrayList;

public class prodAdapter extends RecyclerView.Adapter<prodAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<prodmodel> prodmodelArrayList;
    private Context context;

    // constructor
    public prodAdapter(ArrayList<prodmodel> courseModalArrayList, Context context) {
        this.prodmodelArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prod_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        prodmodel model =prodmodelArrayList.get(position);
        holder.prodid.setText(model.getproductid());
        holder.prodname.setText(model.getProductname());
        holder.proddescription.setText(model.getProductdescription());
        holder.prodprice.setText(model.getProductprice());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return prodmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView prodid, prodname, proddescription, prodprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            prodid = itemView.findViewById(R.id.prodid1);
            prodname = itemView.findViewById(R.id.prodname1);
            proddescription = itemView.findViewById(R.id.proddesc1);
            prodprice = itemView.findViewById(R.id.prodprice1);


            // below line is to add on click listener for our recycler view item.
            RecyclerView.ViewHolder holder = null;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // on below line we are calling an intent.
                    Intent i = new Intent(context, Updateprod.class);

                    // below we are passing all our values.
                    i.putExtra("ID", prodmodel.getprodid());
                    i.putExtra("description", prodmodel.getCourseDescription());
                    i.putExtra("duration", modal.getCourseDuration());
                    i.putExtra("tracks", modal.getCourseTracks());

                    // starting our activity.
                    context.startActivity(i);
                }
            });

        }
    }
}
