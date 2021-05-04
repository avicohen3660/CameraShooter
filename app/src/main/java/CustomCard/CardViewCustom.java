package CustomCard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.camerashooter.R;

import java.util.List;

public class CardViewCustom extends ArrayAdapter<ElementInfo> {

    public class CardDetails{
        TextView elementName, elementPrice;
        ImageView elementImage;
    }

    public CardViewCustom(Context context, List<ElementInfo> objects) {
        super(context, R.layout.card_element, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View card;
        CardDetails cardDetails;

        if (convertView == null) {

            card = LayoutInflater.from(getContext()).inflate(R.layout.card_element, parent, false);

            cardDetails = new CardDetails();
            cardDetails.elementName = card.findViewById(R.id.textView1);
            cardDetails.elementPrice = card.findViewById(R.id.textView2);
            cardDetails.elementImage = card.findViewById(R.id.image);
            card.setTag(cardDetails);
        } else {
            card = convertView;
            cardDetails = (CardDetails) card.getTag();
        }

        ElementInfo item = getItem(position);
        cardDetails.elementName.setText(item.getElementName());
        cardDetails.elementPrice.setText(item.getElementPrice());
        cardDetails.elementImage.setTag(item.getElementUrlImage()); // todo this maybe wont work! <------
//        Picasso.get().load(item.getElementUrlImage()).resize(400,400).transform(new RoundedCornersTransformation(300, 0)).into(cardDetails.elementImage);

        return card;
    }
}
