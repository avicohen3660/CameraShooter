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
        holder.image.setBackgroundResource(info.getElementUrlImage());

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

//    public class CardDetails{
//        TextView elementName, elementPrice;
//        ImageView elementImage;
//    }
//
//    public CardViewCustom(Context context, List<ElementInfo> objects) {
//        super(context, R.layout.card_element, objects);
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View card;
//        CardDetails cardDetails;
//
//        if (convertView == null) {
//
//            card = LayoutInflater.from(getContext()).inflate(R.layout.card_element, parent, false);
//
//            cardDetails = new CardDetails();
//            cardDetails.elementName = card.findViewById(R.id.textView1);
//            cardDetails.elementPrice = card.findViewById(R.id.textView2);
//            cardDetails.elementImage = card.findViewById(R.id.image);
//            card.setTag(cardDetails);
//        } else {
//            card = convertView;
//            cardDetails = (CardDetails) card.getTag();
//        }
//
//        ElementInfo item = getItem(position);
//        cardDetails.elementName.setText(item.getElementName());
//        cardDetails.elementPrice.setText(item.getElementPrice());
//        cardDetails.elementImage.setTag(item.getElementUrlImage()); // todo this maybe wont work! <------
////        Picasso.get().load(item.getElementUrlImage()).resize(400,400).transform(new RoundedCornersTransformation(300, 0)).into(cardDetails.elementImage);
//
//        return card;
//    }
}
