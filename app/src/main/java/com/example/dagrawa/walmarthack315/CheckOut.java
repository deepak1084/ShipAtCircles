package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/4/16.
 */

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.RadioButton;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.util.HashSet;
        import java.util.Iterator;

        import static java.lang.StrictMath.round;

/**
 * Created by hp on 03-04-2016.
 */
public class CheckOut extends Activity {
    TextView tt2 ;
    TextView tt3;
    Double total_price;
    Double total;
Context con= null;
    boolean normal = true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        con = this;
        setContentView(R.layout.checkout);
        Intent intent = getIntent();
        tt2 = (TextView) findViewById(R.id.Shipping_Amount);
        tt3 = (TextView)findViewById(R.id.Total_Amount);
        total_price = intent.getDoubleExtra("total_price", 0.0);
        Math.round(total_price);
        int Count1 = intent.getIntExtra("Count", 0);


        TextView tt = (TextView) findViewById(R.id.itemssize);
        tt.setText(String.valueOf(Count1));
        TextView tt1 = (TextView) findViewById(R.id.Subtotal_Amount);
        tt1.setText("$" + String.valueOf(total_price));

        RadioButton rr = (RadioButton)findViewById(R.id.radioButton);
        RadioButton rr2 = (RadioButton)findViewById(R.id.radioButton2);
        tt2.setText("$15");
        total = total_price +15.0;
        Math.round(total);

        tt3.setText("$" + String.valueOf(Math.round(total)));
        rr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tt2.setText("$15");
                 total= total_price + 15.0;
                Math.round(total);
                tt3.setText("$" + String.valueOf(Math.round(total)));
                normal = false;

            }
        });
        rr2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tt2.setText("$5");
                total = total_price +5.0;
                Math.round(total);
                tt3.setText("$" + String.valueOf(Math.round(total)));
                normal= true;
            }
        });







        //   TextView tt = (TextView) findViewById(R.id.total_price);
        //   tt.setText(String.valueOf(total_price));
        System.out.println(total_price);
        HashSet<Integer> position = (HashSet)intent.getSerializableExtra("set");
        final String[] items = {"Apple iPhone 6s (Space Grey" +
                ", 64GB)\n\n$649.00","Harry Potter and the Goblet of Fire\n\n$10.00","RCA Home Theatre System with Bluetooth\n\n$90.00","RCA gaming controller\n\n$49.99","SanDisk Ultra MicroSD 64GB\n\n$30.00","Photron Tripod Stand\n\n$17.00"};
        int[] itemImages = {R.drawable.iphone,R.drawable.book,R.drawable.home_theatre,R.drawable.controller,R.drawable.sdcard,R.drawable.tripod};
        final String[] items1 = new String[position.size()];
        int[] itemImages1 = new int[position.size()];
        int j =0 ;
        Iterator<Integer> it = position.iterator();

        while(j < position.size()) {
            System.out.println("j**" + j);
            int a = (int)it.next();
            items1[j] = items[a];
            itemImages1[j++] = itemImages[a];
        }


        ListAdapter myAdapter = new CustomAdapter1(this, items1, itemImages1);
        ListView dinesListView = (ListView)findViewById(R.id.ItemListView);

        dinesListView.setAdapter(myAdapter);
        Button b = (Button)findViewById(R.id.checkoutToShipping);
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con,ShippingCart.class);
                intent.putExtra("ShippingMethod",normal);
                intent.putExtra("TotalPrice", total);
                startActivity(intent);
            }
        });
    }
}