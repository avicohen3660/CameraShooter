package CustomCard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.camerashooter.ConnectionActivity;
import com.example.camerashooter.R;

import java.util.List;

import shop_fragments.ShopActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ElementInfo> elementInfos;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;
    private ShopActivity shopActivity;

    // data is passed into the constructor
    public RecyclerViewAdapter(Context context, List<ElementInfo> info, ShopActivity shopActivity) {
        this.mInflater = LayoutInflater.from(context);
        this.elementInfos = info;
        this.context = context;
        this.shopActivity = shopActivity;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_element, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ElementInfo info = elementInfos.get(position);
        holder.name.setText(info.getElementName());
        holder.price.setText(info.getElementPrice() + "");
        holder.image.setImageResource(info.getElementUrlImage());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return elementInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView price;
        ImageView image;
        Button button;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.element_name);
            price = itemView.findViewById(R.id.element_price);
            image = itemView.findViewById(R.id.element_image);
            button = itemView.findViewById(R.id.purchase_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!shopActivity.setMoney(-Integer.parseInt(price.getText().toString())))
                        Toast.makeText(context, "You don't have enough money", Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ElementInfo getItem(int id) {
        return elementInfos.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
